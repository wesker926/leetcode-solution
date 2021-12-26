package com.wesker926.leetcode.algorithms.p1078.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/12/26
 * @description 遍历
 */
public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.trim().split(" ");
        List<String> res = new LinkedList<>();
        for (int i = 0; i < split.length - 2; i++) {
            if (split[i].equals(first) && split[i + 1].equals(second)) {
                res.add(split[i + 2]);
            }
        }
        return res.toArray(new String[0]);
    }
}
