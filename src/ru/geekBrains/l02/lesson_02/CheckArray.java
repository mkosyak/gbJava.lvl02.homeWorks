package ru.geekBrains.l02.lesson_02;

public class CheckArray {

    public CheckArray(int maxColumns, int maxRows, String st[][]) throws MyArraySizeException {
        String msgExcText = "%nNumber of %s %d exceeds max.allowed %d";

        if (st.length > maxRows) {
            msgExcText = String.format(msgExcText, "Rows", st.length, maxRows);
            throw new MyArraySizeException(msgExcText);
        }
        for (int i = 0; i < st.length; i++) {
            if (st[i].length > maxColumns) {
                msgExcText = String.format(msgExcText, "Columns", st[i].length, maxColumns);
                throw new MyArraySizeException(msgExcText);
            }
        }
        System.out.printf("%nArray SIZE checked OK!");
    }

    public double getSumElements(String st[][]) throws MyArrayDataException {
        double total = 0.0D;

        for (int i = 0; i < st.length; i++) {
            for (int j = 0; j < st[i].length; j++) {
                try {
                    total = total + Double.valueOf(st[i][j]);
                } catch (Throwable e) {
                    String msgExcText = "%n Element (column: %d, row: %d value %s) can not be converted to number!";
                    msgExcText = String.format(msgExcText, j + 1, i + 1, st[i][j]);
                    throw new MyArrayDataException(msgExcText, e);
                }
            }
        }
        return total;
    }
}
