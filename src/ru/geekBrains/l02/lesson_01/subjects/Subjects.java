package ru.geekBrains.l02.lesson_01.subjects;

import ru.geekBrains.l02.lesson_01.obstacles.Obstacles;

/**
 * Marker Interface for any activity type
 */
public interface Subjects {
    String subjDftName = "noName";

    boolean doIt(Obstacles obstacle);

    String getObjName();
}
