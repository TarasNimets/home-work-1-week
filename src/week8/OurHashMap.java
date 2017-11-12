package week8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OurHashMap<K, V> implements Iterable<Entry<K, V>> {

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int size;
    private Node<K, V>[] table;

    @SuppressWarnings("unchecked")
    public OurHashMap() {
        table = (Node<K, V>[]) new Node[INITIAL_CAPACITY];
    }

    public final V put(K key, V value) {
        if (table.length * LOAD_FACTOR < size) {
            if (!rehashing()) {
                System.out.println("so much size");
                return null;
            }
        }
        int i = (table.length - 1) & key.hashCode();
        V toReturn = null;
        if (table[i] == null) {
            table[i] = new Node<>(key, value, null);
            toReturn = value;
            size++;
        } else {
            Node<K, V> current = table[i];
            Node<K, V> previous = table[i];
            do {
                if (current.key.equals(key)) {
                    if (current == previous) {
                        previous = new Node<>(key, value, previous.next);
                        toReturn = null;
                        break;
                    } else {
                        toReturn = previous.value;
                        previous.next = new Node<>(key, value, current.next);
                        break;
                    }
                }
                if (current.next == null) {
                    current.next = new Node<>(key, value, null);
                    toReturn = value;
                    size++;
                    break;
                }
                previous = current;
                current = current.next;
            } while (true);
            if (current.equals(table[i]) && current == table[i]) {
                table[i] = previous;
            }
        }
        return toReturn;
    }

    private final boolean rehashing() {
        int newLength = table.length << 1;
        if (newLength >= Integer.MAX_VALUE)
            return false;
        @SuppressWarnings("unchecked")
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newLength];
        Node<K, V>[] oldTable = table;
        table = newTable;
        Iterator<Entry<K, V>> iterator = iterator(oldTable);
        while (iterator.hasNext()) {
            Node<K, V> entry = (Node<K, V>) iterator.next();
            int i = (table.length - 1) & entry.key.hashCode();
            if (table[i] == null) {
                table[i] = entry;
            } else {
                Node<K, V> current = table[i];
                Node<K, V> next;
                while ((next = current.next) != null) {
                    current = next;
                }
                current.next = entry;
            }
        }
        return true;
    }

    public final int size() {
        return size;
    }

    public final boolean isEmpty() {
        return size == 0;
    }

    public final V get(Object key) {
        int i = (table.length - 1) & key.hashCode();
        if (table[i] != null) {
            if (table[i].next == null && table[i].key.equals(key)) {
                return table[i].value;
            } else {
                Node<K, V> next = table[i];
                Node<K, V> current;
                do {
                    current = next;
                    if (current.key.equals(key))
                        return current.value;
                } while ((next = current.next) != null);
            }
        }
        return null;
    }

    public final boolean containsKey(Object key) {
        return get(key) != null;
    }

    public final List<K> getKeySet() {
        Iterator<Entry<K, V>> iterator = iterator();
        ArrayList<K> arrayList = new ArrayList<>();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next().getKey());
        }
        return arrayList;
    }

    public final List<V> getValueSet() {
        Iterator<Entry<K, V>> iterator = iterator();
        ArrayList<V> arrayList = new ArrayList<>();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next().getValue());
        }
        return arrayList;
    }

    public final V remove(Object key) {
        if (get(key) == null) {
            System.out.println("get");
            return null;
        }
        V value = null;
        int i = (table.length - 1) & key.hashCode();
        if (table[i].next == null && table[i].key.equals(key)) {
            value = table[i].value;
            table[i] = null;
            size--;
        } else {
            Node<K, V> current = table[i];
            Node<K, V> next, previous = table[i];
            do {
                next = current.next;
                if (current.key.equals(key)) {
                    if (current == table[i]) {
                        value = current.value;
                        table[i] = next;
                        size--;
                    } else {
                        value = current.value;
                        current = null;
                        previous.next = next;
                    }
                }
                previous = current;
                current = next;
            } while (next != null);
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<Entry<K, V>> iterator = iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next()).append("\n");
        }
        return builder.toString();
    }

    private static final class Node<K, V> implements Entry<K, V> {

        private K key;
        private V value;
        private Node<K, V> next;

        private Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Node [");
            builder.append("key=").append(key).append(", ");
            builder.append("value=").append(value).append("]");
            return builder.toString();
        }

        @Override
        public final int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((key == null) ? 0 : key.hashCode());
            return result;
        }

        @Override
        public final boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (key == null) {
                if (other.key != null)
                    return false;
            } else if (!key.equals(other.key))
                return false;
            return true;
        }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

    }

    @Override
    public final Iterator<Entry<K, V>> iterator() {
        return new CustomIterator();
    }

    private Iterator<Entry<K, V>> iterator(Node<K, V>[] oldTable) {
        return new ResizeIterator(oldTable);
    }

    private class CustomIterator implements Iterator<Entry<K, V>> {

        Node<K, V>[] tab;
        Node<K, V> nextNode;
        Node<K, V> currentNode;
        int index;

        private CustomIterator() {
            tab = table;
            nextNode = null;
            currentNode = null;
            index = 0;
            if (tab != null && size > 0) {
                while ((nextNode = tab[index++]) == null && index < tab.length) {
                }
            }
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Entry<K, V> next() {
            currentNode = nextNode;
            if ((nextNode = currentNode.next) == null) {
                while (index < tab.length && (nextNode = tab[index++]) == null) {
                }
            }
            return currentNode;
        }

    }

    private final class ResizeIterator extends CustomIterator {

        private ResizeIterator(Node<K, V>[] oldTable) {
            tab = oldTable;
            nextNode = null;
            currentNode = null;
            index = 0;
            if (tab != null && size > 0) {
                while ((nextNode = tab[index++]) == null && index < tab.length) {
                }
            }
        }

        @Override
        public final Entry<K, V> next() {
            currentNode = nextNode;
            if ((nextNode = currentNode.next) == null) {
                while (index < tab.length && (nextNode = tab[index++]) == null) {
                }
            }
            currentNode.next = null;
            return currentNode;
        }
    }

}