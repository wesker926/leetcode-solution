package com.wesker926.leetcode.algorithms.p0699.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/5/26
 * @description 有序集合
 * 很难，背一下
 */
public class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>(n);
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 0);
        for (int i = 0; i < n; i++) {
            int size = positions[i][1];
            int left = positions[i][0], right = left + size - 1;
            Integer lp = heightMap.higherKey(left), rp = heightMap.higherKey(right);
            Integer preRp = rp != null ? heightMap.lowerKey(rp) : heightMap.lastKey();
            Integer preRh = preRp != null ? heightMap.get(preRp) : 0;

            int height = 0;
            Integer preLp = lp != null ? heightMap.lowerKey(lp) : heightMap.lastKey();
            Map<Integer, Integer> tailMap = heightMap.tailMap(preLp);
            for (Map.Entry<Integer, Integer> entry : tailMap.entrySet()) {
                if (rp != null && rp.equals(entry.getKey())) {
                    break;
                }
                height = Math.max(height, entry.getValue() + size);
            }

            Set<Integer> keySet = new TreeSet<>(tailMap.keySet());
            for (Integer key : keySet) {
                if (lp == null || key < lp) {
                    continue;
                }
                if (rp != null && key >= rp) {
                    break;
                }
                heightMap.remove(key);
            }
            heightMap.put(left, height);
            if (rp == null || rp != right + 1) {
                heightMap.put(right + 1, preRh);
            }
            ans.add(i > 0 ? Math.max(ans.get(i - 1), height) : height);
        }
        return ans;
    }
}
