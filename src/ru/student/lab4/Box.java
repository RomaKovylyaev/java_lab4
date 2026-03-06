package ru.student.lab4;

public class Box<T> {
    private T value;

    public Box() {
        this.value = null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public void put(T value) {
        if (!isEmpty()) {
            throw new IllegalStateException("Коробка не пуста: сначала заберите объект.");
        }
        this.value = value;
    }

    public T take() {
        T tmp = this.value;
        this.value = null; // обнулить ссылку при извлечении
        return tmp;
    }

    public T peek() {
        return value;
    }

    @Override
    public String toString() {
        return "Box{value=" + value + "}";
    }
}
