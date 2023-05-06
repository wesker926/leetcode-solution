package com.wesker926.leetcode.algorithms.p1419.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2023/5/6
 * @description 遍历 + 区间统计
 * 不是很好的写法
 */
public class Solution {

    private static final int[] IDX = new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 1};

    @SuppressWarnings("all")
    public int minNumberOfFrogs(String croakOfFrogs) {
        LinkedList[] lists = new LinkedList[5];
        for (int i = 0; i < 5; i++) lists[i] = new LinkedList<int[]>();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            int idx = IDX[croakOfFrogs.charAt(i) - 'a'];
            if (idx == 0) lists[0].offer(new int[]{i, 0});
            else if (lists[idx - 1].size() != 0) {
                int[] item = (int[]) lists[idx - 1].poll();
                lists[idx].offer(item);
                item[1] = i;
            } else return -1;
        }
        for (int i = 0; i < 4; i++) if (lists[i].size() != 0) return -1;
        int[][] arr = new int[lists[4].size()][];
        for (int i = 0; i < arr.length; i++) arr[i] = (int[]) lists[4].poll();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, binary(arr, i) - i + 1);
        }
        return ans;
    }

    private int binary(int[][] arr, int t) {
        int l = t + 1, r = arr.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m][0] < arr[t][1]) l = m + 1;
            else r = m - 1;
        }
        return r;
    }
}
