package com.wesker926.leetcode.algorithms.p1276.s1;

import java.util.Collections;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/12/25
 * @description 鸡兔同笼
 */
public class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int x = tomatoSlices - cheeseSlices * 2, y = cheeseSlices - (x >> 1);
        if (x < 0 || (x & 1) != 0 || y < 0) return Collections.emptyList();
        return List.of(x >> 1, y);
    }
}
