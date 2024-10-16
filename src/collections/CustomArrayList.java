package collections;

public class CustomArrayList<T> {

    private int size = 0;
    private Object[] elements;
    private int capacity;

    public CustomArrayList() {
        this.capacity = 10;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public void add(T newElement) {
        if (size >= capacity) {
            grow();
        }
        elements[size] = newElement;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return (T) this.elements[index];
    }

    private void grow() {
        Object[] newArray = new Object[elements.length + capacity / 2];
        System.arraycopy(elements, 0, newArray, 0, capacity);
        this.elements = newArray;
        capacity = newArray.length;
    }

    public static void main(String[] args) {
        final var ar = new CustomArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            ar.add(i);
        }
        System.out.println("Size = " + ar.size);
        ar.remove(0);
        System.out.println("Size = " + ar.size);
        System.out.println(ar.get(1));
    }
}