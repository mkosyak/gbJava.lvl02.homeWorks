package ru.geekBrains.l02.lesson3.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arrayList {
    static final String msgDft = "%n%n >>> Exercise #%d > %s";

    public static void main(String[] args) {

//        copyArrayViaSys(); // 0
//        arrayListEx_01();   // #1
//        arrayListEx_02();   // #2
        arrayListEx_03();   // #3

    }

    //    ==========================================
    public static void copyArrayViaSys() {
        System.out.printf(msgDft, 0, "Warming UP");
        int[] arr = {1, 2, 3, 4};
        int[] arrNew = new int[10];
        String msgArrayOut = "%n %s %n arr:  %s; %n newArr: %s";

        System.out.printf(msgArrayOut, ">>init:>", Arrays.toString(arr), Arrays.toString(arrNew));
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        System.out.printf(msgArrayOut, ">>after Copy:>", Arrays.toString(arr), Arrays.toString(arrNew));
        System.out.printf(msgArrayOut, "arrayRef:", arr, arrNew);

        System.out.printf("%n>>after assign:>", "arrNew -->", "arr");
        arr = arrNew;
        System.out.printf(msgArrayOut, "arrayRef:", arr, arrNew);

        arrNew = null;
        System.out.printf(msgArrayOut, ">>after clean:>", Arrays.toString(arr), Arrays.toString(arrNew));
    }

    // ==============================================
    public static void arrayListEx_01() {
        System.out.printf(msgDft, 1, "Get List size");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("A", "BB", "CCC", "DDDD"));
        System.out.println(arrayList);

// --- define size via exeption
        int i = 0;
        while (i >= 0) {
            try {
                System.out.print(arrayList.get(i));
                arrayList.set(i, arrayList.get(i) + i);
                System.out.println(" new value set to:> " + arrayList.get(i));
                i++;

            } catch (Throwable e) {
                System.out.println(e.getMessage());
                System.out.println("Way 1:" + "Last Index = " + i);
                return;
            } finally {
                System.out.println("Way 1:" + "<Array>.size is: " + arrayList.size());
            }
        }
    }

    //   02.
    public static void arrayListEx_02() {
        System.out.printf(msgDft, 2, "Add/Inset/Remove");

//        ArrayList<String> arrayList = new ArrayList<String>();  // before v.1.8
        ArrayList<String> arrayList = new ArrayList<>();      // after v.1.8
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add(1, "А0"); // Insert to position index 1 - shifts all elements to right
        System.out.println("\n" + arrayList);
        arrayList.remove("E");          // remove by value
        arrayList.remove(2);         // remove by index
        System.out.println(arrayList);

    }

    public static void arrayListEx_03() {
        System.out.printf(msgDft, 4, "convert 'toArray'");

        List<Integer> list = new ArrayList<>(); // Collection.List
        list.add(1);
        list.add(2);
        list.add(3);

        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);                      // Collection copied values to array
    }

}