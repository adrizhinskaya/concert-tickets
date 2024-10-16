package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomHashSet<E> implements Iterable<E> {
    private Object[] elements;
    private int size;
    private int capacity;
    private static final float LOAD_FACTOR = 0.75f;

    public CustomHashSet() {
        this.capacity = 16;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        if (contains(element)) {
            return false;
        }
        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }
        int index = getIndex(element);
        elements[index] = element;
        size++;
        return true;
    }

    public boolean contains(E element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        int index = getIndex(element);
        return elements[index] != null && elements[index].equals(element);
    }


    public boolean remove(E element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        int index = getIndex(element);
        if (elements[index] != null && elements[index].equals(element)) {
            elements[index] = null;
            size--;
            return true;
        }
        return false;
    }

    private int getIndex(E element) {
        return Math.abs(element.hashCode() / 10000000);
    }

    private void resize() {
        capacity *= 2;
        Object[] newTable = new Object[capacity];
        for (Object obj : elements) {
            if (obj != null) {
                int newIndex = getIndex((E) obj);
                newTable[newIndex] = obj;
            } else {
                break;
            }
        }
        elements = newTable;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;
            private int elementsReturned = 0;

            @Override
            public boolean hasNext() {
                return elementsReturned < size;
            }

            @Override
            public E next() {
                while (currentIndex < capacity) {
                    if (elements[currentIndex] != null) {
                        elementsReturned++;
                        return (E) elements[currentIndex++];
                    }
                    currentIndex++;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static void main(String[] args) {
        CustomHashSet<String> set = new CustomHashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("Hello");

        System.out.println(set.contains("Hello"));
        System.out.println(set.contains("Java"));

        for (String s : set) {
            System.out.println(s);
        }

        set.remove("Hello");
        System.out.println(set.contains("Hello"));
    }
}
