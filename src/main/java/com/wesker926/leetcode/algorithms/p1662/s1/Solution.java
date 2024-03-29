package com.wesker926.leetcode.algorithms.p1662.s1;

/**
 * @author wesker.gh
 * @date 2022/11/1
 * @description 遍历
 * 直接构造新的更省事也更快
 */
public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (String word : word1) {
            sb1.append(word);
        }
        for (String word : word2) {
            sb2.append(word);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
