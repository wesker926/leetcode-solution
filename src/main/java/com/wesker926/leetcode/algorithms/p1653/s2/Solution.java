package com.wesker926.leetcode.algorithms.p1653.s2;

/**
 * @author wesker.gh
 * @date 2023/3/6
 * @description 枚举
 * 将字符串分割成两部分，共n+1个分割点，统计最小的leftB+rightA
 */
public class Solution {
    public int minimumDeletions(String s) {
        int n = s.length(), leftB = 0, rightA = 0;
        for (int i = 0; i < n; i++) {
            rightA += 'b' - s.charAt(i);
        }
        int min = rightA;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightA--;
            } else {
                leftB++;
            }
            min = Math.min(min, leftB + rightA);
        }
        return min;
    }
}
