package com.wesker926.leetcode.algorithms.p1417.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/8/11
 * @description 遍历 + 队列 + 交替拼接
 */
public class Solution {
    public String reformat(String s) {
        Queue<Character> digit = new LinkedList<>();
        Queue<Character> letter = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digit.offer(c);
            } else {
                letter.offer(c);
            }
        }
        if (Math.abs(digit.size() - letter.size()) > 1) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        if (letter.size() > digit.size()) {
            ans.append(letter.poll());
        }
        while (!digit.isEmpty() && !letter.isEmpty()) {
            ans.append(digit.poll()).append(letter.poll());
        }
        return digit.isEmpty() ? ans.toString() : ans.append(digit.poll()).toString();
    }
}
