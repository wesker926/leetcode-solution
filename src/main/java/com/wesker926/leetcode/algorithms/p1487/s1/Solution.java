package com.wesker926.leetcode.algorithms.p1487.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/3/3
 * @description 哈希表
 */
public class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            int count = map.getOrDefault(names[i], 0);
            if (count == 0) {
                ans[i] = names[i];
                map.put(names[i], 1);
                continue;
            }
            for (; map.containsKey(names[i] + "(" + count + ")"); count++) ;
            ans[i] = names[i] + "(" + count + ")";
            map.put(names[i], count + 1);
            map.put(ans[i], 1);
        }
        return ans;
    }
}
