package com.wesker926.leetcode.algorithms.p0670.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/9/13
 * @description 贪心
 * 不是单调栈！
 */
public class Solution {
    public int maximumSwap(int num) {
        if (num < 10) return num;
        int[] idx = new int[10], cnt = new int[10];
        List<Integer> list = new ArrayList<>();
        for (int i = 0, cur; num > 0; num /= 10, i++) {
            cur = num % 10;
            if (idx[cur] == 0) idx[cur] = i + 1;
            list.add(cur);
            cnt[cur]++;
        }
        for (int i = list.size() - 1, j = 9, cur; i >= 0; i--, cnt[j]--) {
            cur = list.get(i);
            while (cnt[j] <= 0) j--;
            if (cur == j) continue;
            list.set(i, j);
            list.set(idx[j] - 1, cur);
            break;
        }

        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res = res * 10 + list.get(i);
        }
        return res;
    }
}
