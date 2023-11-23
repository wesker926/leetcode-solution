package com.wesker926.leetcode.algorithms.p1410.s1;

/**
 * @author wesker.gh
 * @date 2023/11/23
 * @description 模拟
 * 牛马模拟题
 */
public class Solution {

    private static final char[][] REPLACE = new char[][]{
            "\"&quot;".toCharArray(), "'&apos;".toCharArray(),
            "&&amp;".toCharArray(), ">&gt;".toCharArray(),
            "<&lt;".toCharArray(), "/&frasl;".toCharArray()
    };

    public String entityParser(String text) {
        char[] cs = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j, k, n = cs.length; i < n; ) {
            if (cs[i] != '&') {
                sb.append(cs[i++]);
                continue;
            }

            char[] target = null;
            for (char[] sp : REPLACE) {
                for (j = i, k = 1; k < sp.length && j < n && sp[k] == cs[j]; k++, j++) ;
                if (k == sp.length) {
                    target = sp;
                    break;
                }
            }

            sb.append(target == null ? cs[i] : target[0]);
            i += target == null ? 1 : target.length - 1;
        }
        return sb.toString();
    }
}
