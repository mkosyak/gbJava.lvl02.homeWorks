package ru.geekBrains.l02.lesson03;

import java.util.*;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 */
public class WordCollections {
    private List<String> wordList = new ArrayList<String>();

    public WordCollections(String words[]) {
        System.out.printf("%n ---- Initial Array:");
//   Filling the Collection type ArrayList v.1
//        for (int n = 0; n < words.length; n++) {
//            wordList.add(words[n]);
//        }
//        System.out.printf("%nArray-> ArrayList (v1): %s", wordList);

//   Filling the Collection type ArrayList v.2.
        this.wordList = Arrays.asList(words);
        System.out.printf("%nArray-> ArrayList (v2): %s", wordList);
    }

    public void outWordsInfo(List<String> wordList) {

//  Obtaining HashedSet contained unique values
        Set<String> wordUniqSet = new HashSet(wordList); // Set keeps unique Words
        System.out.printf("%n>>Unique values . . . : %s", wordUniqSet.size());
        System.out.printf("%nArrayList-> HashSet (v1): %s", wordUniqSet);

//  Obtaining number of each word met in the set
        Map<String, Integer> wordGroupsMap = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            if (wordGroupsMap.containsKey(wordList.get(i))) {
                wordGroupsMap.put(wordList.get(i), wordGroupsMap.get(wordList.get(i)) + 1);
            } else {
                wordGroupsMap.put(wordList.get(i), 1);
            }
        }

        System.out.printf("%n%n>> Number of mentioning by words in the original Array:");
        System.out.printf("%nArrayList-> HashMAp (v1): %s", wordGroupsMap);
    }

    public void doTask02(List<String> wordList) {
    }
        public List<String> getWordList() {
        return wordList;
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }
}
