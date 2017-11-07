package week8;

import java.util.Arrays;

public class OurHashMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int size;
    private Node<K, V>[] table;

    @SuppressWarnings("unchecked")
    public OurHashMap() {
        table = (Node<K, V>[]) new Node[INITIAL_CAPACITY];
    }

    public V put(K key, V value) {
        if (table.length * LOAD_FACTOR < size) {
            System.out.println("rehashing" + table.length);
            if (!rehashing()) {
                System.out.println("so much size");
                return null;
            }
        }

        int i = (table.length - 1) & key.hashCode();
        System.out.println("place " + i);
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
                    toReturn = previous.value;
                    previous.next = new Node<>(key, value, null);
                    break;
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
        }
        return toReturn;
    }

    private boolean rehashing() {
        int oldLength = table.length;
        int newLength = oldLength << 1;
        if (newLength >= Integer.MAX_VALUE)
            return false;
        @SuppressWarnings("unchecked")
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newLength];
        Node<K, V>[] oldTable = table;
        table = newTable;
        if (oldTable != null) {
            for (int k = 0; k < oldTable.length; k++) {
                Node<K, V> tempNode;
                if ((tempNode = oldTable[k]) != null) {
                    oldTable[k] = null;
                    int i = (table.length - 1) & tempNode.key.hashCode();
                    if (tempNode.next == null) {
                        if (table[i] == null) {
                            table[i] = tempNode;
                            System.out.println("i" + i);
                        } else {
                            // table[i] != null ........ if not empty!!!
                            System.out.println("i not empty");
                        }

                    }else {
                        Node<K, V> next = null;
                        Node<K, V> newHead = null;
                        Node<K, V> oldTail = null;
                        Node<K, V> oldHead = null;

                        oldHead = tempNode;
                        do {
                            next = tempNode.next;
                            int j = (table.length - 1) & next.key.hashCode();
                            if (j != i) {
                                newHead = next;
                                if (table[j] == null) {
                                    table[j] = newHead;
                                    next = null;
                                    table[i] = oldHead;
                                }else {
                                    System.out.println("j not empty");
                                }
                            }
                                
                        }while ((tempNode = next) != null);
                    }
                }
            }
        }
        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "OurHashMap [table=" + Arrays.toString(table) + "]";
    }

    private static class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "\nNode [key=" + key + ", value=" + value + ", next=" + next + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((key == null) ? 0 : key.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
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

    }
}