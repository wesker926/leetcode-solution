package com.wesker926.leetcode.algorithms.p1460.s1;

/**
 * @author wesker.gh
 * @date 2022/8/24
 * @description 哈希表计数
 */
public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] bucket = new int[1001];
        for (int i = 0; i < target.length; i++) {
            bucket[target[i]]++;
            bucket[arr[i]]--;
        }
        for (int i : bucket) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
