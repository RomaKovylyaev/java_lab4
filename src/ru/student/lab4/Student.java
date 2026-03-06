package ru.student.lab4;

import java.util.ArrayList;
import java.util.List;

public class Student implements ComparableRef<Student> {
    private String name;
    private List<Integer> grades;

    public Student(String name, List<Integer> grades) {
        setName(name);
        setGrades(grades);
    }

    public Student(String name) {
        setName(name);
        this.grades = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым");
        }
        this.name = name.trim();
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void setGrades(List<Integer> grades) {
        if (grades == null) {
            throw new IllegalArgumentException("Список оценок не может быть null");
        }
        ArrayList<Integer> copy = new ArrayList<>();
        for (Integer g : grades) {
            if (g == null) throw new IllegalArgumentException("Оценка не может быть null");
            if (g < 0 || g > 100) throw new IllegalArgumentException("Оценка должна быть в диапазоне 0..100");
            copy.add(g);
        }
        this.grades = copy;
    }

    public void addGrade(int grade) {
        if (grade < 0 || grade > 100) throw new IllegalArgumentException("Оценка должна быть в диапазоне 0..100");
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (int g : grades) sum += g;
        return sum / grades.size();
    }

    @Override
    public int compare(Student other) {
        if (other == null) throw new IllegalArgumentException("Нельзя сравнить с null");
        return Double.compare(this.getAverage(), other.getAverage());
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grades=" + grades + ", avg=" + String.format("%.2f", getAverage()) + "}";
    }
}
