package com.wesker926.leetcode.lcof.p064.s1;

/**
 * @author wesker.gh
 * @date 2022/4/19
 * @description 脑筋急转弯（利用逻辑表达式短路特性）
 */
public class Solution {
    public int sumNums(int n) {
        boolean b = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
