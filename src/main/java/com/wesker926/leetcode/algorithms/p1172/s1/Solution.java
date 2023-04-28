package com.wesker926.leetcode.algorithms.p1172.s1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2023/4/28
 * @description 堆
 * 用堆来维护push和pop的优先plate
 * 更优解法：用一个大数组模拟全部的栈（因为容量固定），额外记录每个栈的栈顶索引和空出位置，参考下文：
 * https://leetcode.cn/problems/dinner-plate-stacks/solutions/2247703/can-pan-zhan-by-leetcode-solution-afsw/
 */
public class Solution {

    private int capacity, seq;

    private final List<int[]> plates;

    private final PriorityQueue<int[]> pushQueue, popQueue;

    public Solution(int capacity) {
        seq = 0;
        this.capacity = capacity;
        plates = new ArrayList<>();
        pushQueue = new PriorityQueue<>((a1, a2) -> {
            int c1 = a1[0] == capacity ? 0 : 1, c2 = a2[0] == capacity ? 0 : 1;
            return c1 != c2 ? c2 - c1 : a1[2] - a2[2];
        });
        popQueue = new PriorityQueue<>((a1, a2) -> {
            int c1 = a1[0] == 0 ? 0 : 1, c2 = a2[0] == 0 ? 0 : 1;
            return c1 != c2 ? c2 - c1 : a2[2] - a1[2];
        });
    }

    public void push(int val) {
        int[] plate = getPlate(pushQueue);
        if (plate == null || plate[capacity] == capacity) {
            plate = new int[capacity + 3];
            plate[capacity + 2] = plates.size();
            plates.add(plate);
        }
        plate[plate[capacity]++] = val;
        plate[capacity + 1] = seq++;
        offerNode(plate);
    }

    public int pop() {
        return platePop(getPlate(popQueue));
    }

    public int popAtStack(int index) {
        return plates.size() <= index ? -1 : platePop(plates.get(index));
    }

    private int[] getPlate(PriorityQueue<int[]> queue) {
        int[] plate = null;
        for (int[] node; !queue.isEmpty(); plate = null) {
            node = queue.poll();
            plate = plates.get(node[2]);
            if (plate[capacity + 1] == node[1]) {
                break;
            }
        }
        return plate;
    }

    private int platePop(int[] plate) {
        if (plate == null || plate[capacity] == 0) {
            return -1;
        }
        int val = plate[--plate[capacity]];
        plate[capacity + 1] = seq++;
        offerNode(plate);
        return val;
    }

    private void offerNode(int[] plate) {
        int[] node = new int[]{plate[capacity], plate[capacity + 1], plate[capacity + 2]};
        pushQueue.offer(node);
        popQueue.offer(node);
    }
}
