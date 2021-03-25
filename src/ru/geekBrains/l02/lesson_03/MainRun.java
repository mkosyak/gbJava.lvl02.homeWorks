package ru.geekBrains.l02.lesson_03;

import java.util.*;

/**
 * Урок 3. Коллекции
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 * <p>
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи.
 * С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
 * несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 * >> Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять
 * >> еще дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
 * >> Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main()
 * >> прописывая add() и get().
 */

public class MainRun {
    public static void main(String[] args) {

//  Task 02
        doTask01();

//  Task 02
        doTask02("Petrov");
    }

    public static void doTask01() {
//  Task 01 =============================================================
        System.out.printf("%n%n -- Task: %s", "1.");
// -- Init HashMap
        String wordsArray[] = {
                "SATOR", "AREPO", "TENET", "OPERA", "ROTAS",
                "SATOR", "TENET", "SATOR", "OPERA", "SATOR",
                "SATOR", "TENET", "SATOR", "ROTAS", "AREPO"
        };

// -- Run search
        WordCollections wordStatistic = new WordCollections(wordsArray);
        wordStatistic.outWordsInfo(wordStatistic.getWordList());
    }

    public static void doTask02(String surname) {
//  Task 02 =============================================================
        System.out.printf("%n%n -- Task: %s", "2.");
        System.out.printf("%n---- Initial Map:");

// -- Init HashMap
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("0000", new PhoneBookValue("Doe", "8-800-000-00-01"));
        phoneBook.add("0001", new PhoneBookValue("Doe", "8-800-100-00-01"));
        phoneBook.add("0002", new PhoneBookValue("Anonymous", "8-800-000-00-02"));
        phoneBook.add("0003", new PhoneBookValue("Anonymous", "8-800-100-00-02"));
        phoneBook.add("0004", new PhoneBookValue("Anonymous", "8-800-200-00-02"));
        phoneBook.add("0005", new PhoneBookValue("Anonymous", "8-800-300-00-02"));
        phoneBook.add("0006", new PhoneBookValue("Ivanov", "8-800-000-00-03"));
        phoneBook.add("0007", new PhoneBookValue("Ivanov", "8-800-100-00-03"));
        phoneBook.add("0008", new PhoneBookValue("Ivanov", "8-800-200-00-03"));
        phoneBook.add("0009", new PhoneBookValue("Ivanov", "8-800-300-00-03"));
        phoneBook.add("000A", new PhoneBookValue("Ivanov", "8-800-300-00-03"));
        phoneBook.add("000B", new PhoneBookValue("Ivanov", "8-800-400-00-03"));
        phoneBook.add("000C", new PhoneBookValue("Petrov", "8-800-000-00-04"));
        phoneBook.add("000D", new PhoneBookValue("Petrov", "8-800-100-00-04"));
        phoneBook.add("000E", new PhoneBookValue("Petrov", "8-800-200-00-04"));
        phoneBook.add("000F", new PhoneBookValue("Kuznetsov", "8-800-000-00-05"));
        phoneBook.add("000G", new PhoneBookValue("Kuznetsov", "8-800-100-00-05"));
        phoneBook.add("000H", new PhoneBookValue("Kuznetsov", "8-800-200-00-05"));
        phoneBook.add("000I", new PhoneBookValue("Kuznetsov", "8-800-300-00-05"));
        phoneBook.add("000J", new PhoneBookValue("Kuznetsov", "8-800-400-00-05"));
        phoneBook.add("000H", new PhoneBookValue("Kuznetsov", "8-800-500-00-05"));
        phoneBook.add("000H", new PhoneBookValue("Kuznetsoff", "8-800-500-00-05")); // Duplicate key
        System.out.println("\n" + phoneBook.toString());

// Run Search
       Map<String, PhoneBookValue> retEntries = phoneBook.getPhoneList(surname);
       System.out.printf("%n ---- Telephone Numbers for %s:", surname);
       System.out.println("\n" + retEntries.toString());
    }
}
