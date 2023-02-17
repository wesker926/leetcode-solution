package com.wesker926.leetcode.algorithms.p1237.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/2/18
 * @description 双指针
 * 二分不是最优解
 * 因为单调递增的性质，对于某个X，如果存在Y使f(X, Y) = Z，则Y取值是唯一的。并且X越大，Y越小
 * 可以看到，对于f(X, Y)，其与Z比较后的操作可以使X，Y相对而行，因此可以用双指针来解
 */
public class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
            for (; y >= 1 && customfunction.f(x, y) > z; y--) ;
            if (y >= 1 && customfunction.f(x, y) == z) {
                ans.add(List.of(x, y));
            }
        }
        return ans;
    }

    private interface CustomFunction {
        int f(int x, int y);
    }
}
