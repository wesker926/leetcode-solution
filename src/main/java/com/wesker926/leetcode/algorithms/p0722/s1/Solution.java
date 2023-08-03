package com.wesker926.leetcode.algorithms.p0722.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/8/3
 * @description 痛苦模拟
 * 可以用正则，正则更简单些
 */
public class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean block = false;
        StringBuilder sb = new StringBuilder();
        for (String line : source) {
            for (int i = 0; i < line.length(); ) {
                if (block) {
                    int end = line.indexOf("*/", i);
                    i = end == -1 ? line.length() : end + 2;
                    block = end == -1;
                    continue;
                }
                int j = i, t = 0;
                for (; j < line.length() - 1; j++) {
                    char cur = line.charAt(j), nxt = line.charAt(j + 1);
                    if (cur == '/' && (nxt == '/' || nxt == '*')) {
                        t = nxt == '/' ? 1 : 2;
                        break;
                    }
                }
                if (t == 0) j++;
                sb.append(line, i, j);
                if (t == 2) block = true;
                i = t < 2 ? line.length() : j + 2;
            }
            if (sb.length() != 0 && !block) {
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return ans;
    }
}
