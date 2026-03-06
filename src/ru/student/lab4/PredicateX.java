package ru.student.lab4;

@FunctionalInterface
public interface PredicateX<T> {
    boolean test(T value);
}
