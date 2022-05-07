package com.wesker926.leetcode.algorithms.p0084.s1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/5/7
 * @description 严格单调增栈
 * 记录当前位置左右最近的较小高度的坐标
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftLow = new int[len];
        int[] rightLow = new int[len];
        Arrays.fill(rightLow, len);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            // 可以弹出相同高度的坐标，因为当前坐标可以替代它
            while (!stack.isEmpty() && heights[stack.peekFirst()] >= heights[i]) {
                rightLow[stack.pop()] = i;
            }
            leftLow[i] = stack.isEmpty() ? -1 : stack.peekFirst();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, heights[i] * (rightLow[i] - leftLow[i] - 1));
        }
        return ans;
    }
}
