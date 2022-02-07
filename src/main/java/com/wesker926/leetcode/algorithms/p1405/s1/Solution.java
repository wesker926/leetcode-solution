package com.wesker926.leetcode.algorithms.p1405.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/2/7
 * @description 贪心 + 排序（或堆）
 */
public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[][]{{'a', a}, {'b', b}, {'c', c}};
        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);
        while (arr[0][1] > 0) {
            char ch = (char) arr[0][0];
            int cnt = arr[0][1] == 1 ? 1 : 2;
            sb.append(String.valueOf(ch).repeat(cnt));
            arr[0][1] -= cnt;
            if (arr[0][1] >= arr[1][1]) {
                if (arr[1][1] == 0) {
                    break;
                }
                sb.append((char) arr[1][0]);
                arr[1][1]--;
            }
            Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);
        }
        return sb.toString();
    }
}
