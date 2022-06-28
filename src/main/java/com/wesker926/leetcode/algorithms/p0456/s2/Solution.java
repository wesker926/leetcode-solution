package com.wesker926.leetcode.algorithms.p0456.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/6/28
 * @description 正序遍历 + 二分
 * 正序记录记录递增区间，区间按照i和j的值降序排列
 * 寻找符合条件的最左i和最右j，如果idxI<=idxJ则存在
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{nums[0], nums[0]});
        for (int i = 1; i < nums.length; i++) {
            int idxI = binarySearchFirst(list, nums[i]);
            int idxJ = binarySearchLast(list, nums[i]);
            if (0 <= idxI && idxI <= idxJ) {
                return true;
            }
            int lastI = list.get(list.size() - 1)[0];
            if (nums[i] < lastI) {
                list.add(new int[]{nums[i], nums[i]});
            } else {
                while (!list.isEmpty() && nums[i] >= list.get(list.size() - 1)[1]) {
                    list.remove(list.size() - 1);
                }
                list.add(new int[]{lastI, nums[i]});
            }
        }
        return false;
    }

    private int binarySearchFirst(List<int[]> list, int t) {
        int l = 0, r = list.size() - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (list.get(m)[0] >= t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l == list.size() ? -1 : l;
    }

    private int binarySearchLast(List<int[]> list, int t) {
        int l = 0, r = list.size() - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (list.get(m)[1] > t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
