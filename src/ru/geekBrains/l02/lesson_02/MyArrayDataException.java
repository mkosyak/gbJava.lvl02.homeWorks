package ru.geekBrains.l02.lesson_02;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(int column, int row, String value) {
        super("\n Element (column: " + column + ", row: " + row +
                ", value: '" + value +  "') can not be converted into number!");
    }

}
