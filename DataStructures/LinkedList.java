import java.util.*;

public class LinkedList<T> {

    private int size;
    private LinkedListNode<T> head, tail;

    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {
        LinkedListNode<T> temp = head;
        int nSize=0;
        while (temp.hasNext()) {
            temp = temp.next;
            nSize++;
        }
        size = nSize;
        return size;
    }


    public boolean isEmpty() {
        return size==0;
    }


    public Iterator<T> iterator() {
        return null;
    }

    public void addFirst(T o) {
        LinkedListNode<T> node = new LinkedListNode<>(o);
        node.next = head;
        head = node;
        size++;
    }
    public void addLast(T o) {
        LinkedListNode<T> node = new LinkedListNode<>(o);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        LinkedListNode<T> temp = head;
        while (temp.hasNext()) {
            temp = temp.next;
        }
        temp.next=node;
        tail = node;
        size++;
    }
    public boolean add(LinkedListNode<T> o) {
        LinkedListNode<T> temp = head;
        while (temp.hasNext())
            temp = temp.next;
        temp.next = o;
        return true;
    }

    public T removeFirst() {
        if (head == null)
            return null;
        T temp = head.value;
        if (head==tail)
            head = tail = null;
        else
            head = head.next;
        size--;
        return temp;
    }

    public T removeLast() {
        if (tail == null)
            return null;
        T temp = tail.value;
        LinkedListNode<T> current = head.next;
        LinkedListNode<T> previous = head;
        if (head==tail)
            head = tail = null;
        else {
            while(current != tail) {
                previous = current;
                current = current.next;
            }
        }
        previous.next = null;
        tail = previous;
        size--;
        return temp;
    }

    public boolean remove(LinkedListNode<T> o) {
        return false;
    }


    public void sort(Comparator<T> comparator) {

    }


    public T get(int index) {
        LinkedListNode<T> temp = head;
        for (int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp.getValue();
    }


    public T set(int i, T o) {
        return null;
    }


    public void add(int i, T o) {

    }


    public T remove(int i) {
        return null;
    }


    class LinkedListNode<T> {

        T value;
        LinkedListNode<T> next;

        public LinkedListNode() {

        }

        public LinkedListNode(T value) {
            this.value = value;
            next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public LinkedListNode<T> getNext() {
            return next;
        }

        public void setNext(LinkedListNode<T> next) {
            this.next = next;
        }
        public boolean hasNext() {
            return next==null;
        }
    }
}

