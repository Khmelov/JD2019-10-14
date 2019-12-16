package by.it.baranovskaya.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class SetC<T> extends HashSet {
    private T[] elements = (T[]) new Object[1];
    private int size = 0;

    @Override
    public void clear() {
        if(size > 0 && elements != null){
            for (T element : elements) {
                element = null;
            }
            size = 0;
        }

    }

    @Override
    public boolean removeAll(Collection c) {
        boolean flag = false;
        for (Object o : c) {
            flag = remove(o);
        }
        return flag;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if(o == null){
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if(o.equals(elements[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Object o) {
        boolean flag = false;
        if(o == null) {
            for (int i = 0; i < size; i++) {
                if ((elements[i])==null) {
                    flag = false;
                    return flag;
                }
            }
            if( elements.length == size) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = (T) o;
            flag = true;
            return flag;
        }
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                flag = false;
                return flag;
            }
        }
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = (T) o;
        flag = true;
        return flag;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null) {
            for (int i = 0; i < size; i++) {
                if ((elements[i]) == null) {
                    System.arraycopy(elements, i+1, elements, i, --size - i);
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if(o.equals(elements[i])){
                System.arraycopy(elements, i+1, elements, i, --size - i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean flag = false;
        for (Object o : c) {
            boolean f = add(o);
            if(f){
                flag = true;
            }
        }
        return flag;
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
    public boolean containsAll(Collection c) {
        boolean flag = false;
        for (Object o : c) {
            if(contains(o))
                flag = true;
            else
                flag=false;
        }
        return flag;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    };
}
