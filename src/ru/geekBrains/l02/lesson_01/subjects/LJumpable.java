package ru.geekBrains.l02.lesson_01.subjects;

public interface LJumpable {
    float lJumpDist = 1.0F;     //meters
    String lJumpAttr = "lJumpDist";

    boolean longJump(float distance);
}
