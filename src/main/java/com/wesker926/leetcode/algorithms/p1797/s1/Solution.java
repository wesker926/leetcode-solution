package com.wesker926.leetcode.algorithms.p1797.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/2/9
 * @description 哈希表 + 双向链表（队列）
 * 时间必然是递增的所以不需要堆
 * 过期的节点以及刷新后无效的老节点都可以延迟删除
 */
public class Solution {

    private final int timeToLive;

    private final Map<String, Integer> tokens;

    private final Queue<Node> queue;

    public Solution(int timeToLive) {
        this.timeToLive = timeToLive;
        tokens = new HashMap<>();
        queue = new LinkedList<>();
    }

    public void generate(String tokenId, int currentTime) {
        clear(currentTime);
        tokens.put(tokenId, currentTime + timeToLive);
        queue.offer(new Node(tokenId, currentTime + timeToLive));
    }

    public void renew(String tokenId, int currentTime) {
        clear(currentTime);
        if (!tokens.containsKey(tokenId)) {
            return;
        }
        tokens.put(tokenId, currentTime + timeToLive);
        queue.offer(new Node(tokenId, currentTime + timeToLive));
    }

    public int countUnexpiredTokens(int currentTime) {
        clear(currentTime);
        return tokens.size();
    }

    private void clear(int curTime) {
        while (!queue.isEmpty() && queue.peek().time <= curTime) {
            Node node = queue.poll();
            if (tokens.getOrDefault(node.token, -1) == node.time) {
                tokens.remove(node.token);
            }
        }
    }

    private static class Node {

        String token;

        int time;

        Node(String token, int time) {
            this.token = token;
            this.time = time;
        }
    }
}
