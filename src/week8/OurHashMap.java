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

    private boolean rehashing() {
        int oldLength = table.length;
        int newLength = oldLength << 1;
        if (newLength >= Integer.MAX_VALUE)
            return false;
        @SuppressWarnings("unchecked")
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newLength];
        Node<K, V>[] oldTable = table;
        table = newTable;

        for (int k = 0; k < oldTable.length; k++) {
            if (oldTable[k] != null) {
                int j = oldTable[k].key.hashCode() & (table.length - 1);
                if (oldTable[k].next == null) {
                    if (table[j] != null) {
                        Node<K, V> temp = table[j];
                        while (temp.next != null) {
                            temp = temp.next;
                        }
                        temp.next = oldTable[k];
                    } else {
                        table[j] = oldTable[k];
                    }
                } else {
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next,e;
                    e = oldTable[k];
                    do {
                        next = e.next;
                        if ((e.key.hashCode() & oldLength) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    if (loTail != null) {
                        loTail.next = null;
                        table[k] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        table[k + oldLength] = hiHead;
                    }
                }

//                    Node<K, V> current;
//                    Node<K, V> previous = oldTable[k];
//                    current = oldTable[k].next;
//                    int t = (table.length - 1) & current.key.hashCode();
//                    do {
//                        if (t != j) {
//                            previous.next = null;
//                            if (table[j] != null) {
//                                Node<K, V> temp = table[j];
//                                while (temp.next != null) {
//                                    temp = temp.next;
//                                }
//                                temp.next = previous;
//                            } else {
//                                table[j] = previous;
//                            }
//                            if (table[t] != null) {
//                                Node<K, V> temp = table[t];
//                                while (temp.next != null) {
//                                    temp = temp.next;
//                                }
//                                temp.next = current;
//                            } else {
//                                table[t] = current;
//                            }
//                        } else {
//                            if (current.next == null) {
//                                table[j] = previous;
//                            } else {
//                                System.out.println(oldTable[k]);
//                            }
//
//                        }
//                    } while (current.next != null);
            }
        }

        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OurHashMap [table=").append(Arrays.toString(table)).append("]");
        return builder.toString();
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
            StringBuilder builder = new StringBuilder();
            builder.append("\nNode [");
            if (key != null)
                builder.append("key=").append(key).append(", ");
            if (value != null)
                builder.append("value=").append(value);
            if (next != null)
                builder.append(", next=").append(next);
            builder.append("]");
            return builder.toString();
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