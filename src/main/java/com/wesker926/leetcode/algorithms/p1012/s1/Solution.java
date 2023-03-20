package com.wesker926.leetcode.algorithms.p1012.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/3/20
 * @description 组合数迭代
 * 自己写的：用阶乘算出不重复数字的组合数x，然后用总数减去，n + 1 - x
 */
public class Solution {
    public int numDupDigitsAtMostN(int n) {
        if (n < 11) {
            return 0;
        }
        List<Integer> num = new ArrayList<>();
        for (int i = n; i != 0; i /= 10) {
            num.add(i % 10);
        }
        int l = num.size(), res = n;
        for (int i = 1; i < l; i++) {
            res -= 9 * factorial(9, i - 1);
        }
        boolean[] table = new boolean[10];
        for (int i = 0; i <= l; i++) {
            if (i > 0) {
                if (table[num.get(l - i)]) {
                    break;
                }
                table[num.get(l - i)] = true;
            }
            if (i == l) {
                res -= 1;
                break;
            }
            int cur = num.get(l - 1 - i) - (i == 0 ? 1 : 0);
            for (int j = cur - 1; j >= 0; j--) {
                if (table[j]) {
                    cur--;
                }
            }
            res -= cur * factorial(9 - i, l - i - 1);
        }
        return res;
    }

    private int factorial(int n, int i) {
        int ans = 1;
        for (; i > 0; i--, n--) {
            ans *= n;
        }
        return ans;
    }
}
