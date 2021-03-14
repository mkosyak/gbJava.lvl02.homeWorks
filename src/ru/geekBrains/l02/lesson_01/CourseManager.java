package ru.geekBrains.l02.lesson_01;

import ru.geekBrains.l02.lesson_01.obstacles.*;
import ru.geekBrains.l02.lesson_01.subjects.*;

public class CourseManager {
    //  about colors: https://stackoverflow.com/questions/1448858/how-to-color-system-out-println-output/24415186
    final static String redColorOn = (char) 27 + "[31m";
    final static String greenColorOn = (char) 27 + "[32m";
    final static String yelloColorOn = (char) 27 + "[33m";
    final static String resetColor = (char) 27 + "[0m";

    public boolean runCourse(Obstacles obstacle[], Subjects participant[]) {
        String msgNewDelim = "%n" + yelloColorOn + "-----------< %s %d" + resetColor;
        String msgOK = "%n" + greenColorOn +
                "OK! Obstacle %s successfully overcome by participant %s" + resetColor;
        String msgFail = "%n" + redColorOn +
                " >>> Participant %s failed on the obstacle %s and dropped OUT of further competition!" +
                resetColor;
        boolean[] accFailed = new boolean[participant.length];

        try {
            for (int i = 0; i < participant.length; i++) {
                System.out.printf(msgNewDelim, "New participant:", i + 1);
                for (int j = 0; j < obstacle.length; j++) {
                    if (!accFailed[i]) {
                        if (this.runCourseItem(obstacle[j], participant[i])) {
                            System.out.printf(msgOK, obstacle[j].getObjName(), participant[i].getObjName());
                        } else {
                            System.out.printf(msgFail, participant[i].getObjName(), obstacle[j].getObjName());
                            accFailed[i] = true;    // Participant marked as OUT of Contest
                        }
                    } else {
                        continue;                   // Participant is inactive - ignored for the next steps
                    }
                }
            }

//        Output results
            this.outResults(participant, accFailed);

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean runCourseItem(Obstacles obstacle, Subjects participant) {
        return participant.doIt(obstacle);
    }

    private void outResults(Subjects participant[], boolean accFailed[]) {
        String hSep = "%n%n ----------------------------------------------------------";
        String msgOK = "%n %d. %s successfully finished.";

        System.out.printf(hSep);
        for (int i = 0; i < participant.length; i++) {
            if (accFailed[i]) continue;
            else System.out.printf(msgOK, i + 1, participant[i].getObjName());
        }
    }
}
