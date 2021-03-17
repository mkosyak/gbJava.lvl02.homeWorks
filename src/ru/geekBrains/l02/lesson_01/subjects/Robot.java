package ru.geekBrains.l02.lesson_01.subjects;

import ru.geekBrains.l02.lesson_01.obstacles.ObstJHeight;
import ru.geekBrains.l02.lesson_01.obstacles.ObstJLength;
import ru.geekBrains.l02.lesson_01.obstacles.ObstRLength;
import ru.geekBrains.l02.lesson_01.obstacles.Obstacles;

public class Robot implements Subjects, Runnable {
    public static final String objType = "Robot";
    private String objName;
    private float totalRunDist = 0.0F;     //meters - Cumulative value
    private float maxRunDist = 1.0F;       //meters
    private float maxJumpHeight = 0.01F;   //meters
    private float maxJumpDist = 0.1F;      //meters


    public Robot() {
        objName = Subjects.subjDftName;
        System.out.printf("%n:> Participant %s (type %s) is assigning with the *DFT characters:", objName, objType);
        initMaxValues(maxRunDist, maxJumpHeight, maxJumpDist);
    }

    public Robot(String actName) {
        objName = actName;
        System.out.printf("%n:> Participant %s (type %s) is assigning with the *DFT characters:", objName, objType);
        initMaxValues(maxRunDist, maxJumpHeight, maxJumpDist);
    }

    public Robot(String actName, float run, float hJump, float lJump) {
        objName = actName;
        System.out.printf("%n:> Participant %s (type %s) is assigning with the next characters:", objName, objType);
        initMaxValues(run, hJump, lJump);
    }

    private void initMaxValues(float run, float hJump, float lJump) {
        String prtlfMsg;
        float maxValue = 0F;

// check whether participant is available for run
        prtlfMsg = "%n";    // new line
        if (this instanceof Runnable) {
            maxRunDist = run;
            prtlfMsg = prtlfMsg + " -available to run, Max.distance is set (%.2f)";
        } else {
            maxRunDist = 0f;
            prtlfMsg = prtlfMsg + " -NOT available to run, Max.distance was reset (%.2f)";
        }
        maxValue = maxRunDist;
        System.out.printf(prtlfMsg, maxValue);

// check whether participant is jumping high
        prtlfMsg = "%n";    // new line
        if (this instanceof HJumpable) {
            maxJumpHeight = hJump;
            prtlfMsg = prtlfMsg + " -available to jump-high, Max.height is set (%.2f)";
        } else {
            maxJumpHeight = 0f;
            prtlfMsg = prtlfMsg + " -NOT available to jump-high, Max.height was reset (%.2f)";
        }
        maxValue = maxJumpHeight;
        System.out.printf(prtlfMsg, maxValue);

// check whether participant is jumping long
        prtlfMsg = "%n";    // new line
        if (this instanceof LJumpable) {
            maxJumpDist = lJump;
            prtlfMsg = prtlfMsg + " -available to jump-long, Max.distance is set (%.2f)";
        } else {
            maxJumpDist = 0f;
            prtlfMsg = prtlfMsg + " -NOT available to jump-long, Max.distance is set (%.2f)";
        }
        maxValue = maxJumpDist;
        System.out.printf(prtlfMsg, maxValue);
    }
/*
    @Override
    public boolean heightJump(float actHeight) {
        String textOk = "%n%s: The Height jump on %.2f was a success!";
        String textFail = "%n%s: The Height jump on %.2f wasn't a success since Max.value is %.2f.";
        if (actHeight <= maxJumpHeight) {
            System.out.printf(textOk, objName, actHeight);
            return true;
        } else {
            System.out.printf(textFail, objName, actHeight, maxJumpHeight);
            return false;
        }
    }*/

/*
    @Override   // -- Dummy: quick exclude interface
    public boolean longJump(float actDistance) {
        String textOk = "%n%s: The Long jump on %.2f was a success!";
        String textFail = "%n%s: The Long jump on %.2f wasn't a success since Max.value is %.2f.";

        if (actDistance <= maxJumpDist) {
            System.out.printf(textOk, objName, actDistance);
            return true;
        } else {
            System.out.printf(textFail, objName, actDistance, maxJumpHeight);
            return false;
        }
    }
*/

    @Override
    public boolean run(float actDistance) {
        String textOk = "%n%s: %.2f distance running was successful! (total run: %.2f)";
        String textFail = "%n%s: %.2f distance running wasn't successful since Max.value %.2f was exceeded (%.2f)";
        totalRunDist += actDistance;
        if (totalRunDist <= maxRunDist) {
            System.out.printf(textOk, objName, actDistance, totalRunDist);
            return true;
        } else {
            System.out.printf(textFail, objName, actDistance, maxRunDist, totalRunDist);
            return false;
        }
    }

    @Override
    public boolean doIt(Obstacles obstacle) {
        if (obstacle instanceof ObstRLength) {             // avail.for Run
            return (this.run(((ObstRLength) obstacle).getLength()));
        } else if (obstacle instanceof ObstJLength) {     // avail for Jump Long
//            return (this.longJump(((ObstJLength) obstacle).getLength()));
            System.out.printf("%n%s: not available to LONG JUMP!", objName);    // -- Dummy: quick exclude interface
            return false;                                                       // -- Dummy: quick exclude interface
        } else if (obstacle instanceof ObstJHeight) {     // avail for Jump high
//            return (this.heightJump(((ObstJHeight) obstacle).getHeight()));
            System.out.printf("%n%s: not available to HIGH JUMP!", objName);    // -- Dummy: quick exclude interface
            return false;                                                       // -- Dummy: quick exclude interface
        } else return false;
    }

    @Override
    public String getObjName() {
        return objName;
    }
}
