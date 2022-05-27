package com.wesker926.leetcode.algorithms.p0149.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/5/27
 * @description 哈希表
 * 1. 通过最大公约数将斜率以最简分数表示
 * 2. 通过一个整数来组装x与y，用来当作key
 * 3. n不大于2时，可以直接返回n
 * 4. j只需要从i+1开始考虑，因为之前的部分已经在处理更小的i时考虑过了
 * 5. 当找到了严格超过半数点的答案时，已经能确定最大（对于偶数来说，等于半数并不可以，还可能存在半数+1的答案）
 * 6. 对于j，可能得到的最大答案为n-i，因此如果当前ans>n-i，即可停止
 */
public class Solution {
    public int maxPoints(int[][] points) {
        int ans = 0, n = points.length;
        if (n <= 2) {
            return n;
        }
        for (int i = 0; i < n; i++) {
            if (ans > n / 2 || ans >= n - i) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                } else {
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    int gcd = gcd(dx, Math.abs(dy));
                    dx /= gcd;
                    dy /= gcd;
                }
                int key = dx + dy * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (int count : map.values()) {
                ans = Math.max(ans, count + 1);
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
