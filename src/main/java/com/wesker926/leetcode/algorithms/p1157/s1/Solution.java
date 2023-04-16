package com.wesker926.leetcode.algorithms.p1157.s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/4/16
 * @description 二进制前缀和
 * 很巧妙，记录每个二进制位的前缀和，根据每个位的数量构建候选
 * 如果某一位0或1都不足阈值则必不存在，否则可以构造出候选
 * 存在绝对众数 <-> 候选存在且满足阈值 充要条件
 * <p>
 * 可以进行空间优化，见s2
 * 这题官解用的 Boyer-Moore 投票算法 + 线段树
 */
@SuppressWarnings("all")
public class Solution {

    private final List[] idx;

    private final int[][] pre;

    public Solution(int[] arr) {
        this.idx = new List[20001];
        this.pre = new int[arr.length + 1][16];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 16; j++) {
                pre[i + 1][j] = pre[i][j] + ((arr[i] >> j) & 1);
            }
            if (idx[arr[i]] == null) {
                idx[arr[i]] = new ArrayList<Integer>();
            }
            idx[arr[i]].add(i);
        }
    }

    public int query(int left, int right, int threshold) {
        int candidate = 0;
        for (int i = 0; i < 16; i++) {
            int one = pre[right + 1][i] - pre[left][i], zero = right - left + 1 - one;
            if (one < threshold && zero < threshold) {
                return -1;
            } else if (one >= threshold) {
                candidate |= 1 << i;
            }
        }
        List<Integer> idx = this.idx[candidate];
        if (idx == null) {
            return -1;
        }
        int l = Collections.binarySearch(idx, left), r = Collections.binarySearch(idx, right + 1);
        return (r >= 0 ? r : -r - 1) - (l >= 0 ? l : -l - 1) >= threshold ? candidate : -1;
    }
}
