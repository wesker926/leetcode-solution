package com.wesker926.leetcode.algorithms.p1441.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/10/15
 * @description 模拟
 * 模拟栈操作
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new LinkedList<>();
        for (int i = 0, cur = 1; i < target.length; i++, cur++) {
            for (; cur < target[i]; cur++) {
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
        }
        return ans;
    }
}
