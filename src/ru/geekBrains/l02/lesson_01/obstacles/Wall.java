package ru.geekBrains.l02.lesson_01.obstacles;


public class Wall implements Obstacles, ObstJHeight {
    private String name = "Wall";
    private float wallHeight = 3.75F; // Meters

    public Wall() {                       // constructor with no parameter
//    -- Max Height by default
        System.out.printf("%n:> *DFT Wall height (%.2f meters) is created! ", wallHeight);
    }

    public Wall(float height) {           // constructor with parameter
        wallHeight = height;
        System.out.printf("%n:> The Wall height (%.2f meters) is created! ", wallHeight);
    }

    ;

    @Override
    public float getHeight() {
        return wallHeight;
    }


    @Override
    public String getObjName() {
        return name;
    }
}
