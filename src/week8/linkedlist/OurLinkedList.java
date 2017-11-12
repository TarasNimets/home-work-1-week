package week8.linkedlist;

public class OurLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public final void add(T value) {
        size++;
        if (first == null && last == null) {
            first = last = new Node<>(null, null, value);
            return;
        }

        Node<T> newNode = new Node<>(last, null, value);
        last.next = newNode;
        last = newNode;
    }
    
    public final void prepend(T value) {
        if (first == null) {
            add(value);
            return;
        }
        Node<T> newNode = new Node<>(null, first, value);
        first = newNode;
        size++;
    }

    public final T get(int index) {
        if (index >= size || index < 0) return null;
        int i = 0;
        boolean moveUp = true;
        Node<T> node = first;
        if (index > (size / 2)) {
            moveUp = false;
            i = size - 1;
            node = last;
        }
        return getIndex(node, index, i, moveUp);
    }

    private T getIndex(Node<T> node, int index, int i, boolean moveUp) {
        if (moveUp) {
            if (i == size) return null;
            if (index == i) return node.value;
            i++;
            node = node.next;
        }else {
            if (i < 0) return null;
            if (index == i) return node.value;
            i--;
            node = node.previous;
        }
        return getIndex(node, index, i, moveUp);
    }
    
    public final T getFirst() {
        return first != null ? first.value : null;
    }

    public final T getLast() {
        return last != null ? last.value : null;
    }

    public final int size() {
        return size;
    }

    public final boolean contains(T value) {
        return getNode(first, value) != null;
    }

    private Node<T> getNode(Node<T> first, T value) {
        if (first == null)
            return null;
        if (first.value.equals(value))
            return first;
        return getNode(first.next, value);
    }
    
    public final boolean remove(T value) {
        return nodeForPemove(first, value);
    }

    private boolean nodeForPemove(Node<T> node, T value) {
        if (node == null) return false;
        if (node.value == value) {
            Node<T> prev = node.previous;
            Node<T> next = node.next;
            node = null;
            if (prev != null) prev.next = next;
            if (next != null) next.previous = prev;
            return true;
        }
        return nodeForPemove(node.next, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        return test(sb, first).append("]").toString();
    }

    private StringBuilder test(StringBuilder sb, Node<T> node) {
            if (node == null) return sb.append("");
        return test(sb.append(node), node.next);
    }

    private static class Node<T> {

        private Node<T> next;
        private Node<T> previous;
        private T value;

        private Node(Node<T> previous, Node<T> next, T value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
        
        public String toString() {
            return value + " "; 
        }
        

    }

}
