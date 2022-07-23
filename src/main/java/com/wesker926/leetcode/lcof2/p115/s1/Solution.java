package com.wesker926.leetcode.lcof2.p115.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/7/23
 * @description 拓扑排序（构造有向图）
 * 1-n的所有节点都必须在图中，且图只可为一条有向边（不能存在分叉）
 * 因此找入度为0的点依次构造即可（过程中不可存在多个入度为0的点）
 * 因为不存在分叉，所以可省略queue，用int表示
 * 同主站-p0444
 */
public class Solution {
    @SuppressWarnings("all")
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] inDegree = new int[n];
        List<Integer>[] outDegree = new List[n];
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                if (outDegree[sequence[i] - 1] == null) {
                    outDegree[sequence[i] - 1] = new LinkedList<>();
                }
                outDegree[sequence[i] - 1].add(sequence[i + 1] - 1);
                inDegree[sequence[i + 1] - 1]++;
            }
        }

        int cur = -1, nxt = -1;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                if (cur == -1) {
                    cur = i;
                } else {
                    return false;
                }
            }
        }

        for (; cur >= 0; cur = nxt, nxt = -1) {
            if (outDegree[cur] == null) {
                continue;
            }
            for (int candidate : outDegree[cur]) {
                if (--inDegree[candidate] == 0) {
                    if (nxt == -1) {
                        nxt = candidate;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
