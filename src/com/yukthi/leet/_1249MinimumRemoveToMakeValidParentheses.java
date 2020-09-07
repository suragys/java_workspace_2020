package com.yukthi.leet;

public class _1249MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        int openBracketCount = 0;

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openBracketCount++;
            } else if (c == ')') {
                if (openBracketCount == 0) {
                    continue;
                }
                openBracketCount--;
            }
            sb.append(c);
        }

        s = sb.toString();

        if (openBracketCount > 0) {
            sb = new StringBuffer();

            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '(' && openBracketCount > 0) {
                    openBracketCount--;
                    continue;
                }
                sb.append(c);
            }
            s = sb.reverse().toString();
        }

        return s;
    }
}
