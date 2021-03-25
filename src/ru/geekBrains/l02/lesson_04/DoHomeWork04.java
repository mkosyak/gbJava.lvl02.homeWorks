package ru.geekBrains.l02.lesson_04;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DoHomeWork04 {

    public static void main(String[] args) {
//    Task 01
        System.out.printf("%n-- Task 01. %n");
        doTask01(new String[]{
                "SATOR", "SATOR", "SATOR", null,
                "AREPO", "AREPO", "AREPO", null,
                "TENET", "TENET", "TENET", null,
                "OPERA", "OPERA", "OPERA", null,
                "ROTAS", "ROTAS", "ROTAS", null});


//    Task 02
        System.out.printf("%n-- Task 02. %n");
        doTask02();

//    Task 03
        System.out.printf("%n-- Task 03. %n");
        doTask03();

//    Task 04
        System.out.printf("%n-- Task 04. %n");
        doTask04();
    }

    /**
     * 1.Создать коллекцию типа List.
     * Наполнить ее значениями и вывести значения в консоль при помощи ее метода forEach.
     */
    private static List<String> myLst = new ArrayList<>();

    public static void doTask01(String[] inputStr) {
        for (int i = 0; i < inputStr.length; i++) {
            myLst.add(inputStr[i]);
        }
        myLst.forEach(s -> System.out.printf("[%s]%n", s));
    }

    /**
     * 2.Создать утилитарный метод forItem.
     * Метод принимает два параметра: Коллекция Set  и консьюмер типа Consumer .
     * Внутри метода проитерироваться по коллекции и для каждого элемента выполнить метод консьюмера accept,
     * который выводит значение элемента в консоль.
     */
    public static void doTask02() {
        forItem(convStrCol2HashSet(myLst), o -> System.out.printf("[%s]%n", o));
    }

    public static void forItem(Set<String> inputSet, Consumer cons) {
        Iterator<String> iterSet = inputSet.iterator();
        while (iterSet.hasNext()) {
            cons.accept(iterSet.next());
        }
    }

    public static Set<String> convStrCol2HashSet(List<String> listCollection) {
        Set<String> hashSet = new HashSet<>();
        for (String line : listCollection) {
            hashSet.add(line);
        }
        return hashSet;
    }

    /**
     * 3.Создать утилитарный метод doubleUp. Метод принимает два параметра: значение типа int и консьюмер типа Supplier .
     * Внутри метода выполнить метод саплаера get, который возвращает множитель и затем переданное значение на него
     * умножается. Фукнция возращает результат произведения.
     */
    public static void doTask03() {
        System.out.printf("Result of doubling is equal to %s%n", doubleUp(555, (Supplier) () -> 2));
    }

    public static int doubleUp(int number, Supplier<Integer> consm) {
        return number * consm.get();
    }

    /**
     * 4.Создать метод findAllChars. Метод принимает два параметра: String target и char toFind.
     * Первый параметр является входной строкой, а второй - символ, который необходимо найти в входящей строке.
     * Учесть что искомый символ может повторяется (напр.: 'ccch'). Необходимо найти все повторения и вернуть
     * в виде конкатенированной строки обвернутый в Optional. Если ни одного совпадения не найдено, тогда необходимо
     * вернуть пустой Optional. Пример выполнения: Optional  opt = findAllChars("ccch", 'c'); opt.get(); // вернет "ссс".
     */
    public static void doTask04() {
        String str = "cchccch";
        char charToSearch = 'e';

        Optional<String> optionalStr = findAllChars(str, charToSearch);
        System.out.printf("Search results in '%s' of '%c' is '%s'", str, charToSearch, optionalStr.get());

//        optionalStr.ifPresentOrElse(
////                (s -> System.out.printf("Search results in '%s' of '%c' is '%s'", str, charToSearch, optionalStr.toString())),
//                (s -> System.out.printf("Search results in '%s' of '%c' is '%s'", str, charToSearch, optionalStr.get())),
//                () -> System.out.printf("Not found"));


    }

    public static Optional<String> findAllChars(String line, char charToSearch) {
        char[] charArr = line.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == charToSearch) sb.append(charToSearch);
        }
        return Optional.of(sb.toString()); /// ? ofNulable...?
    }
}
