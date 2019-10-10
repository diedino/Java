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

    public void addFirst() {

    }

    public void addLast() {

    }

    public void add(int i, T o) {
        Node<T> node = new Node<>(o);
        Node<T> temp = head;
        for (int index=0; index<i; index++) {
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        node.next = temp.next;
        temp.next = node;
        node.previous = temp;
        if (node.next != null)
            node.next.previous = node;
        size++;
    }

    public T removeFirst() {

    }
    public T removeLast() {

    }
    public void remove(int i) {

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
