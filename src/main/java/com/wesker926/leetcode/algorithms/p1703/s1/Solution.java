package com.wesker926.leetcode.algorithms.p1703.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/12/18
 * @description 贪心 + 前缀和
 * 直接滑动窗口 + 1的前缀和写法会超时（写法1），需要对每个0计算，因此需要使用1的滑动窗口 + 0的前缀和（写法2）；
 * 写法2中，是根据每段中0的个数zero[i]去滑动，使用zeroPre[i]来加速（zeroPre即sumZero）
 * 这种写法仍可以改进，可以观察到每次滑动都是根据mid前减后增，保持当前延mid的金字塔分布
 * 这时可以用1的滑动窗口 + 0sum的前缀和sumPre来解（写法3）
 * 通过对mid左右各取间隔相等的两个sumPre相减，再将两个结果相减，即可得到延mid的金字塔分布
 * 对于偶数可以使用sumZero来修正
 * 对于写法4，还可以通过nums维护sums，通过三个变量优化pres，无需额外空间开销
 */
public class Solution {
    public int minMoves(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        List<Integer> sums = new ArrayList<>();
        List<Integer> pres = new ArrayList<>();
        pres.add(0);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += 1 - nums[i];
            if (nums[i] == 1) {
                sums.add(sum);
                pres.add(pres.get(pres.size() - 1) + sum);
            }
        }
        int n = pres.size() - 1, ans = Integer.MAX_VALUE;
        for (int i = 0; i <= (n - k); i++) {
            int mid = i + k / 2;
            ans = Math.min(ans,
                    (1 - k % 2) * sums.get(mid) + (pres.get(i + k) - pres.get(mid + 1)) - (pres.get(mid) - pres.get(i))
            );
        }
        return ans;
    }
}
