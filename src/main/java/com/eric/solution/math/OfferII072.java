package com.eric.solution.math;

import java.util.Queue;

/**
 * Description : 求平方根
 * <p>
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * 正数的平方根有两个，只输出其中的正数平方根。
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: x = 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 * <p>
 * 提示:
 * 0 <= x <= 231 - 1
 *
 * @author Eric L SHU
 * @date 2022-01-01 18:45
 * @since JDK 1.8
 */
public class OfferII072 {
    public int mySqrtApi(int x) {
        return (int) Math.floor(Math.sqrt(x));
    }

    public int mySqrtBaoLi(int x) {
        if (x == 0) return 0;
        int i = 1;
        for (; i < x; i++) {
            if (i <= x / i && (i + 1) > x / (i + 1))
                break;
        }
        return i;
    }

    public int mySqrtBisection(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        int result = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }

    public int mySqrtNewton(int x) {
        if (x == 0) return 0;
        return (int) sqrt(x, x / 2);
    }

    private double sqrt(int x, double estimation) {
        double evg = (estimation + x / estimation) / 2;
        float diff = 1e-6f;
        if (Math.abs(evg - estimation) < diff) {
            return evg;
        }
        else {
            return sqrt(x, evg);
        }
    }
}
