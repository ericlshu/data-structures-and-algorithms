package com.eric.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : Fizz Buzz
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * <p>
 * 示例 3：
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * <p>
 * 提示：
 * 1 <= n <= 104
 *
 * @author Eric L SHU
 * @date 2022-10-10 12:37
 * @since jdk-11.0.14
 */
public class P0412FizzBuzz
{
    public List<String> fizzBuzz_1(int n)
    {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            if (i % 15 == 0)
            {
                list.add("FizzBuzz");
            }
            else if (i % 3 == 0)
            {
                list.add("Fizz");
            }
            else if (i % 5 == 0)
            {
                list.add("Buzz");
            }
            else
            {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public List<String> fizzBuzz_2(int n)
    {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0)
                sb.append("Fizz");
            if (i % 5 == 0)
                sb.append("Buzz");
            if (sb.length() == 0)
                sb.append(i);
            answer.add(sb.toString());
        }
        return answer;
    }
}
