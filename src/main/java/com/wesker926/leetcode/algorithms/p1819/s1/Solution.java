package com.wesker926.leetcode.algorithms.p1819.s1;

/**
 * @author wesker.gh
 * @date 2023/1/14
 * @description 数论（枚举）
 * 所有可能的子序列有(2^n - 1)个，n很大不用考虑，因此考虑值域，为[1, max]
 * 首先，x作为最大公约数只可能出现在x的倍数组成的序列当中
 * 其次，只要任意x倍数的最大公约数为x，则x所有倍数的最大公约数都是x，即短路性质
 * 因此，枚举x，判断x是否符合即可得到答案，共进行了(n/1 + n/2 + ... + n/n)次计算，即nlogn（调和级数）时间复杂度
 * 优化：如果x存在，则x必为一种答案，因此不需要额外判断；
 * 优化：如果x不存在，则x至少存在两个倍数才可能为答案，即x必须不大于max/3（否则不可能存在至少两个倍数），因此外层枚举可优化至max/3次
 */
public class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0, max = nums[0];
        for (int num : nums) max = Math.max(max, num);
        boolean[] contains = new boolean[max + 1];
        for (int num : nums) {
            if (!contains[num]) {
                contains[num] = true;
                ans++;
            }
        }
        for (int i = 1; i <= max / 3; i++) {
            if (contains[i]) {
                continue;
            }
            for (int j = i * 2, gcd = 0; j <= max; j += i) {
                if (!contains[j]) {
                    continue;
                }
                gcd = gcd(gcd, j);
                if (gcd == i) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
