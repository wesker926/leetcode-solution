package com.wesker926.leetcode.algorithms.p1096.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/3/7
 * @description 栈
 * 这题递归写法比较麻烦，栈相对简单
 * 注意List.of不能排序，UnsupportedOperationException警告
 */
@SuppressWarnings("all")
public class Solution {
    public List<String> braceExpansionII(String expression) {
        LinkedList<Object> stack = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isLetter(ch)) {
                int j = i + 1;
                for (; j < expression.length() && Character.isLetter(expression.charAt(j)); j++) ;
                stack.push(new ArrayList<>(List.of(expression.substring(i, j))));
                cross(stack);
                i = j - 1;
            } else if (ch == '}') {
                union(stack);
                cross(stack);
            } else {
                stack.push(ch);
            }
        }
        List<String> ans = (List<String>) stack.pop();
        System.out.println(ans);
        Collections.sort(ans);
        return ans;
    }

    private void cross(LinkedList<Object> stack) {
        List<String> merge = (List<String>) stack.pop();
        while (!stack.isEmpty() && stack.peekFirst() instanceof List) {
            List<String> temp = new ArrayList<>();
            for (String s1 : (List<String>) stack.pop()) {
                for (String s2 : merge) {
                    temp.add(s1 + s2);
                }
            }
            merge = temp;
        }
        stack.push(merge);
    }

    private void union(LinkedList<Object> stack) {
        Set<String> merge = new HashSet<>((List<String>) stack.pop());
        while (!stack.isEmpty()) {
            Object cur = stack.pop();
            if (cur instanceof List) {
                merge.addAll((List<String>) cur);
            } else if ((char) cur == '{') {
                break;
            }
        }
        stack.push(new ArrayList<>(merge));
    }
}
