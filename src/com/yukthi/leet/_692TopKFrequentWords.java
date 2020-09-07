package com.yukthi.leet;

import java.util.*;

public class _692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        /*


            wordsList<Map.Entry<String,Ineger>>  = frequecyMap.entrySet();

            Sort wordsList using comparator
            Sorting condition
                (e1, e2)
                if(e1.value == e.value){
                    return e1.key compareTo e2.key
                } else {
                    return e2.value - e1.value
                }

            get the top k elemenst from sorted wordsList and return as result<String>

        */

        // frequecyMap
        Map<String, Integer> freqMap = new HashMap<>();

        for (String w : words) {
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }

        List<String> wordsList = new ArrayList<>(freqMap.keySet());

        wordsList.sort((w1, w2) -> {
            if (freqMap.get(w1).equals(freqMap.get(w2))) {
                return w1.compareTo(w2);
            }
            return freqMap.get(w2) - freqMap.get(w1);
        });

        return wordsList.subList(0, k);


    }

    public static void main(String[] args) {
        List<List<Integer>> g = new ArrayList<>();
        g.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        g.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));

        System.out.println(g.get(1).get(1));
        System.out.println(g.get(1).get(3));

    }


}
