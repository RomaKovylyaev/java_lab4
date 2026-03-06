package ru.student.lab4;

@FunctionalInterface
public interface Reducer<T> {
    T reduce(T a, T b);
}
