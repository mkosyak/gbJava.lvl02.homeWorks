package ru.geekBrains.l02.lesson_05;

/**
 * Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив, например:
 * <p>
 * static final int size = 10000000;
 * static final int h = size / 2;
 * float[] arr = new float[size];
 * <p>
 * 2) Заполняют этот массив единицами;
 * 3) Засекают время выполнения: long a = System.currentTimeMillis();
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis();
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 * <p>
 * (подпробнее см.методичку)
 */

public class doHomeWork05 {
    public static void main(String[] args) {


//    Task 01
        System.out.printf("%n %s-- Task 01. %n", ColorsANSI.ANSI_PURPLE);
        ArrayConcProcess runArrayInOneGo = new ArrayConcProcess(ColorsANSI.ANSI_PURPLE);
        runArrayInOneGo.doCalcArrayInOneGo();
//    Task 02
        System.out.printf("%n %s-- Task 02. %n", ColorsANSI.ANSI_YELLOW);
        ArrayConcProcess runSplitArrayInHalf = new ArrayConcProcess(ColorsANSI.ANSI_YELLOW);
        runSplitArrayInHalf.doCalcSplitArray();

    }


}
