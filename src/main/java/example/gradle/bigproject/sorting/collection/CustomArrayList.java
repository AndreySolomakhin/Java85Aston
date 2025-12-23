package example.gradle.bigproject.sorting.collection;


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
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = item;
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx);
        }
        return (T) data[idx]; // То самое приведение типа
    }

    public int git statussize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() { // Используем Diamond Operator <>
            private int current = 0;
            @Override
            public boolean hasNext() { return current < size; }
            @Override
            public T next() { return get(current++); }
        };
    }
}