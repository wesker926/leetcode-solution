package com.wesker926.leetcode.algorithms.p1803.s1;

/**
 * @author wesker.gh
 * @date 2023/1/5
 * @description 字典树
 * 关键转换，介于low和high的对数 = 不大于high的对数 - 不大于low-1的对数
 * ans = stat(high) - stat(low - 1)
 * 为求nums[i] ^ nums[j] <= x，可以设计二进制从高位到低位的比较方法，使用字典树来统一比较，避免嵌套遍历
 * 即对于curNum，我们根据字典树的bit分支来统计符合要求的其他数字个数（应先统计curNum后入树）
 * 时间复杂度O(nlogC)，n为遍历数组长度，C为数字范围，本题中C不超过2^15，因此可用15bit表示
 */
public class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int ans = 0;
        Trie trie = new Trie();
        for (int num : nums) {
            ans += trie.stat(high, num) - trie.stat(low - 1, num);
            trie.add(num);
        }
        return ans;
    }

    private static class Trie {

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void add(int num) {
            TrieNode cur = root;
            cur.count++;
            for (int i = 14; i >= 0; i--) {
                int val = (num >> i) & 1;
                if (cur.children[val] == null) {
                    cur.children[val] = new TrieNode();
                }
                cur = cur.children[val];
                cur.count++;
            }
        }

        int stat(int max, int num) {
            int count = 0;
            TrieNode cur = root;
            for (int i = 14; i >= 0 && cur != null; i--) {
                int val = (num >> i) & 1;
                if (((max >> i) & 1) == 0) {
                    cur = cur.children[val];
                } else {
                    count += cur.children[val] == null ? 0 : cur.children[val].count;
                    cur = cur.children[1 - val];
                }
            }
            return count + (cur == null ? 0 : cur.count);
        }
    }

    private static class TrieNode {

        int count;

        TrieNode[] children;

        TrieNode() {
            count = 0;
            children = new TrieNode[2];
        }
    }
}
