package com.wesker926.leetcode.algorithms.p0670.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/9/13
 * @description 贪心
 */
public class Solution {
    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }
        int[][] stat = new int[10][2];
        List<Integer> numList = new ArrayList<>();
        for (int idx = 0, cur; num > 0; num /= 10, idx++) {
            cur = num % 10;
            numList.add(cur);
            stat[cur][1] = stat[cur][0] == 0 ? idx : stat[cur][1];
            stat[cur][0]++;
        }
        for (int i = numList.size() - 1, j = 9, cur; i >= 0; i--, stat[j][0]--) {
            cur = numList.get(i);
            for (; stat[j][0] == 0; j--) {
            }
            if (cur != j) {
                numList.set(i, j);
                numList.set(stat[j][1], cur);
                break;
            }
        }
        int ans = 0;
        for (int i = numList.size() - 1; i >= 0; i--) {
            ans = ans * 10 + numList.get(i);
        }
        return ans;
    }
}
