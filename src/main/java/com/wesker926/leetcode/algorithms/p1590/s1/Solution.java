package com.wesker926.leetcode.algorithms.p1590.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/3/10
 * @description 前缀和
 * 很难想的一题，主要是取模原理。
 * 二元逆推性质：给定a和b，判断a与b的某种逻辑关联是否满足某种性质，且该性质能由b轻易推得a的某个特征键或所在的桶
 * 普遍是使用顺序遍历+哈希查询，类似的题有入站题两数之和
 * 定理一：给定正整数 x、y、z、p，如果 y mod p = x，那么 (y − z) mod p = 0 等价于 z mod p = x
 * 定理二：给定正整数 x，y，z，p，那么 (y − z) mod p = x 等价于 z mod p = (y − x) mod p
 * 思路：
 * 首先子数组基本可以确定要使用前缀和
 * 然后整除意味着要数组和要与子数组和同余，使用定理一，即 sum mod p = sub mod p = x
 * 其次sub = pre[j] - pre[i]，使用定理二，即pre[i] mod p = (pre[j] - x) mod p
 * 至此找到了pre[i]与pre[j]的关键性质，可使用二元逆推来解决
 */
public class Solution {
    public int minSubarray(int[] nums, int p) {
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int y = 0, res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(y, i);
            y = (y + nums[i]) % p;
            if (map.containsKey((y - x + p) % p)) {
                res = Math.min(res, i - map.get((y - x + p) % p) + 1);
            }
        }
        return res == nums.length ? -1 : res;
    }
}
