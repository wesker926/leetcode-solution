package com.wesker926.leetcode.algorithms.p0168.s1;

/**
 * @author wesker.gh
 * @date 2022/6/7
 * @description 26进制
 * 普通的26进制在处理每一位的时候减少1即为当前的26进制
 * 普通26进制：AB -> 26 * (0) + (1)
 * 当前26进制：AB -> 26 * (0 + 1) + (1 + 1)
 * 注：也可以用累加公式来推导
 */
public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
