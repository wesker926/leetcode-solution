package com.wesker926.leetcode.algorithms.p1163.s1;

/**
 * @author wesker.gh
 * @date 2023/4/24
 * @description 双指针
 * 如果一个子串从位置 i 开始，那么字典序最大的子串一定是 s[i,..n−1]，即从位置 i 开始的最长后缀。因此，只需要找出字典序最大的后缀子串即可。
 * 因此问题也可以转换为后缀数组问题。
 * <p>
 * 使用双指针 i 和 j，其中指针 i 指向当前字典序最大的子串的起始位置，指针 j 指向当前考虑的子串的起始位置。
 * 另外，用一个变量 k 记录当前比较到的位置。初始时 i=0, j=1, k=0。
 * <p>
 * 每一次，比较 s[i+k] 和 s[j+k]：
 * 如果 s[i+k]=s[j+k]，说明 s[i,..i+k] 和 s[j,..j+k] 相同，将 k 加 1，继续比较 s[i+k] 和 s[j+k]；
 * <p>
 * 如果 s[i+k]<s[j+k]，说明 s[j,..j+k] 的字典序更大。此时更新 i=i+k+1，并将 k 重置为 0。
 * 如果此时 i≥j，那么将指针 j 更新为 i+1，即 j=i+1。
 * 这里跳过了以 s[i,..,i+k] 为起始位置的所有后缀子串，因为它们的字典序一定小于对应的 s[j,..,j+k] 为起始位置的后缀子串。
 * <p>
 * 如果 s[i+k]>s[j+k]，说明 s[i,..,i+k] 的字典序更大。此时更新 j=j+k+1，并将 k 重置为 0。
 * 这里跳过了以 s[j,..,j+k] 为起始位置的所有后缀子串，因为它们的字典序一定小于对应的 s[i,..,i+k] 为起始位置的后缀子串。
 * <p>
 * 最后返回以 i 为起始位置的后缀子串即可，即 s[i,..,n−1]。
 */
public class Solution {
    public String lastSubstring(String s) {
        int i = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int j = 1, k; j < n; ) {
            for (k = 0; j + k < n && cs[i + k] == cs[j + k]; k++) ;
            if (j + k < n && cs[i + k] < cs[j + k]) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return new String(cs, i, n - i);
    }
}
