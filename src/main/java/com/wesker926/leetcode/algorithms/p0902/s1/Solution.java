package com.wesker926.leetcode.algorithms.p0902.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/10/18
 * @description 数位DP
 * low为小于等于当前位数的数的个数
 */
public class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        List<Integer> list = new ArrayList<>(10);
        for (; n != 0; n /= 10) {
            list.add(n % 10);
        }
        int ans = -1, low = 1;
        for (int i = 0, cur = 1; i < list.size(); i++, cur *= digits.length) {
            ans += cur;
            int pos = Arrays.binarySearch(digits, String.valueOf(list.get(i)));
            low = pos < 0 ? (-pos - 1) * cur : pos * cur + low;
        }
        return ans + low;
    }
}
