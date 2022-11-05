package com.wesker926.leetcode.algorithms.p1106.s1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/11/5
 * @description 递归
 */
public class Solution {
    public boolean parseBoolExpr(String expression) {
        return recursion(expression.toCharArray(), 0, expression.length() - 1);
    }

    @SuppressWarnings("all")
    private boolean recursion(char[] expression, int st, int ed) {
        if (Character.isLetter(expression[st])) {
            return expression[st] == 't';
        }
        if (expression[st] == '!') {
            return !recursion(expression, st + 2, ed - 1);
        }
        Deque<int[]> queue = new LinkedList<>();
        for (int i = st + 2, j = i, c = 0; j <= ed; j++) {
            c += expression[j] == '(' ? 1 : (expression[j] == ')' ? -1 : 0);
            if ((c == 0 && expression[j] == ',') || j == ed) {
                int[] idx = new int[]{i, j - 1};
                boolean useless = idx[0] == idx[1] ? queue.offerFirst(idx) : queue.offerLast(idx);
                i = j + 1;
            }
        }
        boolean isAnd = expression[st] == '&', res = isAnd;
        for (int[] idx : queue) {
            boolean cur = recursion(expression, idx[0], idx[1]);
            res = isAnd ? (res && cur) : (res || cur);
            if ((isAnd && !res) || (!isAnd && res)) {
                break;
            }
        }
        return res;
    }
}
