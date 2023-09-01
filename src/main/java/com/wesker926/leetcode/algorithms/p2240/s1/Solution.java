package com.wesker926.leetcode.algorithms.p2240.s1;

/**
 * @author wesker.gh
 * @date 2023/9/1
 * @description 枚举
 * 还有更牛的类欧几里得算法
 * https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils/solutions/2359649/mai-gang-bi-he-qian-bi-de-fang-an-shu-by-83nk/
 */
public class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int i = 0; i <= total; i += cost1) ans += (total - i) / cost2 + 1;
        return ans;
    }
}
