package com.wesker926.leetcode.algorithms.p1054.s2;

/**
 * @author wesker.gh
 * @date 2023/5/14
 * @description 哈希 + 计数
 * 只要间隔着填入（索引超出则重置为1），并且先填入出现频率最大的数，就能得到结果。
 * 先填入频率最大的数是为了防止其自身相遇。比如[1,2,2,3]，[1,2,2,3,2]之类的。
 */
public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] table = new int[10001];
        for (int code : barcodes) table[code]++;
        int max = 0, idx = 0;
        for (int i = 0; i < table.length; i++) if (table[i] > table[max]) max = i;
        for (; table[max]-- > 0; idx += 2) barcodes[idx] = max;
        for (int num = 0; num < table.length; num++) {
            for (; table[num]-- > 0; idx += 2) {
                if (idx >= barcodes.length) idx = 1;
                barcodes[idx] = num;
            }
        }
        return barcodes;
    }
}
