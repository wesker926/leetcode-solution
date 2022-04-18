package com.wesker926.leetcode.lcof.p057_2.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description 双指针
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new LinkedList<>();
        for (int i = 1, j = 2, sum; j <= (target + 1) / 2; j++) {
            sum = (j + i) * (j - i + 1) / 2;
            if (sum >= target) {
                if (sum == target) {
                    int[] t = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        t[k - i] = k;
                    }
                    ans.add(t);
                }
                i++;
                j--;
            }
        }
        return ans.toArray(new int[0][]);
    }
}
