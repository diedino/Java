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

    public void addFirst(T o) {
        Node<T> node = new Node<>(o);
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T o) {
        Node<T> node = new Node<>(o);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> temp = head;
        while (temp.hasNext()) {
            temp = temp.next;
        }
        temp.next = node;
        node.previous = temp;
        tail = node;
        size++;
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
/*
    public T removeFirst() {

    }
    public T removeLast() {

    }
    public void remove(int i) {

    }
*/
    public T get(int i) {
        if (i>size-1)
            return null;
        Node<T> temp = head;
        for (int index=0; index<i; index++) {
            temp = temp.next;
        }
        return temp.value;
    }








    public void print() {
        Node<T> temp = head;
        while (temp.hasNext()) {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println(temp.value);
    }

    public int getSize() {
        return size;
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
