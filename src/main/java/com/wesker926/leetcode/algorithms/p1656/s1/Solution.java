package com.wesker926.leetcode.algorithms.p1656.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/8/16
 * @description 数组存储
 */
public class Solution {

    private int ptr;

    private final String[] bucket;

    /**
     * Your OrderedStream object will be instantiated and called as such:
     * OrderedStream obj = new OrderedStream(n);
     * List<String> param_1 = obj.insert(idKey,value);
     */
    public Solution(int n) {
        bucket = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        bucket[idKey] = value;
        List<String> ans = new ArrayList<>();
        for (; ptr < bucket.length && bucket[ptr] != null; ptr++) {
            ans.add(bucket[ptr]);
        }
        return ans;
    }
}
