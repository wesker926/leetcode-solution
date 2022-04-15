package com.wesker926.leetcode.algorithms.p0385.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/15
 * @description 递归解析
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        return parse(s.toCharArray(), 0, s.length() - 1);
    }

    private NestedInteger parse(char[] cs, int s, int e) {
        if (cs[s] != '[') {
            return new NestedInteger(Integer.parseInt(new String(cs, s, e - s + 1)));
        }

        NestedInteger cur = new NestedInteger();
        if (s + 1 == e) {
            return cur;
        }
        for (int i = s + 1, j = s + 1, k = 0; j <= e; j++) {
            if (j == e || (cs[j] == ',' && k == 0)) {
                cur.add(parse(cs, i, j - 1));
                i = j + 1;
            } else if (cs[j] == '[') {
                k++;
            } else if (cs[j] == ']') {
                k--;
            }
        }
        return cur;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    private static class NestedInteger {

        private Integer number;

        private final List<NestedInteger> nested;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            this.number = null;
            this.nested = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.number = value;
            this.nested = new ArrayList<>();
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return this.number != null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return this.number;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.number = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            this.nested.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return this.nested;
        }
    }
}