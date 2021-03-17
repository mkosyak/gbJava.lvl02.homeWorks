package ru.geekBrains.l02.lesson_01.obstacles;

public class RunningTrack implements Obstacles, ObstRLength {
    private String name = "Running Track";
    private float runTrackDistance = 1024.00F;  //Meters

    public RunningTrack() {                     // constructor with no parameter
//    -- Max Distance by default
        System.out.printf("%n:> *DFT Running Track for a distance (%.2f meters) is created! ", runTrackDistance);
    }

    public RunningTrack(float distance) {       // constructor with parameter
        runTrackDistance = distance;
        System.out.printf("%n:> Running Track for a distance (%.2f meters) is created! ", runTrackDistance);
    }

    @Override
    public float getLength() {
        return runTrackDistance;
    }

    @Override
    public String getObjName() {
        return name;
    }
}



