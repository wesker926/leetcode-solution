package com.wesker926.leetcode.algorithms.p1108.s1;

/**
 * @author wesker.gh
 * @date 2022/6/21
 * @description 遍历替换
 */
public class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            sb.append(c != '.' ? c : "[.]");
        }
        return sb.toString();
    }
}
