package com.wesker926.leetcode.algorithms.p0609.s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/9/29
 * @description 哈希表
 */
public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            int firstBlank = path.indexOf(' ');
            String dir = path.substring(0, firstBlank);
            for (int l = firstBlank + 1, r = l; r <= path.length(); r++) {
                if (r == path.length() || path.charAt(r) == ' ') {
                    int lp = path.indexOf('(', l);
                    String fileName = path.substring(l, lp);
                    String fileContent = path.substring(lp + 1, r - 1);
                    List<String> repeat = map.computeIfAbsent(fileContent, key -> new ArrayList<>());
                    repeat.add(dir + "/" + fileName);
                    l = r + 1;
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                ans.add(list);
            }
        }
        return ans;
    }
}
