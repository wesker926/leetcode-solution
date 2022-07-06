package com.wesker926.leetcode.algorithms.p0736.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/7/6
 * @description 递归解析
 */
public class Solution {
    public int evaluate(String expression) {
        List<String> split = new ArrayList<>();
        for (int i = 0, j = 0; j <= expression.length(); j++) {
            if (j == expression.length() || expression.charAt(j) == ' ') {
                int k = i;
                for (; expression.charAt(k) == '('; k++) {
                    split.add("(");
                }
                i = k;
                for (; expression.charAt(k) != ')' && k < j; k++) {
                }
                split.add(expression.substring(i, k));
                for (; k < j; k++) {
                    split.add(")");
                }
                i = j + 1;
            }
        }
        return compute(split.toArray(String[]::new), 0, split.size() - 1, new HashMap<>());
    }

    private int compute(String[] expr, int st, int ed, Map<String, LinkedList<Integer>> varVal) {
        if (st == ed) {
            return Character.isLetter(expr[st].charAt(0)) ? varVal.get(expr[st]).peekFirst() : Integer.parseInt(expr[st]);
        }
        if ("(".equals(expr[st])) {
            return compute(expr, st + 1, ed - 1, varVal);
        } else if ("add".equals(expr[st]) || "mult".equals(expr[st])) {
            int i = st + 1, e1, e2;
            if (!"(".equals(expr[i])) {
                e1 = compute(expr, i, i, varVal);
                i++;
            } else {
                int j = i + 1, count = 1;
                for (; count > 0; j++) {
                    if ("(".equals(expr[j])) {
                        count++;
                    } else if (")".equals(expr[j])) {
                        count--;
                    }
                }
                e1 = compute(expr, i + 1, j - 2, varVal);
                i = j;
            }
            e2 = compute(expr, i, ed, varVal);
            return "add".equals(expr[st]) ? e1 + e2 : e1 * e2;
        } else {
            LinkedList<String> stack = new LinkedList<>();
            int i = st + 1;
            while (i < ed && !expr[i].equals("(")) {
                stack.push(expr[i]);
                LinkedList<Integer> val = varVal.computeIfAbsent(expr[i], k -> new LinkedList<>());
                if (!"(".equals(expr[i + 1])) {
                    val.push(compute(expr, i + 1, i + 1, varVal));
                    i += 2;
                    continue;
                }
                int j = i + 2, count = 1;
                for (; count > 0; j++) {
                    if ("(".equals(expr[j])) {
                        count++;
                    } else if (")".equals(expr[j])) {
                        count--;
                    }
                }
                val.push(compute(expr, i + 2, j - 2, varVal));
                i = j;
            }
            int res = compute(expr, i, ed, varVal);
            while (!stack.isEmpty()) {
                varVal.get(stack.pop()).pop();
            }
            return res;
        }
    }
}
