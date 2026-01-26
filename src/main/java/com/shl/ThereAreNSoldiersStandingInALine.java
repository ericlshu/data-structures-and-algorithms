package com.shl;

import java.util.Scanner;

/**
 * Description :
 * There are N soldiers standing in a line, with IDs from 1 to N, in ascending order.
 * They are participating in an exercise consisting of Q actions. During the ith action, the Major calls S numbers row; and col;.
 * The soldiers at the row, th and colth positions swap places; then the soldiers at (row,+1)th and (col,-1)th positions swap places,
 * and so on until (row,+m)< (col,-m), Each of the soldier's IDs will be covered in the range [row, col] for at most one action.
 * <p>
 * Write an algorithm to find the ID of the soldier at Kth position in the line after all the actions are completed.
 * <p>
 * Input
 * The first line of the input consists of an integer- num, representing the number of soldiers (N).
 * The second line consists of two space-separated integers-actions and numSoldiers, representing the number of actions (Q) and number of soldiers called by the Major (5), respectively.
 * The next Q lines consist of 5 space-separated integers - row; and col;, representing the positions of the soldiers initially called for the ith action.
 * The last line consists of an integer- posSoldier, representing the position of the soldier whose ID is requested to be found after Q actions (K).
 * <p>
 * Output
 * Print an integer representing the ID of the Kth position soldier in the line after Qactions.
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:30
 */
public class ThereAreNSoldiersStandingInALine
{
    public static int soldierATK(int num, int[][] actions, int posSoldier)
    {
        int[] soldiers = new int[num];
        for (int i = 0; i < num; i++)
        {
            soldiers[i] = i + 1;
        }

        // 遍历每次操作
        for (int i = 0; i < actions.length; i++)
        {
            int row = actions[i][0] - 1; // 0-index
            int col = actions[i][1] - 1;

            while (row < col)
            {
                int temp = soldiers[row];
                soldiers[row] = soldiers[col];
                soldiers[col] = temp;
                row++;
                col--;
            }
        }

        return soldiers[posSoldier - 1]; // 1-based position
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // 输入士兵总数
        int num = in.nextInt();

        // 输入操作数和numSoldiers（numSoldiers无用）
        int actionsCount = in.nextInt();
        in.nextInt(); // 忽略numSoldiers

        // 输入 Q 个操作，每行两个数
        int[][] actions = new int[actionsCount][2];
        for (int i = 0; i < actionsCount; i++)
        {
            actions[i][0] = in.nextInt();
            actions[i][1] = in.nextInt();
        }

        // 输入需要查询的位置
        int posSoldier = in.nextInt();

        // 调用 soldierATK 函数
        int result = soldierATK(num, actions, posSoldier);
        System.out.println(result);
    }
}
