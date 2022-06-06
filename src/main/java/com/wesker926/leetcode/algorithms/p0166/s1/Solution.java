package com.wesker926.leetcode.algorithms.p0166.s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/6/6
 * @description 长除法
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        boolean isNegative = (numerator > 0) ^ (denominator > 0);
        long a = Math.abs((long) numerator), b = Math.abs((long) denominator);
        long div = a / b, mod = a % b;
        StringBuilder sb = new StringBuilder().append(isNegative ? "-" : "").append(div);
        if (mod == 0) {
            return sb.toString();
        }
        sb.append(".");

        List<String> result = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        for (a = mod * 10; a != 0 && !map.containsKey(a); ) {
            result.add(String.valueOf(a / b));
            map.put(a, result.size() - 1);
            a = (a % b) * 10;
        }

        if (a != 0) {
            result.add(map.get(a), "(");
            result.add(")");
        }
        return sb.append(String.join("", result)).toString();
    }
}
