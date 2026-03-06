package ru.student.lab4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // Для задания 1.1: "Передайте Коробку в какой-либо метод..."
    private static void printAndEmptyIntBox(Box<Integer> box) {
        Integer v = box.take();
        System.out.println("Извлекли из коробки значение: " + v);
        System.out.println("После извлечения коробка: " + box);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Лабораторная работа №4 (Java). Вариант 4.");
        System.out.println();

        int zadanie = Input.readInt(sc, "Введите номер задания (1-3): ", 1, 3);

        // Вариант 4 по таблице:
        // Задание 1 -> задачи 1 и 3
        // Задание 2 -> задача 2
        // Задание 3 -> задачи 1-4
        if (zadanie == 1) {
            System.out.println("Задание 1: Обобщенные типы.");
            int zadacha = Input.readInt(sc, "Введите номер задачи (1 или 3): ", 1, 3);

            if (zadacha == 1) {
                System.out.println("\n[1.1] Обобщенная коробка");

                Box<Integer> intBox = new Box<>();
                intBox.put(3);
                System.out.println("Создали коробку и положили туда число 3: " + intBox);

                System.out.println("Передаем коробку в метод и извлекаем значение...");
                printAndEmptyIntBox(intBox);

                System.out.println("Проверка на заполненность: isEmpty=" + intBox.isEmpty());

                // демонстрация исключения при попытке положить в непустую
                System.out.println("\nДемонстрация исключения: кладем два раза подряд");
                Box<String> strBox = new Box<>();
                strBox.put("hello");
                try {
                    strBox.put("world");
                } catch (IllegalStateException e) {
                    System.out.println("Поймали исключение: " + e.getMessage());
                }

            } else if (zadacha == 3) {
                System.out.println("\n[1.3] Сравнимое — интерфейс ComparableRef<T>");

                Student a = new Student("Аня", Arrays.asList(90, 80, 95));
                Student b = new Student("Борис", Arrays.asList(70, 75, 80));

                System.out.println("Студент A: " + a);
                System.out.println("Студент B: " + b);

                int cmp = a.compare(b);
                System.out.println("A.compare(B) = " + cmp + " (1 если A сильнее, 0 если равны, -1 если слабее)");
            }

        } else if (zadanie == 2) {
            System.out.println("Задание 2: Параметризации.");
            int zadacha = Input.readInt(sc, "Введите номер задачи (2): ", 2, 2);

            if (zadacha == 2) {
                System.out.println("\n[2.2] Поиск максимума в наборе Коробок (любые числа) -> double");

                int n = Input.readInt(sc, "Сколько коробок создать? (1-10): ", 1, 10);
                List<Box<? extends Number>> boxes = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    System.out.println("Коробка #" + (i + 1));
                    int type = Input.readInt(sc, "Выберите тип числа: 1-int, 2-double: ", 1, 2);

                    if (type == 1) {
                        int v = Input.readInt(sc, "Введите int: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                        Box<Integer> b = new Box<>();
                        b.put(v);
                        boxes.add(b);
                    } else {
                        double v = Input.readDouble(sc, "Введите double: ");
                        Box<Double> b = new Box<>();
                        b.put(v);
                        boxes.add(b);
                    }
                }

                System.out.println("Набор коробок: " + boxes);
                double max = Task2Methods.maxOfBoxesAsDouble(boxes);
                System.out.println("Максимум (double) = " + max);
            }

        } else if (zadanie == 3) {
            System.out.println("Задание 3: Обобщенные методы. Автовывод типа.");
            int zadacha = Input.readInt(sc, "Введите номер задачи (1-4): ", 1, 4);

            if (zadacha == 1) {
                System.out.println("\n[3.1] Функция (map)");

                List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                List<Integer> lengths = GenericMethods.map(strings, s -> s.length());
                System.out.println("Строки: " + strings);
                System.out.println("Длины: " + lengths);

                List<Integer> nums = Arrays.asList(1, -3, 7);
                List<Integer> abs = GenericMethods.map(nums, x -> x < 0 ? -x : x);
                System.out.println("Числа: " + nums);
                System.out.println("Модуль: " + abs);

                List<int[]> arrays = Arrays.asList(new int[]{1, 5, 2}, new int[]{-7, -1}, new int[]{9, 0, 9});
                List<Integer> maxes = GenericMethods.map(arrays, arr -> {
                    int m = arr[0];
                    for (int v : arr) if (v > m) m = v;
                    return m;
                });
                System.out.println("Массивы: " + arrays.stream().map(Arrays::toString).collect(Collectors.toList()));
                System.out.println("Максимумы: " + maxes);

            } else if (zadacha == 2) {
                System.out.println("\n[3.2] Фильтр (filter)");

                List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                List<String> filteredStrings = GenericMethods.filter(strings, s -> s.length() >= 3);
                System.out.println("Исходные строки: " + strings);
                System.out.println(">=3 символов: " + filteredStrings);

                List<Integer> nums = Arrays.asList(1, -3, 7);
                List<Integer> onlyPos = GenericMethods.filter(nums, x -> x > 0);
                System.out.println("Исходные числа: " + nums);
                System.out.println("Только положительные: " + onlyPos);

                List<int[]> arrays = Arrays.asList(new int[]{0, -2}, new int[]{-7, -1}, new int[]{9, 0, 9});
                List<int[]> noPositive = GenericMethods.filter(arrays, arr -> {
                    for (int v : arr) if (v > 0) return false;
                    return true;
                });
                System.out.println("Исходные массивы: " + arrays.stream().map(Arrays::toString).collect(Collectors.toList()));
                System.out.println("Массивы без положительных: " + noPositive.stream().map(Arrays::toString).collect(Collectors.toList()));

            } else if (zadacha == 3) {
                System.out.println("\n[3.3] Сокращение (reduce) + безопасное поведение для пустого списка");

                List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                String joined = GenericMethods.reduce(strings, (a, b) -> a + b, "");
                System.out.println("Строки: " + strings);
                System.out.println("Склейка: " + joined);

                List<Integer> nums = Arrays.asList(1, -3, 7);
                Integer sum = GenericMethods.reduce(nums, Integer::sum, 0);
                System.out.println("Числа: " + nums);
                System.out.println("Сумма: " + sum);

                List<List<Integer>> listOfLists = Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(),
                        Arrays.asList(9)
                );
                // получить общее количество элементов
                List<Integer> sizes = GenericMethods.map(listOfLists, List::size);
                Integer totalCount = GenericMethods.reduce(sizes, Integer::sum, 0);
                System.out.println("Список списков: " + listOfLists);
                System.out.println("Размеры: " + sizes);
                System.out.println("Общее количество элементов: " + totalCount);

                // демонстрация пустого списка
                List<Integer> empty = new ArrayList<>();
                Integer safe = GenericMethods.reduce(empty, Integer::sum, 0);
                System.out.println("Пустой список: " + empty + " -> reduce = " + safe + " (не null, без ошибок)");

            } else if (zadacha == 4) {
                System.out.println("\n[3.4] Коллекционирование (collect)");

                // 1) Разбить числа на положительные/отрицательные
                List<Integer> nums = Arrays.asList(1, -3, 7);
                Map<String, List<Integer>> split = new HashMap<>();
                split.put("positive", new ArrayList<>());
                split.put("negative", new ArrayList<>());
                for (Integer x : nums) {
                    if (x > 0) split.get("positive").add(x);
                    else if (x < 0) split.get("negative").add(x);
                }
                System.out.println("Числа: " + nums);
                System.out.println("positive=" + split.get("positive") + ", negative=" + split.get("negative"));

                // 2) Группировка строк по длине
                List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");
                Map<Integer, List<String>> byLen = new HashMap<>();
                for (String s : strings) {
                    byLen.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s);
                }
                System.out.println("Строки: " + strings);
                System.out.println("Группы по длине: " + byLen);

                // 3) Набор без дублей
                List<String> strings2 = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
                Set<String> unique = new HashSet<>(strings2);
                System.out.println("Строки: " + strings2);
                System.out.println("Уникальные: " + unique);
            }
        }

        System.out.println("\nГотово.");
    }
}
