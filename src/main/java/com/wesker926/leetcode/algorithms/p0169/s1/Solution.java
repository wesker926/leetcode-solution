package com.wesker926.leetcode.algorithms.p0169.s1;

/**
 * @author wesker.gh
 * @date 2022/6/7
 * @description Boyer-Moore 投票算法
 * 不太好证明，比较直观的理解是：把tar的得票数和非tar的得票数做抵消，则最后剩的一定是tar
 * 即使非tar在局部区域胜利，一定还存在另一个局部区域使tar可以扳回
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int ans = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
            }
            count += ans == num ? 1 : -1;
        }
        return ans;
    }
}
