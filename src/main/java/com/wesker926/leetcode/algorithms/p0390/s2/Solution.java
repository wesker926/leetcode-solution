package com.wesker926.leetcode.algorithms.p0390.s2;

/**
 * @author wesker.gh
 * @date 2022/1/2
 * @description 更好的递归模拟
 */
public class Solution {
    /**
     * f(x)表示左到右扫，g(x)表示右到左扫：
     * 1. f(1) = g(1) = 1
     * 2. f(x) = g(x/2) * 2
     * 3. f(x) 和 g(x) 是镜像关系，因此 f(x) + g(x) = x + 1
     * 故：f(x) = 2 * g(x/2) = 2 * (x/2 + 1 - f(x/2))
     */
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * ((n >> 1) + 1 - lastRemaining(n >> 1));
    }
}
