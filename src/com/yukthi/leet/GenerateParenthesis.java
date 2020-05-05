package com.yukthi.leet;

import java.util.*;

public class GenerateParenthesis {

    int num = 0;

    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
//        allCombinations("", n, result);
        result.add("");
        Set<String> result2 = combinations(result,n);
        return new ArrayList<String>(result2);
    }

    void allCombinations(String s, int n, Set<String> brackets) {
        if (n == 0) {
            brackets.add(s);
            System.out.println(++num);
            System.out.println(s);
        } else {
            // add front
            String fs = "()" + s;
            // add back
            String bs = s + "()";
            // surround
            String ss = "(" + s + ")";
            n--;
            allCombinations(fs, n, brackets);
            allCombinations(bs, n, brackets);
            allCombinations(ss, n, brackets);
        }


    }

    Set<String> combinations(Set<String> combinations, int n) {
        System.out.println(combinations);
        if(n == 0) return combinations;
        Set<String> set = new HashSet<>();
        for(String s: combinations){
            String ls = "()" + s;
            String rs = s + "()";
            String ss = "(" + s + ")";
            set.add(ls);
            set.add(rs);
            set.add(ss);
        }
        return combinations(set, --n);
    }


    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> r = gp.generateParenthesis(4);
        Collections.sort(r);
        System.out.println(r);
        System.out.println(r.size());
        for (String s :
                r) {
            System.out.println(s);
        }

    }

    /*
    ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
    [(((()))),   ((()())),  ((())()),  ((()))(),  (()(())),  (()()()),  (()())(),             (())()(),  ()((())),  ()(()()),  ()(())(),  ()()(()),  ()()()()]
     */
}
