package com.wesker926.leetcode.algorithms.p0481.s1;

/**
 * @author wesker.gh
 * @date 2022/10/31
 * @description 双指针
 * 起始字符相同，构造逻辑相同，则字符串是固定的
 */
public class Solution {
    public int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }
        int ans = 1;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = arr[2] = 2;
        for (int i = 2, j = 3; j < arr.length; i++) {
            for (int k = j, t = arr[j - 1] ^ 3; k < j + arr[i] && k < arr.length; k++) {
                arr[k] = t;
            }
            if (arr[j - 1] == 2) {
                ans += Math.min(arr[i], arr.length - j);
            }
            j += arr[i];
        }
        return ans;
    }
}
