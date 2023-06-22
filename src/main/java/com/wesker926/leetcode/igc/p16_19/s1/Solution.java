package com.wesker926.leetcode.igc.p16_19.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/6/22
 * @description DFS
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{1, 1}, {1, 0}, {1, -1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, 1}, {0, -1}};

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++)
            for (int j = 0; j < land[0].length; j++)
                if (land[i][j] == 0) list.add(dfs(land, i, j));
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        Arrays.sort(ans);
        return ans;
    }

    private int dfs(int[][] land, int i, int j) {
        land[i][j] = -1;
        int count = 1;
        for (int[] dir : DIRS) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni < 0 || ni >= land.length || nj < 0 || nj >= land[0].length || land[ni][nj] != 0) continue;
            count += dfs(land, ni, nj);
        }
        return count;
    }
}
