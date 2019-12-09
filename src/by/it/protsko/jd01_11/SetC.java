package by.it.protsko.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class SetC<T> implements Set<T> {

    private T[] setElements = (T[]) new Object[]{};
    private int size = 0;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        boolean isContains = false;
        if (size > 0) {
            if (object == null) {
                for (int index = 0; index < size; index++) {
                    if (setElements[index] == null) {
                        return true;
                    }
                }
            } else {
                for (int index = 0; index < size; index++) {
                    if (object.equals(setElements[index])) {
                        isContains = true;
                        break;
                    }
                }
            }
        }
        return isContains;
    }

    @Override
    public boolean add(T element) {
        if (!contains(element)) {
            if (setElements.length <= size) {
                setElements = Arrays.copyOf(setElements, (setElements.length * 3) / 2 + 1);
            }
            setElements[size++] = element;
        }
        return contains(element);
    }

    @Override
    public boolean remove(Object object) {
        if (contains(object)) {
            if (object == null) {
                for (int index = 0; index < size; index++) {
                    if (setElements[index] == null) {
                        System.arraycopy(setElements, index + 1, setElements, index, (--size - index));
                        return true;
                    }
                }
            } else {
                for (int index = 0; index < size; index++) {
                    if (object.equals(setElements[index])) {
                        System.arraycopy(setElements, index + 1, setElements, index, (--size - index));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        //Object[] collectionToArray = collection.toArray();
        for (Object elementCollection : collection) {
            if (!contains(elementCollection)) {
                return false;

            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean isContains = false;
        if (collection.size() > 0) {
            for (T elementCollection : collection) {
                if (!contains(elementCollection)) {
                    add(elementCollection);
                    isContains = true;
                }
            }
        }
        return isContains;
    }


    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isContains = false;
        for (Object elementCollection : collection) {
            if (contains(elementCollection)) {
                remove(elementCollection);
                isContains = true;
            }
        }
        return isContains;
    }

    @Override
    public void clear() {
        if (size > 0) {
            for (int index = 0; index < size; size--) {
                setElements[index] = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int index = 0; index < size; index++) {
            sb.append(delimiter).append(setElements[index]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    //Stubs
    @Override
    public boolean retainAll(Collection<?> c) {
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
}
