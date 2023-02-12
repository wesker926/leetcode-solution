package com.wesker926.leetcode.algorithms.p1138.s1;

/**
 * @author wesker.gh
 * @date 2023/2/12
 * @description 模拟
 * 规避z的问题即可
 */
public class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, pre = 0, cur; i < target.length(); pre = cur, i++) {
            cur = target.charAt(i) - 'a';
            int rowDiff = (cur / 5) - (pre / 5), colDiff = (cur % 5) - (pre % 5);
            String horizontal = colDiff >= 0 ? "R".repeat(colDiff) : "L".repeat(-colDiff);
            if (rowDiff >= 0) {
                sb.append(horizontal).append("D".repeat(rowDiff));
            } else {
                sb.append("U".repeat(-rowDiff)).append(horizontal);
            }
            sb.append('!');
        }
        return sb.toString();
    }
}
