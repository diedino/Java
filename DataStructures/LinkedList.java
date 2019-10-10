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


    public Iterator<T> iterator() {
        return null;
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
        temp.next=node;
        tail = node;
        size++;
    }
    public boolean add(T o) {
        Node<T> added = new Node<>(o);
        Node<T> temp = head;
        while (temp.hasNext())
            temp = temp.next;
        temp.next = added;
        tail = added;
        size++;
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
        Node<T> temp = head;
        for (int index=0; index<index; index++) {
            temp = temp.next;
        }
        return temp.getValue();
    }


    public void set(int i, T o) {
        Node<T> temp = head;
        if (i>size-1)
            return;
        for(int index=0; index<i; index++) {
            temp = temp.next;
        }
        temp.setValue(o);
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
    }

    public void print() {
        Node<T> temp = head;
        while (temp.hasNext()) {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println(temp.value);
    }


    class Node<T> {

        T value;
        Node<T> next;

        public Node() {

        }

        public Node(T value) {
            this.value = value;
            next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next!=null;
        }
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println(ll.isEmpty());
        ll.addFirst(11);
        ll.add(12);
        ll.add(13);
        ll.print();
        ll.set(0,2);
        ll.add(14);
        ll.add(15);
        ll.print();
        ll.remove(3);
        ll.print();
    }
}

