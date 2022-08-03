package com.wesker926.leetcode.algorithms.p0899.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/8/3
 * @description 分情况讨论
 * k=1时只能滚动
 * k>1时一定可以转换为升序字符串（k>1可以实现交换两个相邻元素，即可实现冒泡排序）
 */
public class Solution {
    public String orderlyQueue(String s, int k) {
        if (k != 1) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }
        int min = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            min = Math.min(min, s.charAt(i));
        }
        String ans = s;
        for (int i = s.indexOf((char) min); i >= 0; i = s.indexOf((char) min, i + 1)) {
            String cur = s.substring(i) + s.substring(0, i);
            if (ans.compareTo(cur) > 0) {
                ans = cur;
            }
        }
        return ans;
    }
}
