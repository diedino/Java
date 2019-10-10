public class DoublyLinkedList<T> {
    private int size;
    private Node<T> head, tail;

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {
        Node<T> temp = head;
        int nSize=0;
        while (temp.hasNext()) {
            temp = temp.next;
            nSize++;
        }
        size = nSize;
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }















    class Node<T> {

        T value;
        Node<T> next, previous;

        public Node() {

        }

        public Node(T value) {
            this.value = value;
            next = null;
            previous = null;
        }
        public boolean hasNext() {
            return next!=null;
        }
        public boolean hasPrevious() {
            return previous!=null;
        }
    }
}
