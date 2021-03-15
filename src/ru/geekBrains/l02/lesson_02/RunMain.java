package ru.geekBrains.l02.lesson_02;

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ
 * или текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией
 * в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения
 * MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 */
public class RunMain {
    public static void main(String args[]) {
        String[][] st = new String[][]{
//                {"S", "A", "T", "O", "R"},      // v.1.0
//                {"A", "R", "E", "P", "O"},      // v.1.0
//                {"T", "E", "N", "E", "T"},      // v.1.0
//                {"O", "P", "E", "R", "A"},      // v.1.0
//                {"R", "O", "T", "A", "S"}       // v.1.0
                {"1", "2", "3", "4", "5"},       // v.2.0
                {"1", "2", "3", "4", "5"},       // v.2.0
                {"1", "2", "3", "4", "5"},       // v.2.0
                {"1", "2", "3", "4", "5"},       // v.2.0
                {"1", "2", "3", "4", "5"}        // v.2.0
        };
        CheckArray chkArray = null;

// -- Check Array size in Constructor
        try {
            chkArray = new CheckArray(6, 5, st);    // PUT right Dimensions here!
        } catch (MyArraySizeException ex) {
            System.out.printf("\n>>>Catch Array SIZE Triggered! \n");
            ex.printStackTrace();
        }

// -- Check whether Array Data Elements are Numbers (aligned to double type)
        try {
            double sumElements = chkArray.getSumElements(st);
            System.out.printf("%nThe Sum of ALL array elements is . . : %.2f", sumElements);
        } catch (MyArrayDataException ex) {
            System.out.printf("\n>>>Catch Array DATA Triggered! \n");
            ex.printStackTrace();
        }
    }
}
