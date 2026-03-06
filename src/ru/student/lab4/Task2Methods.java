package ru.student.lab4;

import java.util.List;

public class Task2Methods {

    // 2.2 Поиск максимума: набор коробок с любыми числами -> максимум как double
    public static double maxOfBoxesAsDouble(List<Box<? extends Number>> boxes) {
        if (boxes == null) throw new IllegalArgumentException("boxes == null");
        if (boxes.isEmpty()) throw new IllegalArgumentException("Набор коробок пуст");

        boolean found = false;
        double max = Double.NEGATIVE_INFINITY;

        for (Box<? extends Number> b : boxes) {
            if (b == null) continue;
            Number n = b.peek();
            if (n == null) continue;
            double v = n.doubleValue();
            if (!found || v > max) {
                max = v;
                found = true;
            }
        }

        if (!found) throw new IllegalArgumentException("Во всех коробках нет чисел (везде null/пусто)");
        return max;
    }
}
