package ss10_danhsach.baitap;

public class MyLinkedList<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size=0;

    public MyLinkedList() {
        this.head=null;
        this.tail=null;
    }

    public void addFirst(E e) {
        Node newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null)
            tail = head;
    }

    public void addLast(E e) {
        Node newNode = new Node<>(e);

        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node temp = current.next;
            current.next = new Node(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) return null; // Nothing to delete
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) return null;
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node current = head;

            for (int i = 0; i < size - 2; i++)
                current = current.next;

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    public boolean remove(E object) {
        if (size==0) return false;
        else if (object==(E)head.element)
        {
            removeFirst();
            return true;
        }
        else if (object==(E)tail.element)
        {
            removeLast();
            return true;
        }
        else {
            Node<E> previous = head.next;
            while (object!=(E)previous.next.element)
            {
                previous = previous.next;
            }
            Node current = previous.next;
            previous=current.next;
            size--;
            return true;
        }
    }

    public E getFirst()
    {
        if (head.element==null) return null;
        return head.element;
    }

    public E getLast()
    {
        if (tail.element==null) return null;
        return tail.element;
    }

    public E get(int index)
    {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return getFirst();
        else if (index == size - 1) return getLast();
        else {
            Node<E> previous = head;

            for (int i = 0; i < index; i++) {
                previous = previous.next;
            }
            return (E)previous.element;
        }
    }

    public boolean contains(E object)
    {
        if (size==0) return false;
        Node<E> previous = head;
        while (previous!=null)
        {
            if (object==(E)previous.element)
            {
                return true;
            }
            previous=previous.next;
        }
        return false;
    }

    public MyLinkedList<E> clone()
    {
        return this;
    }

    public void clear()
    {
        size=0;
        head=null;
        tail=null;
    }

    public int size()
    {
        return size;
    }

    class Node<E> {
        E element; Node<E> next;
        public Node(E e) {
            element = e;
        }
    }
}
