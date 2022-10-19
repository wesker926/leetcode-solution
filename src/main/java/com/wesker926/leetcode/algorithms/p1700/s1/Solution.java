package com.wesker926.leetcode.algorithms.p1700.s1;

/**
 * @author wesker.gh
 * @date 2022/10/19
 * @description 模拟
 * 如果当前队列首的三明治类型的数量已经超出了喜欢这种三明治的学生的总量，那就再也取不出了
 */
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int studentOne = 0;
        for (int student : students) {
            studentOne += student;
        }
        int studentZero = students.length - studentOne;
        for (int i = 0, sandwichOne = 0; i < sandwiches.length; i++) {
            sandwichOne += sandwiches[i];
            if (sandwichOne > studentOne || i + 1 - sandwichOne > studentZero) {
                return students.length - i;
            }
        }
        return 0;
    }
}
