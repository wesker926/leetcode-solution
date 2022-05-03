package com.wesker926.leetcode.algorithms.p0068.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/3
 * @description 模拟
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();
        for (int i = 0, j = 0, wordLen = 0; j <= words.length; j++) {
            if (j == words.length || (wordLen + words[j].length() + j - i) > maxWidth) {
                boolean spDelimiter = j == words.length || (j - i) == 1;
                int spaceLen = spDelimiter ? 1 : (maxWidth - wordLen) / (j - i - 1);
                int fillCount = spDelimiter ? 0 : (maxWidth - wordLen) % (j - i - 1);
                StringBuilder sb = new StringBuilder();
                for (; i < j - 1; i++) {
                    sb.append(words[i]).append(" ".repeat(spaceLen)).append(fillCount-- > 0 ? " " : "");
                }
                ans.add(sb.append(words[i++]).append(" ".repeat(maxWidth - sb.length())).toString());
                wordLen = i == words.length ? 0 : words[i].length();
            } else {
                wordLen += words[j].length();
            }
        }
        return ans;
    }
}
