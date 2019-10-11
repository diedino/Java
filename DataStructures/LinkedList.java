import java.util.*;

public class LinkedList<T> {

    private int size;
    private Node<T> head, tail;

    public LinkedList() {
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
        return size==0;
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
        tail = node;
        size++;
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
        Node<T> current = head.next;
        Node<T> previous = head;
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

    public boolean remove(Node<T> o) {
        return false;
    }


    public void sort(Comparator<T> comparator) {

    }


    public T get(int i) {
        if (i>size-1)
            return null;
        Node<T> temp = head;
        for (int index=0; index<i; index++) {
            temp = temp.next;
        }
        return temp.value;
    }


    public void set(int i, T o) {
        Node<T> temp = head;
        if (i>size-1)
            return;
        for(int index=0; index<i; index++) {
            temp = temp.next;
        }
        temp.value = o;
    }

    /**
     *
     * @param i - index after which value will be inserted
     * @param o - value
     */
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
        size++;
    }


    public void remove(int i) {
        if (i>size-1)
            return;
        Node<T> temp = head;
        for(int index=0; index<i-1; index++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
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

        private T value;
        private Node<T> next;

        public Node() {

        }

        public Node(T value) {
            this.value = value;
            next = null;
        }

        public boolean hasNext() {
            return next!=null;
        }
    }
}
