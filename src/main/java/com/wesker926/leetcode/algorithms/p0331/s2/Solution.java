package com.wesker926.leetcode.algorithms.p0331.s2;

/**
 * @author wesker.gh
 * @date 2022/6/16
 * @description 计数
 * 与栈的解法思路相同，但空间O(1)
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        int cnt = 1;
        for (int i = 0; i < preorder.length(); i++) {
            char ch = preorder.charAt(i);
            if (ch == ',') {
                continue;
            }
            cnt--;
            if (cnt < 0) {
                return false;
            }
            if (ch != '#') {
                cnt += 2;
                for (; i < preorder.length() - 1 && preorder.charAt(i + 1) != ','; i++) {
                }
            }
        }
        return cnt == 0;
    }
}
