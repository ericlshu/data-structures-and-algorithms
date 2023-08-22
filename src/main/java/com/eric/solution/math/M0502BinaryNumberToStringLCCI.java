package com.eric.solution.math;

/**
 * Description : 面试题 05.02. 二进制数转字符串
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * <p>
 * 示例1:
 * 输入：0.625
 * 输出："0.101"
 * <p>
 * 示例2:
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 * <p>
 * 提示：
 * -> 32位包括输出中的 "0." 这两位。
 * -> 题目保证输入用例的小数位数最多只有 6 位
 *
 * @author Eric L SHU
 * @date 2023-03-06 20:44
 * @since jdk-11.0.14
 */
public class M0502BinaryNumberToStringLCCI
{
    /**
     * 因此在二进制表示中，将一个数乘以 2 的效果是将小数点向右移动一位。
     * 每次将实数乘以 2，将此时的整数部分添加到二进制表示的末尾，然后将整数部分置为 0，重复上述操作，直到小数部分变成 0 或者小数部分出现循环时结束操作。
     */
    public String printBin(double num)
    {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0)
        {
            num *= 2;
            int digit = (int) num;
            sb.append(digit);
            num -= digit;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }
}
