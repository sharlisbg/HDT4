package scr;
public class SinglyLinkedList<T> extends AbstractList<T> {

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove(T value) {
        if (head == null) {
            return;
        }

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

   
}
