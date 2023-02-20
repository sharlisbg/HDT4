package scr;
public abstract class AbstractList<T> implements Lista<T> {

    protected Node<T> head;

    public AbstractList() {
    }

    protected static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public Node(Node<T> next, Node<T> prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    public abstract void add(T value);

    public abstract void remove(T value);
    
}