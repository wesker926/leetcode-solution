package com.wesker926.leetcode.algorithms.p1234.s1;

/**
 * @author wesker.gh
 * @date 2023/2/13
 * @description 滑动窗口
 * 注意，只需要判断每个字母不超过1/4即可。
 * j++会使外部count减少，因此执行j++直到符合条件；
 * i++会使外部count增加，因此在符合条件时执行i++直到不符合条件（并更新答案）；
 * 重复这一过程直至结束，因为i，j只增不减，因此为线性时间复杂度。
 */
public class Solution {

    private static final int[] IDX = new int[]{0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 1};

    public int balancedString(String s) {
        int n = s.length(), nd4 = n >> 2, ans = s.length();
        int[] counts = new int[4];
        for (int i = 0; i < n; i++) {
            counts[IDX[s.charAt(i) - 'A']]++;
        }
        if (check(counts, nd4)) {
            return 0;
        }
        for (int i = 0, j = 0; j < s.length(); j++) {
            counts[IDX[s.charAt(j) - 'A']]--;
            if (!check(counts, nd4)) {
                continue;
            }
            do {
                ans = Math.min(ans, j - i + 1);
                counts[IDX[s.charAt(i++) - 'A']]++;
            } while (check(counts, nd4));
        }
        return ans;
    }

    private boolean check(int[] counts, int nd4) {
        return counts[0] <= nd4 && counts[1] <= nd4 && counts[2] <= nd4 && counts[3] <= nd4;
    }
}
