package ru.geekBrains.l02.lesson_01.obstacles;

public class Pit implements Obstacles, ObstJLength {
    private String name = "Pit";
    private float pitLenght = 5.00F; // Meters

    public Pit() {                       // constructor with no parameter
//    -- Max Length by default
        System.out.printf("%n:> *DFT Pit length (%.2f meters) is created! ", pitLenght);
    }

    public Pit(float length) {           // constructor with parameter
        pitLenght = length;
        System.out.printf("%n:> The Pit length (%.2f meters) is created! ", pitLenght);
    }

    @Override
    public float getLength() {
        return pitLenght;
    }

    @Override
    public String getObjName() {
        return name;
    }
}
