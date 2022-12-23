package com.wesker926.leetcode.algorithms.p2011.s1;

/**
 * @author wesker.gh
 * @date 2022/12/23
 * @description 模拟
 * 1.第二个符号可以判断增减
 * 2.ascii码中，+为43，-为45，因此还可以用(44 - char)作为加数
 */
public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            ans += operation.charAt(1) == '+' ? 1 : -1;
        }
        return ans;
    }
}
