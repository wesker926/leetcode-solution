package com.wesker926.leetcode.algorithms.p0535.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/6/29
 * @description 哈希表
 */
public class Solution {

    private static final String SHORT_DOMAIN = "http://tinyurl.com/";

    private static final char[] ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private final Map<String, String> table = new HashMap<>();

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String code;
        for (; ; ) {
            code = getNewCode();
            if (!table.containsKey(code)) {
                break;
            }
        }
        table.put(code, longUrl);
        return SHORT_DOMAIN + code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.substring(SHORT_DOMAIN.length());
        return table.get(code);
    }

    private String getNewCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(ALPHABET[(int) (Math.random() * 62)]);
        }
        return sb.toString();
    }
}
