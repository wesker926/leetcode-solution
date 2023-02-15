package com.wesker926.leetcode.algorithms.p1250.s1;

/**
 * @author wesker.gh
 * @date 2023/2/15
 * @description 数学
 * 裴蜀定理：对于a, b, c = gcd(a, b), a * x + b * y 一定是c的倍数，且a * x + b * y = c一定存在。
 * 推论：a, b互质的充要条件是a * x + b * y = 1。
 * 其中a, b为整数，c为它们的最大公约数，x, y为任意整数。
 * 必要性易证；
 * 充分性：证明a * x + b * y = 1等价于证明(a * x) % b = 1。
 * 假设 1a, 2a, ..., (b - 1)a, ba 一组数，它们mod b的结果必然是互不相同的，因此必然包括1。
 * 反证法：假设 (k1 * a) % b = (k2 * a) % b，则((k1 - k2) * a) % b = 0。
 * 因ab互质，所以(k1 - k2)需要为b的倍数，但(k1 - k2)取值范围为[1 - b, b - 1]，故矛盾
 * 故得证充分性。
 */
public class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for (int num : nums) {
            gcd = gcd(gcd, num);
            if (gcd == 1) {
                return true;
            }
        }
        return false;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
