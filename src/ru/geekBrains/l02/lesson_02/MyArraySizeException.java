package ru.geekBrains.l02.lesson_02;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException(String message) {
        super(message);            // add message to stack
//        System.out.println(message);
    }

}
