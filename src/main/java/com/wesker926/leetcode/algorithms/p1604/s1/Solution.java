package com.wesker926.leetcode.algorithms.p1604.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/2/7
 * @description 哈希表 + 排序
 * 牛马题
 */
public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            map.computeIfAbsent(keyName[i], k -> new ArrayList<>()).add(format(keyTime[i]));
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            for (int i = 0, j = 2; j < times.size(); i++, j++) {
                if (times.get(j) - times.get(i) <= 60) {
                    ans.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    private int format(String time) {
        return time.charAt(0) * 600 + time.charAt(1) * 60 + time.charAt(3) * 10 + time.charAt(4) - '0' * 671;
    }
}
