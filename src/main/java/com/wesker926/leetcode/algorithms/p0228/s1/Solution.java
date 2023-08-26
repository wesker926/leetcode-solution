package com.wesker926.leetcode.algorithms.p0228.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/8/26
 * @description 遍历
 * 分组循环（两层循环）是解决此类方法的最优方式，无需特判数组是否为空，也无需在循环结束后，再补上处理最后一段区间的逻辑
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int l = nums[i], r = l;
            for (i++; i < nums.length && nums[i] == r + 1; r++, i++) ;
            StringBuilder sb = new StringBuilder().append(l);
            if (r != l) sb.append("->").append(r);
            ans.add(sb.toString());
        }
        return ans;
    }
}
