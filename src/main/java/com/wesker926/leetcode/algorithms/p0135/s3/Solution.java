package com.wesker926.leetcode.algorithms.p0135.s3;

/**
 * @author wesker.gh
 * @date 2022/5/21
 * @description 贪心（常数空间一次遍历）
 * 如果是上升区间则递增，水平区间则重置为1，下降区间则反向递增
 * 注意，如果下降区间递增时发现当前值和之前区间的最后一个值相同，则需要修改这个值
 * 实现上，将当前值加一即可达到相同的效果
 */
public class Solution {
    public int candy(int[] ratings) {
        int sum = 1, up = 1, down = 1, upPre = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                down = 1;
                up = ratings[i] > ratings[i - 1] ? up + 1 : 1;
                sum += up;
                upPre = up;
            } else {
                up = 1;
                if (down == upPre) {
                    down++;
                }
                sum += down;
                down++;
            }
        }
        return sum;
    }
}
