package com.eric.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-09-08 20:32
 * @since jdk-11.0.14
 */
public class P0118PascalsTriangle
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
        {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++)
            {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            list.add(row);
        }
        return list;
    }
}
