package com.wesker926.leetcode.algorithms.p0929.s1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2022/6/4
 * @description 遍历
 */
public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<>();
        StringBuilder sb;
        boolean hasPlus;
        for (String email : emails) {
            sb = new StringBuilder();
            hasPlus = false;
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (ch == '@') {
                    sb.append(email, i, email.length());
                    break;
                } else if (ch == '.') {
                    continue;
                } else if (!hasPlus && ch == '+') {
                    hasPlus = true;
                }
                if (!hasPlus) {
                    sb.append(ch);
                }
            }
            ans.add(sb.toString());
        }
        return ans.size();
    }
}
