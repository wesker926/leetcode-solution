package com.wesker926.leetcode.algorithms.p0895.s1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/11/30
 * @description 哈希表 + 栈
 * 注意题目没要求把频数最高的元素真正删掉，而是减少一次频数
 * 比如val=5出现了5次为最高，删除后val=5变为出现4次
 */
public class Solution {

    private int maxFreq;

    private final Map<Integer, Integer> freqMap;

    private final Map<Integer, LinkedList<Integer>> stackMap;

    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(val);
     * int param_2 = obj.pop();
     */
    public Solution() {
        maxFreq = 0;
        freqMap = new HashMap<>();
        stackMap = new HashMap<>();
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        stackMap.computeIfAbsent(freq, key -> new LinkedList<>()).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        int val = stackMap.get(maxFreq).pop();
        freqMap.put(val, freqMap.get(val) - 1);
        if (stackMap.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return val;
    }
}
