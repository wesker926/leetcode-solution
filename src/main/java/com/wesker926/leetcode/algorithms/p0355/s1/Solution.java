package com.wesker926.leetcode.algorithms.p0355.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/6/16
 * @description 读扩散
 * 实时生成时间线
 * 列表合并也可用大顶堆
 */
public class Solution {

    private int idx = 0;

    private final Map<Integer, List<int[]>> tweets;

    private final Map<Integer, Set<Integer>> follows;

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */
    public Solution() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, key -> new LinkedList<>()).add(new int[]{tweetId, idx++});
    }

    @SuppressWarnings("all")
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followList = new ArrayList<>(follows.getOrDefault(userId, Collections.EMPTY_SET));
        followList.add(userId);
        List<int[]> cur = new ArrayList<>(), pre;
        for (int id : followList) {
            pre = cur;
            cur = new ArrayList<>();
            List<int[]> ts = tweets.getOrDefault(id, Collections.emptyList());
            for (int i = 0, j = ts.size() - 1, c = 0; c < 10 && (i < pre.size() || j >= 0); c++) {
                int[] e1 = i < pre.size() ? pre.get(i) : null, e2 = j >= 0 ? ts.get(j) : null;
                if (e2 == null || (e1 != null && e1[1] > e2[1])) {
                    cur.add(e1);
                    i++;
                } else {
                    cur.add(e2);
                    j--;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] e : cur) {
            ans.add(e[0]);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
    }

    @SuppressWarnings("all")
    public void unfollow(int followerId, int followeeId) {
        follows.getOrDefault(followerId, Collections.EMPTY_SET).remove(followeeId);
    }
}
