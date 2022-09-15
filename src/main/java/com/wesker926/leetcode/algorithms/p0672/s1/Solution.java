package com.wesker926.leetcode.algorithms.p0672.s1;

/**
 * @author wesker.gh
 * @date 2022/9/15
 * @description 找规律
 * 状态周期为6，只需要观察前6个；
 * 有2个重复，只需要观察其中4个；
 * 有个可以根据其他3个推导出，只需要观察3个；
 * 然后分情况讨论。
 */
public class Solution {
    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return presses == 1 ? 3 : 4;
        } else {
            return presses == 1 ? 4 : (presses == 2 ? 7 : 8);
        }
    }
}
