package com.wesker926.leetcode.algorithms.p0496.s1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2021/10/26
 * @description map + stack
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] map = new int[10001];
        Arrays.fill(map, -1);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int cur : nums2) {
            while (!stack.isEmpty() && stack.peekFirst() < cur) {
                map[stack.pop()] = cur;
            }
            stack.push(cur);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map[nums1[i]];
        }
        return result;
    }
}
