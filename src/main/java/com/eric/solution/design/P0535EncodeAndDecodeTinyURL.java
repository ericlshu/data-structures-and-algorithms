package com.eric.solution.design;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>Copyright (c) 2024 Authors. All rights reserved.
 *
 * <p>Project: data-structures-and-algorithms
 * <p>Created By : Eric L SHU
 * <p>Created On : 2024-03-12 16:41:44
 * <p>
 * Description : TinyURL 的加密与解密
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL <a href="https://leetcode.com/problems/design-tinyurl">...</a> 时，它将返回一个简化的URL <a href="http://tinyurl.com/4e9iAk">...</a> 。请你设计一个类来加密与解密 TinyURL 。
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 * <p>
 * 实现 Solution 类：
 * Solution() 初始化 TinyURL 系统对象。
 * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
 * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 * <p>
 * 示例：
 * 输入：url = "https://leetcode.com/problems/design-tinyurl"
 * 输出："<a href="https://leetcode.com/problems/design-tinyurl">...</a>"
 * 解释：
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
 * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
 * <p>
 * 提示：
 * 1 <= url.length <= 104
 * 题目数据保证 url 是一个有效的 URL
 *
 * @version 1.0
 * @since jdk-17
 */
public class P0535EncodeAndDecodeTinyURL
{
    public static class Codec
    {
        private final Map<String, String> long2Short = new HashMap<>();
        private final Map<String, String> short2Long = new HashMap<>();

        private static final String SHORT_PREFIX = "http://tinyurl.com/";
        private static int id = 1;

        private static final char[] toBase62 = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };

        private String toBase62(int number)
        {
            if (number == 0)
                return String.valueOf(toBase62[0]);
            StringBuilder sb = new StringBuilder();
            while (number > 0)
            {
                sb.append(toBase62[number % 62]);
                number /= 62;
            }
            return sb.reverse().toString();
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl)
        {
            String shortUrl = long2Short.get(longUrl);
            if (shortUrl != null)
                return shortUrl;
            shortUrl = getShortUrlByRandom(longUrl);
            long2Short.put(longUrl,shortUrl);
            shortUrl = getShortUrlByHash(longUrl);
            long2Short.put(longUrl,shortUrl);
            shortUrl = getShortUrlBySequence(longUrl);
            long2Short.put(longUrl,shortUrl);
            return shortUrl;
        }

        private String getShortUrlBySequence(String longUrl)
        {
            String shortUrl = SHORT_PREFIX + id;
            long2Short.put(longUrl, shortUrl);
            short2Long.put(shortUrl, longUrl);
            id++;
            return shortUrl;
        }

        private String getShortUrlByHash(String longUrl)
        {
            String shortUrl;
            while (true)
            {
                int id = longUrl.hashCode();
                shortUrl = SHORT_PREFIX + id;
                if (!short2Long.containsKey(shortUrl))
                {
                    long2Short.put(longUrl, shortUrl);
                    short2Long.put(shortUrl, longUrl);
                    break;
                }
            }
            return shortUrl;
        }

        private String getShortUrlByRandom(String longUrl)
        {
            String shortUrl;
            while (true)
            {
                int id = ThreadLocalRandom.current().nextInt();
                // System.out.println("id = " + id);
                shortUrl = SHORT_PREFIX + this.toBase62(id);
                if (!short2Long.containsKey(shortUrl))
                {
                    long2Short.put(longUrl, shortUrl);
                    short2Long.put(shortUrl, longUrl);
                    break;
                }
            }
            return shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl)
        {
            return short2Long.get(shortUrl);
        }
    }
}
