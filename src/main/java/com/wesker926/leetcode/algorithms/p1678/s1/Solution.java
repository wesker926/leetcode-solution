package com.wesker926.leetcode.algorithms.p1678.s1;

/**
 * @author wesker.gh
 * @date 2022/11/6
 * @description 遍历
 */
public class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (command.charAt(i) == ')') {
                sb.append(command.charAt(i - 1) == '(' ? "o" : "al");
            }
        }
        return sb.toString();
    }
}
