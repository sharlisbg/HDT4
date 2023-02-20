public abstract class AbstractList<T> implements Lista<T> {
    protected Node<T> head;
    public AbstractList() {
    }

    protected static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public abstract void add(T value);

    public abstract void remove(T value);
    
}