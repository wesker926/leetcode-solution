package com.wesker926.leetcode.algorithms.p1996.s1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/1/28
 * @description 排序（0升1降） + 单调栈
 */
public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
        LinkedList<int[]> stack = new LinkedList<>();
        int ans = 0;
        for (int[] cur : properties) {
            while (!stack.isEmpty() && stack.peek()[1] < cur[1]) {
                stack.pop();
                ans++;
            }
            stack.push(cur);
        }
        return ans;
    }
}
