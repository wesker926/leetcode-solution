package com.wesker926.leetcode.algorithms.p2299.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2023/1/19
 * @description 模拟
 */
public class Solution {

    private static final Set<Character> SPECIAL;

    static {
        SPECIAL = new HashSet<>();
        for (char ch : "!@#$%^&*()-+".toCharArray()) {
            SPECIAL.add(ch);
        }
    }

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (i != 0 && ch == password.charAt(i - 1)) {
                return false;
            }
            if (Character.isDigit(ch)) {
                checker |= 1;
            } else if (Character.isUpperCase(ch)) {
                checker |= 1 << 1;
            } else if (Character.isLowerCase(ch)) {
                checker |= 1 << 2;
            } else if (SPECIAL.contains(ch)) {
                checker |= 1 << 3;
            }
        }
        return checker == 15;
    }
}
