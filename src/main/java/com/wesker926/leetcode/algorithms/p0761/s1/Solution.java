package com.wesker926.leetcode.algorithms.p0761.s1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/8/8
 * @description 分治
 * 注：可以理解成左右括号，方便想象
 * 规律：
 * 1.任何不可再分割的特殊序列都是1开始0结尾，这时可以直接处理substring(i + 1, j)，因为开头结尾已经最优
 * 2.任何可以分割的特殊序列，其最优结果是每个子序列的最优结果的降序排列
 * 3.不可能跨子序列发生交换，因为无法满足特殊序列要求（任何前缀中1大于等于0，从后缀角度考虑这条无法实现）
 */
public class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        List<String> sub = new ArrayList<>();
        for (int i = 0, j = 0, k = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                k++;
            } else {
                k--;
                if (k == 0) {
                    sub.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
                    i = j + 1;
                }
            }
        }
        sub.sort(Comparator.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for (String str : sub) {
            ans.append(str);
        }
        return ans.toString();
    }
}
