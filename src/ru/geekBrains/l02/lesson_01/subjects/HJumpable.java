package ru.geekBrains.l02.lesson_01.subjects;

public interface HJumpable {
    float hJumpDist = 1.0F;     //meters
    String hJumpAttr = "hJumpDist";

    boolean heightJump(float height);
}
