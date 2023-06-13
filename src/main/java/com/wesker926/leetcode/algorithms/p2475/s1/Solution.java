package com.wesker926.leetcode.algorithms.p2475.s1;

/**
 * @author wesker.gh
 * @date 2023/6/13
 * @description 哈希表
 * 以某一堆相同的数 [i,j) 作为三元组的中间元素时，这堆相同的元素的左边元素数目为 i，右边元素数目为 n − j
 * 因此贡献了i * (j - i) * (n - j)个
 */
public class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length, t = 0, i = 0, ans = 0;
        int[] table = new int[1001];
        for (int num : nums) if (table[num]++ == 0) t++;
        int[] counts = new int[t];
        for (int count : table) if (count != 0) counts[i++] = count;
        for (i = 0, t = 0; i < counts.length; t += counts[i], i++) {
            ans += t * counts[i] * (n - t - counts[i]);
        }
        return ans;
    }
}
