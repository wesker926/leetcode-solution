package com.wesker926.leetcode.algorithms.p0341.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/6/16
 * @description DFS预存储
 * 可用栈直接保存节点，但需要在hasNext时判断
 */
public class Solution {
    public static class NestedIterator implements Iterator<Integer> {

        private final Queue<Integer> queue = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger e : nestedList) {
                offer(e);
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        private void offer(NestedInteger e) {
            if (e.isInteger()) {
                queue.offer(e.getInteger());
            }
            for (NestedInteger ne : e.getList()) {
                offer(ne);
            }
        }
    }

    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
