package com.wesker926.leetcode.algorithms.p1224.s1;

/**
 * @author wesker.gh
 * @date 2022/8/18
 * @description 哈希表 + 分情况讨论
 * 三种情况：
 * 1.所有数出现的次数都是1
 * 2.最大出现次数的数的个数是1，其余数的出现次数全是最大出现次数减1
 * 3.一个数的出现次数是1，其余数全是最大出现次数
 */
public class Solution {
    public int maxEqualFreq(int[] nums) {
        int ans = 0, maxCount = 0;
        int[] count = new int[100001];
        int[] freq = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (count[num] != 0) {
                freq[count[num]]--;
            }
            count[num]++;
            maxCount = Math.max(maxCount, count[num]);
            freq[count[num]]++;
            if (maxCount == 1 ||
                    (freq[maxCount] * maxCount + freq[maxCount - 1] * (maxCount - 1) == i + 1 && freq[maxCount] == 1) ||
                    (freq[maxCount] * maxCount == i && freq[1] == 1)) {
                ans = Math.max(ans, i + 1);
            }
        }
        return ans;
    }
}
