package by.it.baranovskaya.jd01_11;

import java.util.*;

class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[1];
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public T get(int index)
    {
        return elements[index];
    }

    @Override
    public T remove(int index) {
        T prev = elements[index];
        System.arraycopy(elements, index + 1, elements, index, --size - index);
        return prev;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean flag = false;
        for (T el : c) {
            if(add(el)){
                flag = true;
            }

        }
        return flag;
    }

    @Override
    public void add(int index, T element) {
        T[] temp = (T[]) new Object[size - index];
        System.arraycopy(elements, index, temp, 0,  size - index );
        for (T a:temp) {
            System.out.println(a);
        }
        elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        elements[index] = element;
        size++;
        System.arraycopy(temp,0, elements, index + 1, temp.length);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter)
                    .append(elements[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public T set(int index, T element) {
        T prev = elements[index];
        elements[index] = element;
        return prev;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
