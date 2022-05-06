package com.wesker926.leetcode.algorithms.p0078.s2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/6
 * @description 枚举（位运算）
 * nums中的数可以用一个n位的二进制数表示是否选中，1<<n即为子集数
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0, total = 1 << nums.length; i < total; i++) {
            List<Integer> cur = new LinkedList<>();
            for (int j = i, k = 0; j > 0; j >>= 1, k++) {
                if ((j & 1) == 1) {
                    cur.add(nums[k]);
                }
            }
            ans.add(cur);
        }
        return ans;
    }
}
