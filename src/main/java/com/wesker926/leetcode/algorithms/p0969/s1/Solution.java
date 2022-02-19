package com.wesker926.leetcode.algorithms.p0969.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/2/19
 * @description 类选择排序
 */
public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new LinkedList<>();
        for (int i = arr.length - 1, j; i >= 0; i--) {
            if (arr[i] != i + 1) {
                for (j = 0; arr[j] != i + 1; j++) {
                }
                if (j != 0) {
                    ans.add(j + 1);
                    reverse(arr, j);
                }
                ans.add(i + 1);
                reverse(arr, i);
            }
        }
        return ans;
    }

    private void reverse(int[] arr, int ed) {
        for (int st = 0, t; st < ed; st++, ed--) {
            t = arr[st];
            arr[st] = arr[ed];
            arr[ed] = t;
        }
    }
}
