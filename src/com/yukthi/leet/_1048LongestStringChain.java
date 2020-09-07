package com.yukthi.leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _1048LongestStringChain {
    public int longestStrChain(String[] words) {

        Arrays.sort(words, (Comparator.comparingInt(String::length)));


        Map<String, Integer> map = new HashMap<>();


        int res = 0;

        for (String s : words) {
            map.put(s, 1);
        }

        for (String word : words) {
            System.out.println("Word = " + word);


            for (int j = 0; j < word.length(); j++) {
                String subWord = word.substring(0, j) + word.substring(j + 1);
                System.out.println("subWord = " + subWord);

                int count = 0;
                if (map.containsKey(subWord)) {
                    count = map.get(subWord);
                }
                int newCount = Math.max(count + 1, map.get(word));
                map.put(word, newCount);
                res = Math.max(res, newCount);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        String[] input = {"a","b","ba","bca","bda","bdca"};

        _1048LongestStringChain longestStringChain = new _1048LongestStringChain();

        System.out.println(longestStringChain.longestStrChain(input));
    }
}
