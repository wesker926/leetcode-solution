package com.wesker926.leetcode.algorithms.p2591.s1;

/**
 * @author wesker.gh
 * @date 2023/9/22
 * @description 贪心
 * 这题比较恶心，细节很多，容易WA
 * 其实可以换种思路，先给每个小孩1元打底，再进行分配，尽可能多的分7元，不允许出现3元（因为至少两个小孩，所以可以往前借）
 * 这样算的速度更快
 */
public class Solution {
    public int distMoney(int money, int children) {
        if (money < children) return -1;
        int ans = 0;
        for (; children > 0 && money - 8 >= children - 1; money -= 8, ans++, children--) ;
        if ((children == 0 && money != 0) || (children == 1 && money == 4)) ans--;
        return ans;
    }
}
