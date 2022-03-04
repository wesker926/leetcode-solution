package com.wesker926.leetcode.algorithms.p2104.s1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/3/4
 * @description 单调栈
 */
public class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[][] minArr = new int[2][n], maxArr = new int[2][n];
        Arrays.fill(minArr[1], n);
        Arrays.fill(maxArr[1], n);
        LinkedList<Integer> minStack = new LinkedList<>();
        LinkedList<Integer> maxStack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                minArr[1][minStack.pop()] = i;
            }
            minArr[0][i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);
            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                maxArr[1][maxStack.pop()] = i;
            }
            maxArr[0][i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        long sumMax = 0, sumMin = 0;
        for (int i = 0; i < n; i++) {
            sumMax += ((long) (i - maxArr[0][i])) * (maxArr[1][i] - i) * nums[i];
            sumMin += ((long) (i - minArr[0][i])) * (minArr[1][i] - i) * nums[i];
        }
        return sumMax - sumMin;
    }
}
