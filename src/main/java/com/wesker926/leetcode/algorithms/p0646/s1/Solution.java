package com.wesker926.leetcode.algorithms.p0646.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2021/12/24
 * @description 贪心
 * 经典贪心（一定要记住）：
 * 所找的第一个对一定是右界最小的对（留的选择余地最大）
 * 然后后续找的对，在满足前一个对的情况下，继续找右界最小的
 * 因此：按照右界排序，以第一对为起始，以此找符合的对
 * <p>
 * 这题还有O(n2)（以对数下标转移）的dp解法
 * 和O(nlogn)（记录链的每个节点可以取到的右界最小值）的贪心+二分解法
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
        int ans = 1;
        for (int i = 1, limit = pairs[0][1]; i < pairs.length; i++) {
            if (pairs[i][0] <= limit) {
                continue;
            }
            ans++;
            limit = pairs[i][1];
        }
        return ans;
    }
}
