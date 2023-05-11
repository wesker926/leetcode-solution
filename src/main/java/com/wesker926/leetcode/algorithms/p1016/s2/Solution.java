package com.wesker926.leetcode.algorithms.p1016.s2;

/**
 * @author wesker.gh
 * @date 2023/5/11
 * @description 暴力遍历
 * 为什么不会超时：
 * 随着n的增加，s的长度也要增加，而本题s最长1000，计算可得该长度m最多支撑n到2014（约2m），即超过2014便会返回false
 */
public class Solution {
    public boolean queryString(String s, int n) {
        for (int i = n; i > 0; i--) {
            if (!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }
}
