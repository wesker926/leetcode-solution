package com.wesker926.leetcode.algorithms.p0391.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/11/16
 * @description 扫描线
 */
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        int[][] lines = new int[n * 2][4];
        for (int i = 0; i < n; i++) {
            lines[i * 2] = new int[]{rectangles[i][0], rectangles[i][1], rectangles[i][3], 0};
            lines[i * 2 + 1] = new int[]{rectangles[i][2], rectangles[i][1], rectangles[i][3], 1};
        }
        Arrays.sort(lines, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        n *= 2;
        int[] cur, pre;
        List<int[]> ll = new LinkedList<>(), rl = new LinkedList<>(), tl;
        for (int l = 0, r; l < n; l = r) {
            for (r = l + 1; r < n && lines[r][0] == lines[l][0]; r++) {
            }

            ll.clear();
            rl.clear();
            for (int i = l; i < r; i++) {
                cur = new int[]{lines[i][1], lines[i][2]};
                tl = lines[i][3] == 0 ? ll : rl;

                if (tl.isEmpty()) {
                    tl.add(cur);
                    continue;
                }

                pre = tl.get(tl.size() - 1);
                if (cur[0] < pre[1]) {
                    return false;
                } else if (cur[0] == pre[1]) {
                    pre[1] = cur[1];
                } else {
                    tl.add(cur);
                }
            }

            if (l == 0 || r == n) {
                if (ll.size() + rl.size() != 1) {
                    return false;
                }
            } else {
                if (ll.size() != rl.size()) {
                    return false;
                }
                for (int i = 0; i < ll.size(); i++) {
                    if (ll.get(i)[0] != rl.get(i)[0] || ll.get(i)[1] != rl.get(i)[1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
