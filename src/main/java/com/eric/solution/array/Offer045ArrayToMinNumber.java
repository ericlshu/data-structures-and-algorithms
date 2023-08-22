package com.eric.solution.array;

import java.util.ArrayList;

/**
 * Description : 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * 提示:
 * 0 < nums.length <= 100
 * <p>
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * @author Eric L SHU
 * @date 2021-03-27 13:33
 * @since JDK 1.8
 */
public class Offer045ArrayToMinNumber {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : nums)
        {
            list.add(j);
        }
        list.sort((o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });
        for (Integer num : list)
        {
            sb.append(num);
        }
        return sb.toString();
    }
}
