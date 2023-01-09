package com.wesker926.leetcode.algorithms.p1806.s1;

/**
 * @author wesker.gh
 * @date 2023/1/9
 * @description 数学
 * 对于第i个元素，如果i < n / 2，则转换后的新坐标为i * 2;否则为i * 2 - (n - 1)；
 * 不考虑n为2的情况，即为i -> (i * 2) % (n - 1)
 * 所以问题转换为找到使 i * 2 ^ k == i (mod(n - 1)) 的最小操作数k
 * 因为若2 ^ k == 1 (mod(n - 1))成立，则两端乘i后所有元素皆成立，则问题转化为找元素i = 1的k
 * 因为n为偶数，因此2 ^ k与n - 1互质，根据欧拉定理，2 ^ f(n - 1) == 1 (mod(n - 1))，其中f为欧拉函数
 * f(n - 1)一定是一个解，而f(n - 1) <= n - 1，则k <= n - 1
 * 即找到k的时间复杂度为O(n)
 */
public class Solution {
    public int reinitializePermutation(int n) {
        if (n == 2) {
            return 1;
        }
        int ans = 0, i = 1;
        do {
            i = (i * 2) % (n - 1);
            ans++;
        } while (i != 1);
        return ans;

//        int ans = 0, half = n / 2, i = 1;
//        do {
//            i = i < half ? i * 2 : i * 2 - n + 1;
//            ans++;
//        } while (i != 1);
//        return ans;
    }
}
