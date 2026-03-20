package com.shl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Description : 📄 Question
 * <p>
 * A transportation company wishes to begin service in the city of Nazeriana.
 * The company has a base location where it parks all its vehicles. They have identified some pickup locations where the vehicles will collect passengers.
 * Now the company wishes to identify the straight line routes from the base location to the pickup locations.
 * They wish to minimize the number of routes while ensuring that all the pickup locations are covered.
 * Write an algorithm to help the company identify the minimum number of straight line routes from the base location to the pickup locations, covering every pickup location.
 * <p>
 * 📥 Input
 * The first line of the input consists of two space-separated integers, num and numCord, representing the number of pickup locations (N) and number of coordinates for a pickup location (numCord is always equal to two), respectively.
 * The next N lines consist of P space-separated integers pickX and pickY, representing the X and Y coordinates of a pickup location, respectively.
 * The next line consists of an integer baseX, representing the X coordinate of the base location.
 * The next line consists of an integer baseY, representing the Y coordinate of the base location.
 * <p>
 * 📤 Output
 * Print an integer representing the minimum number of routes connecting all the pickup locations to the base location.
 * <p>
 * ⚙️ Constraints
 * 1≤num≤10^5
 * -10^3≤pickX,pickY,baseX,baseY≤10^3
 * <p>
 * 📌 Example
 * Input:
 * 3 2
 * 1 1
 * -1 1
 * 2 3
 * 0
 * 0
 * Output:
 * 3
 * <p>
 * 🧾 Explanation
 * From the base coordinate (0,0), three different routes will cover all the pickup locations.
 *
 * @author Eric L SHU
 * @date 2026-03-20 12:15
 * @since jdk-11.0.14
 */
public class ATransportationCompanyWishesToBeginService
{
    public static int minRoutes(int[][] pickLoc, int baseX, int baseY)
    {
        Set<String> set = new HashSet<>();

        for (int[] p : pickLoc)
        {
            int dx = p[0] - baseX;
            int dy = p[1] - baseY;

            // 如果点和base重合，跳过
            if (dx == 0 && dy == 0) continue;

            int g = gcd(dx, dy);
            dx /= g;
            dy /= g;

            // 统一方向（保证唯一性）
            if (dx < 0)
            {
                dx = -dx;
                dy = -dy;
            }
            else if (dx == 0)
            {
                dy = dy > 0 ? 1 : -1;
            }

            set.add(dx + "," + dy);
        }

        return set.size();
    }

    private static int gcd(int a, int b)
    {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int pickLoc_row = in.nextInt();
        int pickLoc_col = in.nextInt();

        int[][] pickLoc = new int[pickLoc_row][pickLoc_col];

        for (int i = 0; i < pickLoc_row; i++)
        {
            for (int j = 0; j < pickLoc_col; j++)
            {
                pickLoc[i][j] = in.nextInt();
            }
        }

        int baseX = in.nextInt();
        int baseY = in.nextInt();

        int result = minRoutes(pickLoc, baseX, baseY);
        System.out.println(result);
    }
}
