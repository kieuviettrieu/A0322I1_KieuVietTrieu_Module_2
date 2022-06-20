package ss10_danhsach.baitap;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public void add(int index, E e) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) elements[i + 1] = elements[i];
        elements[index] = e;

        size++;
    }


    public int size()
    {
        return size;
    }

    public boolean contains(E o)
    {
        for (int i=0; i<size; i++)
        {
            if(elements[i].equals(o))
            {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o)
    {
        for (int i=0; i<size; i++)
        {
            if(elements[i].equals(o))
            {
                return i;
            }
        }
        return -1;
    }

    public void ensureCapacity() {
        if (size >= elements.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            elements = newData;
        }
    }

    public E get(int i)
    {
        if(i>=size) return null;

        E element=(E) elements[i];
        return element;
    }

    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public E remove(int index) {
        if(index>=size) return null;
        E e = (E) elements[index];

        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j + 1];

        elements[size - 1] = null;
        size--;
        return e;
    }


}
