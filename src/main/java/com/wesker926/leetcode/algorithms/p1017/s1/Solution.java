package com.wesker926.leetcode.algorithms.p1017.s1;

/**
 * @author wesker.gh
 * @date 2023/4/6
 * @description 模拟
 * 遇到奇数位的1时，其负二进制的表示需要从高一位借1来减去本位的1
 * 因此遇到奇数位的1就在高一位上加1即可
 * <p>
 * 也可以用进制转换的思路去做
 * 十进制转负二进制，取余除-2
 */
public class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        for (boolean odd = false; n != 0; odd = !odd, n >>= 1) {
            n += odd && (n & 1) == 1 ? 2 : 0;
            sb.append(n & 1);
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
