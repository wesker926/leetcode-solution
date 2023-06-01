package com.wesker926.leetcode.algorithms.p2517.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/6/1
 * @description 排序 + 二分
 * 最小最大/最大最小问题，二分代名词
 * 因为这类问题中，答案一般具备顺序性，更优的答案会要求更严苛，满足了更优答案则次优答案也能够满足，这就符合了二分的特性。
 * 比如二分找t，其实就是二分找不小于t的最小值，所寻找的区间本身必须有序，这样如果一个数小于t，那么比他更小的数就肯定也小于t，这样这个数左侧就不用考虑了
 */
public class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int l = 0, r = (price[price.length - 1] - price[0]) / (k - 1), m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(price, m, k)) l = m + 1;
            else r = m - 1;
        }
        return r;
    }

    private boolean check(int[] arr, int diff, int k) {
        int c = 1;
        for (int i = 1, pre = arr[0]; i < arr.length && c < k; i++) {
            if (arr[i] - pre >= diff) {
                pre = arr[i];
                c++;
            }
        }
        return c == k;
    }
}
