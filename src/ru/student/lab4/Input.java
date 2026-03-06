package ru.student.lab4;

import java.util.Scanner;

public class Input {

    public static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            try {
                int v = Integer.parseInt(s.trim());
                if (v < min || v > max) {
                    System.out.println("Ошибка: введите число в диапазоне [" + min + ".." + max + "].");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: это не целое число.");
            }
        }
    }

    public static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            try {
                return Double.parseDouble(s.trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: это не число.");
            }
        }
    }

    public static String readNonEmptyString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            if (s == null) s = "";
            s = s.trim();
            if (s.isEmpty()) {
                System.out.println("Ошибка: строка не должна быть пустой.");
                continue;
            }
            return s;
        }
    }
}
