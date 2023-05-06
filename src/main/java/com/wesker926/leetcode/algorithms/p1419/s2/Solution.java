package com.wesker926.leetcode.algorithms.p1419.s2;

/**
 * @author wesker.gh
 * @date 2023/5/6
 * @description 遍历计数
 */
public class Solution {

    private static final int[] IDX = new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 1};

    public int minNumberOfFrogs(String croakOfFrogs) {
        int ans = 0;
        int[] count = new int[5];
        for (char ch : croakOfFrogs.toCharArray()) {
            int idx = IDX[ch - 'a'];
            if (idx == 0) count[0]++;
            else if (count[idx - 1] != 0) {
                count[idx - 1]--;
                count[idx]++;
            } else return -1;
            ans = Math.max(ans, count[0] + count[1] + count[2] + count[3]);
        }
        return count[0] != 0 || count[1] != 0 || count[2] != 0 || count[3] != 0 ? -1 : ans;
    }
}
