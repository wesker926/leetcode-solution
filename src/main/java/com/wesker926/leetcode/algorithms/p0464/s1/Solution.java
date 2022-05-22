package com.wesker926.leetcode.algorithms.p0464.s1;

/**
 * @author wesker.gh
 * @date 2022/5/22
 * @description DFS（记忆化搜索）
 */
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        return desiredTotal == 0 ||
                ((maxChoosableInteger + 1) * maxChoosableInteger / 2 >= desiredTotal &&
                        dfs(0, (1 << maxChoosableInteger) - 1, desiredTotal, new Boolean[1 << maxChoosableInteger]));
    }

    private boolean dfs(int curStatus, int mask, int target, Boolean[] memory) {
        if (target <= 0) {
            return false;
        }

        if (memory[curStatus] != null) {
            return memory[curStatus];
        }

        boolean win = false;
        for (int canUse = (~curStatus) & mask; canUse != 0 && !win; canUse &= canUse - 1) {
            int digit = Integer.bitCount((canUse & (-canUse)) - 1) + 1;
            win = !dfs(curStatus | (1 << (digit - 1)), mask, target - digit, memory);
        }
        memory[curStatus] = win;
        return win;
    }
}
