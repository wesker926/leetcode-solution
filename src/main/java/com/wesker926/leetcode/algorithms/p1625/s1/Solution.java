package com.wesker926.leetcode.algorithms.p1625.s1;

/**
 * @author wesker.gh
 * @date 2023/3/19
 * @description 枚举 & 优化
 * 优化点1：枚举轮转位置的循环中，满足 xb - yn = z，其中z为最终位置。根据裴蜀定理可知，z一定为gcd(n, b)的倍数。即只需要枚举gcd倍数即可；
 * 优化点2：由于累加操作分奇偶组，每组独立，而组内累加数相同，因此仅需考虑每组内first字符即可。
 * 注1：需要判断偶数组是否需要累加；
 * 注2：需要先进行轮转后进行累加；
 * 注3：同一个组内，遍历获取最优累加次数时，两个不同的累加次数，不会出现first相同，而后续字符不同的情况，因为字符的累加总数是相同的。
 * 优化点3：无需通过遍历获取first字符的最佳累加值（累加次数），因为可以直接求得：
 * 设ch为字符值，best为理论最佳累加值，ga为gcd(10,a)，则易知best = 10 - ch + (ch % ga)，且best为ga的倍数
 * 证明best必然存在：
 * 设x * ga = a，y * ga = 10，可知x与y互质，根据裴蜀定理推论，xy互质是x * m + y * n = 1的充要条件。
 * 因为x * m + y * n = x * m + y * n + cxy - cxy = x * (m + cy) + y (n - cx) = 1，xy都大于0，因此必然存在m > 0 & n < 0使等式成立。
 * 因此，必然存在x * m * ga * z + y * n * ga * z = ga * z，其中z为任意整数，即a * (m * z) + 10 * (n * z) = ga * z对任意z必然成立。
 * 因为best为ga倍数，因此a * (m * z) + 10 * (n * z) = best必然成立，简化为a * c1 + 10 * c2 = best成立，其中c1 > 0 & c2 < 0。
 * 因为a * c1 + 10 * c2 = best成立等价于(a * c1) % 10 = best成立，因此必然可以通过加若干次a，使得累加值模10后为best。
 */
public class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        int[] best = new int[]{0, 0, 0};
        int g1 = gcd(n, b), g2 = gcd(10, a);
        for (int i = 0; i < n; i += g1) {
            int[] cur = new int[]{(b & 1) == 0 ? 0 : (10 - (s.charAt(i) - '0') / g2 * g2),
                    10 - (s.charAt(addAndMod(i, 1, n)) - '0') / g2 * g2, i};
            for (int j = 0, p1 = best[2], p2 = cur[2]; j < n; j++, p1 = addAndMod(p1, 1, n), p2 = addAndMod(p2, 1, n)) {
                int c1 = addAndMod(s.charAt(p1) - '0', best[j & 1], 10);
                int c2 = addAndMod(s.charAt(p2) - '0', cur[j & 1], 10);
                if (c1 != c2) {
                    best = c1 < c2 ? best : cur;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(addAndMod(s.charAt(addAndMod(i, best[2], n)) - '0', best[i & 1], 10));
        }
        return sb.toString();
    }

    private int addAndMod(int a, int b, int n) {
        int c = a + b;
        return c < n ? c : c - n;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
