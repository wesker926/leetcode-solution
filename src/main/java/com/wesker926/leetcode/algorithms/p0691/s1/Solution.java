package com.wesker926.leetcode.algorithms.p0691.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/14
 * @description 记忆化搜索
 */
public class Solution {
    public int minStickers(String[] stickers, String target) {
        int[][] buckets = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                buckets[i][c - 'a']++;
            }
        }
        int total = 1 << target.length();
        int[] memory = new int[total];
        Arrays.fill(memory, 1, memory.length, -1);
        // 即使每次只贡献一个字母，dfs也最多len层就会结束。如果无法拼接，则res会大于递归中的默认值，设置默认值len + 1即可。
        int res = dfs(buckets, target.toCharArray(), memory, total - 1);
        return res > target.length() ? -1 : res;
    }

    private int dfs(int[][] buckets, char[] target, int[] memory, int mask) {
        if (memory[mask] >= 0) {
            return memory[mask];
        }
        int res = target.length + 1;
        for (int[] b : buckets) {
            int left = mask;
            int[] bucket = Arrays.copyOf(b, b.length);
            for (int j = 0; j < target.length; j++) {
                if (((mask >> j) & 1) == 1 && bucket[target[j] - 'a'] > 0) {
                    bucket[target[j] - 'a']--;
                    left ^= 1 << j;
                }
            }
            if (left != mask) {
                res = Math.min(res, dfs(buckets, target, memory, left) + 1);
            }
        }
        memory[mask] = res;
        return res;
    }
}
