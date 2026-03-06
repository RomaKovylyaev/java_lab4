package ru.student.lab4;

import java.util.ArrayList;
import java.util.List;

public class MutableArray<T> {
    private final List<T> data;

    public MutableArray() {
        this.data = new ArrayList<>();
    }

    public MutableArray(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("initialCapacity < 0");
        this.data = new ArrayList<>(initialCapacity);
    }

    public void add(T value) {
        data.add(value);
    }

    public T get(int index) {
        return data.get(index);
    }

    public void set(int index, T value) {
        data.set(index, value);
    }

    public int size() {
        return data.size();
    }

    public List<T> toList() {
        return new ArrayList<>(data);
    }

    @Override
    public String toString() {
        return "MutableArray{data=" + data + "}";
    }
}
