package com.wesker926.leetcode.algorithms.p1629.s1;

/**
 * @author wesker.gh
 * @date 2022/1/9
 * @description 遍历
 */
public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] cs = keysPressed.toCharArray();
        int max = cs[0], maxTime = releaseTimes[0];
        for (int i = 1, t; i < releaseTimes.length; i++) {
            t = releaseTimes[i] - releaseTimes[i - 1];
            if (t > maxTime || (t == maxTime && cs[i] > max)) {
                max = cs[i];
                maxTime = t;
            }
        }
        return (char) max;
    }
}
