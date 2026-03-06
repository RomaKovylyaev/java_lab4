package ru.student.lab4;

@FunctionalInterface
public interface Applier<T, P> {
    P apply(T value);
}
