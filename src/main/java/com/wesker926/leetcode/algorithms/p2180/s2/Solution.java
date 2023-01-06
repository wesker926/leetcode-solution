package com.wesker926.leetcode.algorithms.p2180.s2;

/**
 * @author wesker.gh
 * @date 2023/1/6
 * @description 数学
 * 因为1不符合，而符合与不符合交替出现
 * 因此如果num符合，则存在num / 2个；如果num不符合，则存在(num - 1) / 2个
 * 解法一化简后可以得到解法二
 */
public class Solution {
    public int countEven(int num) {
        int sum = 0;
        for (int i = num; i > 0; i /= 10) {
            sum += i % 10;
        }
        return (num - (sum & 1)) / 2;
    }
}
