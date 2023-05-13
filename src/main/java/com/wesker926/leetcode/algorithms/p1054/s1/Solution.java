package com.wesker926.leetcode.algorithms.p1054.s1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/5/14
 * @description 哈希 + 堆
 * 常规思路，非最优。
 */
public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] table = new int[10001];
        for (int code : barcodes) table[code]++;
        Queue<Integer> queue = new PriorityQueue<>((i, j) -> table[j] - table[i]);
        for (int i = 0; i < table.length; i++) if (table[i] != 0) queue.offer(i);
        for (int idx = 0; queue.size() > 1; ) {
            int i = queue.poll(), j = queue.poll(), k = queue.isEmpty() ? 0 : table[queue.peek()] - 1;
            for (; table[j] > k; table[i]--, table[j]--) {
                barcodes[idx++] = i;
                barcodes[idx++] = j;
            }
            if (table[i] != 0) queue.offer(i);
            if (table[j] != 0) queue.offer(j);
        }
        if (!queue.isEmpty()) barcodes[barcodes.length - 1] = queue.poll();
        return barcodes;
    }
}
