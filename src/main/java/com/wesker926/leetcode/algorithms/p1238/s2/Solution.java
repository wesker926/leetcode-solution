package com.wesker926.leetcode.algorithms.p1238.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/2/23
 * @description 格雷编码
 * 直接异或start即可
 * 异或start的正确之处在于：异或后以start开头，且异或后每一项和前后项的表示形式还是只有一位不同
 */
public class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(i ^ (i >> 1) ^ start);
        }
        return ans;
    }
}
