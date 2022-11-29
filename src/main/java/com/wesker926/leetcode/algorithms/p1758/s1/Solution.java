package com.wesker926.leetcode.algorithms.p1758.s1;

/**
 * @author wesker.gh
 * @date 2022/11/29
 * @description 遍历模拟
 * 统计两种情况需要操作的次数
 */
public class Solution {
    public int minOperations(String s) {
        int n = s.length(), count = 0;
        boolean isEven = true;
        for (char c : s.toCharArray()) {
            if ((isEven && c == '0') || (!isEven && c == '1')) {
                count++;
            }
            isEven = !isEven;
        }
        return Math.min(count, n - count);
    }
}
