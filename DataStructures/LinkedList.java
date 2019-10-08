import java.util.*;

public class LinkedList<T> {

    private int size;
    private LinkedListNode<T> head;

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


    public boolean add(LinkedListNode<T> o) {
        LinkedListNode<T> temp = head;
        while (temp.hasNext())
            temp = temp.next;
        temp.next = o;
        return true;
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
}

class LinkedListNode<T> {

    T value;
    LinkedListNode<T> next;

    public LinkedListNode() {

    }

    public LinkedListNode(T value) {
        this.value = value;
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
