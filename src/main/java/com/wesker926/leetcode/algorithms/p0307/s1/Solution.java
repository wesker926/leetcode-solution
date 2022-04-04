package com.wesker926.leetcode.algorithms.p0307.s1;

/**
 * @author wesker.gh
 * @date 2022/4/4
 * @description 树状数组
 */
public class Solution {

    private int n;

    private int[] nums;

    private int[] tree;

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */
    public Solution(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    private void add(int i, int v) {
        for (int idx = i; idx <= n; idx += lowBit(idx)) {
            tree[idx] += v;
        }
    }

    private int query(int i) {
        int ans = 0;
        for (int idx = i; idx > 0; idx -= lowBit(idx)) {
            ans += tree[idx];
        }
        return ans;
    }

    private int lowBit(int i) {
        return i & -i;
    }
}
