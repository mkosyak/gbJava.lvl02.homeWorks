package ru.geekBrains.l02.lesson_02;

public class CheckArray {

    public CheckArray(int maxColumns, int maxRows, String st[][]) throws MyArraySizeException {

        if (st.length > maxRows)
            throw new MyArraySizeException("Number of Rows " + st.length + " exceeds " + maxRows);
        for (int i = 0; i < st.length; i++) {
            if (st[i].length > maxColumns)
                throw new MyArraySizeException("Number of Columns " + st[i].length + " exceeds " + maxColumns);
        }
        System.out.printf("Array SIZE checked OK!");
    }

    public double getSumElements(String st[][]) throws MyArrayDataException {
        double total = 0.0D;

        for (int i = 0; i < st.length; i++) {
            for (int j = 0; j < st[i].length; j++) {
                try {
                    total = total + Double.valueOf(st[i][j]);
                } catch (Throwable e) {
                    String msgText = "%n Element (column: %d, row: %d value %s) can not be converted into number!";
                    msgText = String.format(msgText, j + 1, i + 1, st[i][j]);
                    throw new MyArrayDataException(msgText, e);
                }
            }
        }
        return total;
    }
}
