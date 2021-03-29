package ru.geekBrains.l02.lesson_05;

import java.util.Arrays;

public class ArrayConcProcess {
    private String outputColor;
    static final int size = 10000000;
    static final int half = size / 2;
    float[] arrFull = new float[size];
    float[] arrHalf01 = new float[half];
    float[] arrHalf02 = new float[half];
    long elapsedTimeCalcArr01;
    long elapsedTimeCalcArr02;

    public ArrayConcProcess(String setColor) {
        setOutputColor(setColor);
        this.initArrayValues(arrFull, 1);
    }

    public float[] initArrayValues(float[] arr, float fValue) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = fValue;
//            arr[i] = (float) i;
        }
        return arr;
    }

    public void doCalcArrayInOneGo() {
        long elapsedCalcTime = applyArrayFormula(this.arrFull);
        System.out.printf("------------------------------------------%n" +
                        "Calculation formula in one-GO:%n" +
                        "  Array length . . . . . : %d%n" +
                        "  TOTAL Elapsed time . . : %d%n",
                this.arrFull.length, elapsedCalcTime);
    }

    public void doCalcSplitArray() {
//      Split source array
        long elapsedTimeSplitArr01 = doCopyArray(this.arrFull, 0, this.arrHalf01, 0, half);
        System.out.printf("Split to array %d elapsed time: %d%n", 1, elapsedTimeSplitArr01);
        long elapsedTimeSplitArr02 = doCopyArray(this.arrFull, half, this.arrHalf02, 0, half);
        System.out.printf("Split to array %d elapsed time: %d%n", 2, elapsedTimeSplitArr02);

//      Calculate new values per each Thread
        Thread t1 = new Thread(() -> {
            elapsedTimeCalcArr01 = applyArrayFormula(arrHalf01);
            setOutputColorTmp(ColorsANSI.ANSI_BLUE);
            System.out.printf("Formula calculation for array %d elapsed time: %d%n", 1, elapsedTimeCalcArr01);
        });

        Thread t2 = new Thread(() -> {
            elapsedTimeCalcArr02 = applyArrayFormula(arrHalf02);
            setOutputColorTmp(ColorsANSI.ANSI_CYAN);
            System.out.printf("Formula calculation for array %d elapsed time: %d%n", 2, elapsedTimeCalcArr02);
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//      Merge arrays
        Arrays.fill(arrFull, 0l);                         //Clear source Array
        setOutputColor(getOutputColor());
        long elapsedTimeMergeArr01 = doCopyArray(this.arrHalf01, 0, this.arrFull, 0, half);
        System.out.printf("Merge from array %d elapsed time: %d%n", 1, elapsedTimeMergeArr01);
        long elapsedTimeMergeArr02 = doCopyArray(this.arrHalf02, 0, this.arrFull, half, half);
        System.out.printf("Merge from array %d elapsed time: %d%n", 2, elapsedTimeMergeArr02);

//      Output details
        long elapsedCalcTime =
                elapsedTimeSplitArr01 + elapsedTimeSplitArr02 +
                        elapsedTimeCalcArr01 + elapsedTimeCalcArr02 +
                        elapsedTimeMergeArr01 + elapsedTimeMergeArr02;
        System.out.printf("------------------------------------------%n" +
                        "Calculation formula for Split Arrays:%n" +
                        "  Array length . . . . . : %d%n" +
                        "  TOTAL Elapsed time . . : %d%n",
                this.arrFull.length, elapsedCalcTime);
    }

    private float getFormulaValue(float v, int i) {
        return (float) (v * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    public synchronized long applyArrayFormula(float[] arr) {
        long timeStr = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getFormulaValue(arr[i], i);
        }
        long timeFin = System.currentTimeMillis();
        return (timeFin - timeStr);
    }

    private synchronized long doCopyArray(float[] arrSrc, int idxStrSrc, float[] arrTgt, int idxStrTgt, int length) {
        long timeStr = System.currentTimeMillis();
        System.arraycopy(arrSrc, idxStrSrc, arrTgt, idxStrTgt, length);
        long timeFin = System.currentTimeMillis();
        return (timeFin - timeStr);
    }

    public String getOutputColor() {
        return outputColor;
    }

    public void setOutputColor(String outputColor) {
        this.outputColor = outputColor;
        System.out.println(outputColor);
    }

    private void setOutputColorTmp(String outputColorTemp) {
        System.out.println(outputColorTemp);
    }
}
