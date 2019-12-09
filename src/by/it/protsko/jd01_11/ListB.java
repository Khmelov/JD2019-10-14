package by.it.protsko.jd01_11;

import java.util.*;

class ListB<T> implements List<T> {

    private T[] listElements = (T[]) new Object[11];
    private int size = 0;

    @Override                       ///////////////////////////////
    public boolean add(T element) {
        if (listElements.length <= size) {
            listElements = Arrays.copyOf(listElements, (listElements.length * 3) / 2 + 1);
        }
        listElements[size++] = element;
        return true;
    }

    //@Override                    ///////////////////////////////
    public boolean addAll(Collection<? extends T> list) {
        Object[] listToArray = list.toArray();
        for (Object arrayElements : listToArray) {
            add((T) arrayElements);
        }
        return listToArray.length != 0;
    }

    @Override                       ///////////////////////////////
    public void add(int index, T element) {
        if (listElements.length <= size) {
            listElements = Arrays.copyOf(listElements, (listElements.length * 3) / 2 + 1);
        }
        System.arraycopy(listElements, index, listElements, index + 1, (++size - index));
        listElements[index] = element;

    }

    @Override                       ///////////////////////////////
    public T remove(int index) {
        if (index >= 0 && index < size) {
            T removingElement = listElements[index];
            System.arraycopy(listElements, index + 1, listElements, index, (--size - index));
            return removingElement;
        }
        return null;
    }

    @Override                       ///////////////////////////////
    public boolean remove(Object o) {
        int indexRemovingObject = indexOf(o);
        if (indexRemovingObject > -1) {
            remove(indexRemovingObject);
        }
        return indexRemovingObject > -1;
    }

    @Override                       ///////////////////////////////
    public int indexOf(Object object) {
        if (object == null) {
            for (int index = 0; index < size; index++) {
                if (listElements[index] == null) {
                    return index;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (object.equals(listElements[index])) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override                       ///////////////////////////////
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int index = size - 1; index == 0; index--) {
                if (listElements[index] == null) {
                    return index;
                }
            }
        } else {
            for (int index = size - 1; index >= 0; index--) {
                if (object.equals(listElements[index])) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override                       ///////////////////////////////
    public T get(int index) {
        if (index >= 0 && index < size) {
            return listElements[index];
        }
        return null;
    }

    @Override                       ///////////////////////////////
    public int size() {
        return size;
    }

    @Override                       ///////////////////////////////
    public boolean isEmpty() {

        return size == 0;
    }

    @Override                       ///////////////////////////////
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override                       ///////////////////////////////
    public void clear() {
        for (int index = 0; index < size; size--) {
            listElements[index] = null;
        }
    }

    @Override                       ///////////////////////////////
    public T set(int index, T element) {
        if (index >= 0 && index < size) {
            T oldValue = listElements[index];
            listElements[index] = element;
            return oldValue;
        }
        return null;
    }

    @Override                       ///////////////////////////////
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int index = 0; index < size; index++) {
            sb.append(delimiter).append(listElements[index]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }


    //Stubs
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
    public boolean containsAll(Collection<?> c) {
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
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }
}
