package com.wesker926.leetcode.algorithms.p0937.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/3
 * @description 排序
 */
public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] sp1 = o1.split(" ", 2);
            String[] sp2 = o2.split(" ", 2);
            boolean d1 = Character.isDigit(sp1[1].charAt(0));
            boolean d2 = Character.isDigit(sp2[1].charAt(0));
            if (!d1 && !d2) {
                int cmp = sp1[1].compareTo(sp2[1]);
                return cmp != 0 ? cmp : sp1[0].compareTo(sp2[0]);
            } else {
                return !d1 ? -1 : (d2 ? 0 : 1);
            }
        });
        return logs;
    }
}
