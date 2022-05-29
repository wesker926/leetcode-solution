package com.wesker926.leetcode.algorithms.p0468.s1;

/**
 * @author wesker.gh
 * @date 2022/5/29
 * @description 遍历检查
 */
public class Solution {

    private static final String V4 = "IPv4";

    private static final String V6 = "IPv6";

    private static final String NE = "Neither";

    public String validIPAddress(String queryIP) {
        for (int i = 0; i < 5 && i < queryIP.length(); i++) {
            if (queryIP.charAt(i) == '.') {
                return validIPV4(queryIP);
            } else if (queryIP.charAt(i) == ':') {
                return validIPV6(queryIP);
            }
        }
        return NE;
    }

    private String validIPV4(String ip) {
        String[] sp = ip.split("\\.", -1);
        if (sp.length != 4) {
            return NE;
        }
        for (String s : sp) {
            if (s.length() < 1 || s.length() > 3 || (s.length() != 1 && s.charAt(0) == '0')) {
                return NE;
            }
            int digit = 0;
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return NE;
                }
                digit = digit * 10 + c - '0';
                if (digit > 255) {
                    return NE;
                }
            }
        }
        return V4;
    }

    private String validIPV6(String ip) {
        String[] sp = ip.split(":", -1);
        if (sp.length != 8) {
            return NE;
        }
        for (String s : sp) {
            if (s.length() < 1 || s.length() > 4) {
                return NE;
            }
            for (char c : s.toCharArray()) {
                char lc = Character.toLowerCase(c);
                if (!Character.isDigit(lc) && (lc < 'a' || lc > 'f')) {
                    return NE;
                }
            }
        }
        return V6;
    }
}
