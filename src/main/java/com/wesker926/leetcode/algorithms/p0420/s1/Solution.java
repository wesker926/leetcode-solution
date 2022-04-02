package com.wesker926.leetcode.algorithms.p0420.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/4/2
 * @description 分类讨论 + 堆
 */
public class Solution {
    public int strongPasswordChecker(String password) {
        char[] ps = password.toCharArray();
        List<Integer> repeats = new ArrayList<>(32);
        int n = ps.length, lack = 0, add = 0, sub = 0, replace = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o % 3));
        for (int i = 0, j; i < n; i = j) {
            char ch = ps[i];
            if (Character.isUpperCase(ch)) {
                lack |= 1;
            } else if (Character.isLowerCase(ch)) {
                lack |= 2;
            } else if (Character.isDigit(ch)) {
                lack |= 4;
            }
            for (j = i + 1; j < n && ps[i] == ps[j]; j++) {
            }
            if (j - i > 2) {
                repeats.add(j - i);
            }
        }
        lack = 3 - Integer.bitCount(lack);

        if (n < 6) {
            for (int i = 0, count = 6 - n; i < repeats.size(); i++) {
                int cur = (repeats.get(i) + 1) / 2 - 1;
                repeats.set(i, repeats.get(i) - Math.min(count, cur) * 2);
                count = Math.max(0, count - cur);
            }
            add = 6 - n;
            lack = Math.max(0, lack - add);
        } else if (n > 20) {
            queue.addAll(repeats);
            while (!queue.isEmpty() && n > 20) {
                int cur = queue.poll();
                int step = Math.min(n - 20, (cur % 3) + 1);
                n -= step;
                cur -= step;
                sub += step;
                if (cur > 2) {
                    queue.offer(cur);
                }
            }
            sub += n - 20;
            repeats.clear();
            repeats.addAll(queue);
        }

        for (Integer i : repeats) {
            replace += i / 3;
        }
        replace = Math.max(replace, lack);

        return add + replace + sub;
    }
}
