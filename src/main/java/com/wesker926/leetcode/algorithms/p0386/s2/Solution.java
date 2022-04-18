package com.wesker926.leetcode.algorithms.p0386.s2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description 迭代DFS O(n) / O(1)
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new LinkedList<>();
        int num = 1;
        for (int count = 0; count < n; count++) {
            ans.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return ans;
    }
}
