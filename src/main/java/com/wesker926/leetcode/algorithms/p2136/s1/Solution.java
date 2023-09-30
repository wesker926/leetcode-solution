package com.wesker926.leetcode.algorithms.p2136.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/9/30
 * @description 排序 + 贪心
 * 连续种植同一个是最优的，拆开只会相同或者更坏；优先种植生长慢的是最优的，否则只会相同或者更坏
 * https://leetcode.cn/problems/earliest-possible-day-of-full-bloom/solutions/1202113/quan-bu-kai-hua-de-zui-zao-yi-tian-by-le-ocxg/?envType=daily-question&envId=2023-09-30
 */
public class Solution {
    @SuppressWarnings("all")
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length, time = 0, ans = 0;
        List[] table = new List[10001];
        for (int i = 0; i < n; i++) {
            if (table[growTime[i]] == null) table[growTime[i]] = new ArrayList<Integer>();
            table[growTime[i]].add(plantTime[i]);
        }
        for (int i = table.length - 1; i >= 0; i--) {
            if (table[i] == null) continue;
            for (int j : (ArrayList<Integer>) table[i]) {
                ans = Math.max(ans, (time += j) + i);
            }
        }
        return ans;
    }
}
