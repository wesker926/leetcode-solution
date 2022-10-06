package com.wesker926.leetcode.algorithms.p0927.s1;

/**
 * @author wesker.gh
 * @date 2022/10/6
 * @description 模拟
 * 每段第一个1可以确定，最后一段的结尾可以确定
 * 然后通过比对确定前导零的位置
 */
public class Solution {
    public int[] threeEqualParts(int[] arr) {
        int one = 0;
        for (int bit : arr) {
            one += bit;
        }
        if (one == 0 || one % 3 != 0) {
            return one == 0 ? new int[]{0, 2} : new int[]{-1, -1};
        }
        int partition = one / 3;
        int[] idxs = new int[3];
        for (int i = 0, c = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (c % partition == 0) {
                    idxs[c == 0 ? 0 : (c == partition ? 1 : 2)] = i;
                }
                c++;
            }
        }
        int len = arr.length - idxs[2];
        if (idxs[0] + len > idxs[1] || idxs[1] + len > idxs[2]) {
            return new int[]{-1, -1};
        }
        for (int i = 0; idxs[2] + i < arr.length; i++) {
            if (arr[idxs[0] + i] != arr[idxs[1] + i] || arr[idxs[1] + i] != arr[idxs[2] + i]) {
                return new int[]{-1, -1};
            }
        }
        return new int[]{idxs[0] + len - 1, idxs[1] + len};
    }
}
