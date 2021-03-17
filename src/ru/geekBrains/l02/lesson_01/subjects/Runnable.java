package ru.geekBrains.l02.lesson_01.subjects;

public interface Runnable {
    float runDist = 10.00F;     //meters
    String runAttr = "runDist";

    boolean run(float distance);
}
