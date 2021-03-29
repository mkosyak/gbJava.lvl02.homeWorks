package ru.geekBrains.l02.lesson_02;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String message, Throwable ex) {
        super(message, ex);             // add message to stack
    }

}
