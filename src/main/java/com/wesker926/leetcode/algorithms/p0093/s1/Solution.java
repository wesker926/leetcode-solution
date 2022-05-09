package com.wesker926.leetcode.algorithms.p0093.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description 回溯
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return dfs(new LinkedList<>(), new StringBuilder(), s.toCharArray(), 0, 0);
    }

    private List<String> dfs(List<String> ans, StringBuilder sb, char[] cs, int idx, int count) {
        if (count == 4 || idx == cs.length) {
            if (count == 4 && idx == cs.length) {
                ans.add(sb.deleteCharAt(sb.length() - 1).toString());
            }
            return ans;
        }

        int len = sb.length();
        for (int i = idx, num = 0; i < Math.min(cs.length, idx + 3); i++) {
            num = num * 10 + (cs[i] - '0');
            if (num > 255) {
                break;
            }
            dfs(ans, sb.append(num).append('.'), cs, i + 1, count + 1);
            sb.setLength(len);
            if (num == 0) {
                break;
            }
        }
        return ans;
    }
}
