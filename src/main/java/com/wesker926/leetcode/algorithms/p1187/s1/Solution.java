package com.wesker926.leetcode.algorithms.p1187.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/4/20
 * @description DP
 * dp[i]表示对长度为i+1的数组保留arr1[i]的最优解，因为最终结果最后一位可能会被替换，因此需要增加尾哨兵
 * 对dp[i]前的连续j位进行替换，首先找到arr2中不小于arr1[i]的最小值的位置k，对每个j，需要arr2[k - j] > arr1[i - j - 1]，则可以更新dp[i]
 * 显然前面的数字也可能会被全部替换，因此需要增加头哨兵
 * <p>
 * 还有一种二维dp思路，dp[i][j]表示对长度为i+1的部分替换j次的最小末尾数字
 */
public class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length + 2, max = Integer.MAX_VALUE / 2;
        int[] temp = new int[n];
        System.arraycopy(arr1, 0, temp, 1, arr1.length);
        temp[0] = -1;
        temp[n - 1] = max;

        arr1 = temp;
        arr2 = sortAndDistinct(arr2);

        int[] dp = new int[n];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (arr1[i] > arr1[i - 1]) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            int k = binary(arr2, arr1[i]);
            for (int j = 1; j <= Math.min(i - 1, k); j++) {
                if (arr2[k - j] > arr1[i - j - 1]) {
                    dp[i] = Math.min(dp[i], dp[i - j - 1] + j);
                }
            }
        }
        return dp[n - 1] == max ? -1 : dp[n - 1];
    }

    private int binary(int[] arr, int t) {
        int l = 0, r = arr.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private int[] sortAndDistinct(int[] arr) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
