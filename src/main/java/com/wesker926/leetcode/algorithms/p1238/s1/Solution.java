package com.wesker926.leetcode.algorithms.p1238.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/2/23
 * @description 格雷编码
 * 逆向出start的idx后生成
 */
public class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        int idx = 0;
        if (start != 0) {
            int h = n;
            for (; (start & (1 << h)) == 0; h--) ;
            for (idx = 1, h--; h >= 0; h--) {
                idx = (idx << 1) | (((start >> h) & 1) ^ (idx & 1));
            }
        }
        return generate(1 << n, idx);
    }

    private List<Integer> generate(int total, int idx) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            int cur = (i + idx) % total;
            ans.add(cur ^ (cur >> 1));
        }
        return ans;
    }
}
