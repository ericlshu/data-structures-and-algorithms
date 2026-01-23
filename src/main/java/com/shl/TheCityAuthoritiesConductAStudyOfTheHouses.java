package com.shl;

import java.util.Scanner;

/**
 * Description :
 * <p>
 * The city authorities conduct a study of the houses in a residential area for a city planning. scheme.
 * The area is depicted in an aerial view and divided into an N x M grid. If a grid cell contains some part of a house roof,
 * then it is assigned the value 1; otherwise, the cell represents a vacant plot and is assigned the value 0,
 * Clusters of adjacent grid cells with value 1 represent a single house. Diagonally placed grids with value 1 do not represent a single house.
 * The area of a house is the number of 1s that it spans. Write an algorithm to find the area of the largest house.
 * <p>
 * Input
 * The first line of the input consists of two space-separated integers - rows and cols representing the number of rows (N) and the number of columns in the grid (M), respectively.
 * The next N lines consist of M space-separated integers representing the grid.
 * <p>
 * Output
 * Print an integer representing the area of the largest house. Constraints The elements of the grid consist of Os and 1s only.
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:32
 */
public class TheCityAuthoritiesConductAStudyOfTheHouses
{

    static int rows, cols;
    static int[][] grid;
    static boolean[][] visited;

    // 上下左右四个方向
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static int houseMaxArea(int[][] gridInput)
    {
        grid = gridInput;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == 1 && !visited[i][j])
                {
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int r, int c)
    {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0 || visited[r][c])
        {
            return 0;
        }

        visited[r][c] = true;
        int area = 1;

        for (int i = 0; i < 4; i++)
        {
            area += dfs(r + dr[i], c + dc[i]);
        }
        return area;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        rows = in.nextInt();
        cols = in.nextInt();
        int[][] gridInput = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                gridInput[i][j] = in.nextInt();

        int result = houseMaxArea(gridInput);
        System.out.println(result);
    }
}
