package com.wesker926.leetcode.algorithms.p0006.s1;

/**
 * @author wesker.gh
 * @date 2022/3/1
 * @description 周期性构造
 */
public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || len <= numRows) {
            return s;
        }
        char[] origin = s.toCharArray(), res = new char[len];
        int idx = 0, step = (numRows - 1) * 2, t;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += step) {
                res[idx++] = origin[j];
                if (i != 0 && i != numRows - 1 && (t = j + step - i * 2) < len) {
                    res[idx++] = origin[t];
                }
            }
        }
        return new String(res);
    }
}
