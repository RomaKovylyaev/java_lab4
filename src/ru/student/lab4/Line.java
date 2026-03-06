package ru.student.lab4;

// Граница стирания не хуже 2D точки
public class Line<T extends Point2D> {
    private T start;
    private T end;

    public Line(T start, T end) {
        setStart(start);
        setEnd(end);
    }

    public T getStart() { return start; }
    public void setStart(T start) {
        if (start == null) throw new IllegalArgumentException("Начальная точка не может быть null");
        this.start = start;
    }

    public T getEnd() { return end; }
    public void setEnd(T end) {
        if (end == null) throw new IllegalArgumentException("Конечная точка не может быть null");
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{start=" + start + ", end=" + end + "}";
    }
}
