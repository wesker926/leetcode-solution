package com.wesker926.leetcode.algorithms.p0372.extention;

/**
 * @author wesker.gh
 * @date 2021/12/5
 * @description 欧拉函数
 * phi(n) = n * (1 - 1/p1) * (1 - 1/p2) ...
 * pi为n的质因子
 */
public class Euler {

    public static int getPhi(int n) {
        int ans = n;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                ans -= ans / i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getPhi(1337)); // 1140
    }
}
