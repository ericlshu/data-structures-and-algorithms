package com.shl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description :
 * A colony of eight houses,represented as cells, are arranged in a straight line.
 * Each day every cell competes with its adjacent cells(neighbours),
 * An integer value of 1 represents an active cell and value of represents an inactive cell. If both the neighbors are either active or inactive,
 * the cel becomes inactive the next day: otherwise it becomes active on the next day.
 * The two cells on the ends have a single adjacent cell so the other adjacent cell can be assumed to be always inactive,Even after updating the cell state,
 * its previous state is considered for updating the state of other cells.
 * The cell information of all cells should be updated simultaneously.
 * <p>
 * Write an algorithm to output the state of the cells after the given number of days.
 * input
 * <p>
 * The first line of the input consists of an integer num represent the number of cells (where num is always equal ta eight)
 * The second line consists of eight space separated integers cel,, ce/aceNsrepresentng the current state of cells.
 * The third line consists of an integer days,representing the number of days. Note
 * The state of the cells is represented by0s and is only.
 * <p>
 * Example
 * Input
 * 8
 * 1 0 0 0 0 1 0 0
 * 1
 * Output
 * 0 1 0 0 1 0 1 0
 *
 * @author Eric L SHU
 * @date 2025-08-06 16:38
 */
public class AColonyOfEightHouses
{
    public static int[] stateofCells(int[] cell, int days)
    {
        int[] curr = Arrays.copyOf(cell, cell.length);
        for (int d = 0; d < days; d++)
        {
            int[] next = new int[curr.length];
            for (int i = 0; i < curr.length; i++)
            {
                int left = (i == 0) ? 0 : curr[i - 1];
                int right = (i == curr.length - 1) ? 0 : curr[i + 1];
                next[i] = (left == right) ? 0 : 1;
            }
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);// input for cell
        int cell_size = in.nextInt();
        int cell[] = new int[cell_size];
        for (int idx = 0; idx < cell_size; idx++)
        {
            cell[idx] = in.nextInt();
        }
        // input for days
        int days = in.nextInt();
        int[] result = stateofCells(cell, days);
        for (int idx = 0; idx < result.length - 1; idx++)
        {
            System.out.print(result[idx] + " ");
        }

        System.out.print(result[result.length - 1]);
    }
}
