package example.gradle.bigproject.collection;


import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayList<T> implements Iterable<T> {
    private Object[] data;
    private int size;

    public CustomArrayList() {
        this.data = new Object[10];
        this.size = 0;
    }

    public void add(T item) {
        if (size == data.length) data = Arrays.copyOf(data, data.length * 2);
        data[size++] = item;
    }

    public void set(int idx, T item) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
        data[idx] = item;
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
        return (T) data[idx];
    }

    public int size() { return size; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int current = 0;
            @Override public boolean hasNext() { return current < size; }
            @Override public T next() { return get(current++); }
        };
    }
}