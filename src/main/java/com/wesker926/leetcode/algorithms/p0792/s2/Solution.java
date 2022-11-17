package com.wesker926.leetcode.algorithms.p0792.s2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/11/17
 * @description 多指针
 * 时间复杂度：O(sum(word.length) + n)
 */
public class Solution {
    @SuppressWarnings("all")
    public int numMatchingSubseq(String s, String[] words) {
        Queue<int[]>[] idxs = new LinkedList[26];
        for (int i = 0; i < idxs.length; i++) {
            idxs[i] = new LinkedList<>();
        }
        for (int i = 0; i < words.length; i++) {
            idxs[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
        }

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            for (int j = idxs[ch].size(); j > 0; j--) {
                int[] cur = idxs[ch].poll();
                cur[1]++;
                if (cur[1] == words[cur[0]].length()) {
                    ans++;
                } else {
                    idxs[words[cur[0]].charAt(cur[1]) - 'a'].offer(cur);
                }
            }
        }
        return ans;
    }
}
