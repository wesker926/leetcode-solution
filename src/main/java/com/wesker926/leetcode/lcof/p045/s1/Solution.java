package com.wesker926.leetcode.lcof.p045.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/4/15
 * @description 排序（可用反证法证明）
 */
public class Solution {
    public String minNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums).boxed().sorted((o1, o2) -> (o1.toString() + o2).compareTo((o2.toString() + o1))).forEach(sb::append);
        return sb.toString();
    }
}
