package by.it.komarov.jd01_11;

import java.util.*;

public class ListB <T> implements List <T> {

        private T[] elements = (T[]) new Object[1];
        private int size = 0;


        @Override
        public int size() {
            return 0;
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
        public <T1> T1[] toArray(T1[] t1s) {
            return null;
        }

        @Override
        public boolean add(T t) {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = t;
            return true;
        }

        @Override
        public boolean remove(Object o) {
            int i = indexOf(o);
            if (i >= 0) {
                remove(i);
                return true;
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> collection) {
            Object[] collectionNew = collection.toArray();
            elements = Arrays.copyOf(elements, elements.length + collectionNew.length);
            System.arraycopy(collectionNew, 0, elements, size, collectionNew.length);
            size = size+collectionNew.length;
            return true;
        }

        @Override
        public boolean addAll(int i, Collection<? extends T> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public T get(int i) {
            return elements[i];
        }

        @Override
        public T set(int i, T t) {
            T temp = elements[i];
            elements[i] = t;
            return temp;
        }

        @Override
        public void add(int i, T t) {
            size++;
            System.arraycopy(elements, i, elements, i + 1, size - i);
            elements[i] = t;
        }

        @Override
        public T remove(int i) {
            T prev = elements[i];
            System.arraycopy(elements, i + 1, elements, i, --size - i);
            return prev;
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
        public ListIterator<T> listIterator(int i) {
            return null;
        }

        @Override
        public List<T> subList(int i, int i1) {
            return null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            String delimiter = "";
            for (int i = 0; i < size; i++) {
                sb.append(delimiter).append(elements[i]);
                delimiter = ", ";
            }
            sb.append("]");
            return sb.toString();
        }
    }
