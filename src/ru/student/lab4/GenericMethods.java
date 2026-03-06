package ru.student.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.Collection;

public class GenericMethods {

    // 3.1 Функция (map)
    public static <T, P> List<P> map(List<T> input, Applier<T, P> applier) {
        if (input == null) throw new IllegalArgumentException("input == null");
        if (applier == null) throw new IllegalArgumentException("applier == null");
        List<P> out = new ArrayList<>();
        for (T v : input) {
            out.add(applier.apply(v));
        }
        return out;
    }

    // 3.2 Фильтр
    public static <T> List<T> filter(List<T> input, PredicateX<T> predicate) {
        if (input == null) throw new IllegalArgumentException("input == null");
        if (predicate == null) throw new IllegalArgumentException("predicate == null");
        List<T> out = new ArrayList<>();
        for (T v : input) {
            if (predicate.test(v)) out.add(v);
        }
        return out;
    }

    // 3.3 Сокращение (reduce) — безопасная версия: возвращает identity при пустом списке
    public static <T> T reduce(List<T> input, Reducer<T> reducer, T identity) {
        if (input == null) throw new IllegalArgumentException("input == null");
        if (reducer == null) throw new IllegalArgumentException("reducer == null");
        if (identity == null) throw new IllegalArgumentException("identity не может быть null");

        if (input.isEmpty()) return identity;

        T acc = identity;
        for (T v : input) {
            if (v == null) continue; // пропустим null, чтобы не падать
            acc = reducer.reduce(acc, v);
            if (acc == null) throw new IllegalStateException("Reducer вернул null — это запрещено");
        }
        return acc;
    }

    // 3.4 Коллекционирование
    public static <T, P extends Collection<T>> P collect(
            List<T> input,
            Supplier<P> collectionFactory,
            BiConsumer<P, T> accumulator
    ) {
        if (input == null) throw new IllegalArgumentException("input == null");
        if (collectionFactory == null) throw new IllegalArgumentException("collectionFactory == null");
        if (accumulator == null) throw new IllegalArgumentException("accumulator == null");

        P result = collectionFactory.get();
        if (result == null) throw new IllegalStateException("collectionFactory вернул null");

        for (T v : input) {
            accumulator.accept(result, v);
        }
        return result;
    }
}
