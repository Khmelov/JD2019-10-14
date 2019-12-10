package by.it.volchek.jd01_11;

import java.util.*;

//add(T e), remove(int index), get(int index), set(int index, T e), add(int index, T e),
// addAll(List<?> c) интерфейса List<T> (реализация остальных – фиктивная).
public class ListB<T> implements List<T> {
    private int size = 0;
    private T[] elements = (T[]) new Object[1];

    @Override
    public int size() {
        return this.size;
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
    public boolean add(T t) {
        if (elements.length==size){
            elements= Arrays.copyOf(elements, elements.length * 3 / 2 + 1);}
            elements [size++]=t;

        return true;
    }

    @Override
    public boolean remove(Object t) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
//        T[] added = (T[]) c.toArray();
//        if (elements.length==size){
//            elements= Arrays.copyOf(elements, elements.length * 3 / 2 + 1);}
//        System.arraycopy(added,0,elements,size+1,added.length);
//        size+=added.length;
        if (c.toArray().getClass() == this.elements.getClass()) {
            for (int i = 0; i < c.size(); i++) {
                this.add((T) c.toArray()[i]);
            }
            return true;
        }
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
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T deleted = elements[index];
        elements[index]= element;
        return deleted;
    }

    @Override
    public void add(int index, T element) {
        System.arraycopy(elements,index,elements,index+1,++size-index);
        elements[index]=element;
    }

    @Override
    public T remove(int index) {
        T deleted = elements[index];
        System.arraycopy(elements,index+1,elements,index,--size-index);
        return deleted;
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
    @Override
    public String toString() {
        if (size == 0) {
            return "List is empty.";
        }
        StringBuilder strBuilder = new StringBuilder();
        String delimiter = "";
        strBuilder.append("[");
        for (int i = 0; i < size; i++) {
            strBuilder.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        strBuilder.append("]");
        return strBuilder.toString();
    }
}
