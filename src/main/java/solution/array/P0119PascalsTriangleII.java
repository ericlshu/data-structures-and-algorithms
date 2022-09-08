package solution.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-09-08 20:35
 * @since jdk-11.0.14
 */
public class P0119PascalsTriangleII
{
    /**
     * 递归
     */
    public List<Integer> getRow(int rowIndex)
    {
        if (rowIndex == 0)
            return Collections.singletonList(1);
        List<Integer> last = getRow(rowIndex - 1);
        List<Integer> curr = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++)
        {
            if (i == 0 || i == rowIndex)
                curr.add(1);
            else
                curr.add(last.get(i - 1) + last.get(i));
        }
        return curr;
    }

    /**
     * 滚动数组
     */
    public List<Integer> getRow_1(int rowIndex)
    {
        List<Integer> prev = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i)
        {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; ++j)
            {
                if (j == 0 || j == i)
                    curr.add(1);
                else
                    curr.add(prev.get(j - 1) + prev.get(j));
            }
            prev = curr;
        }
        return prev;
    }

    /**
     * 单个数组
     */
    public List<Integer> getRow_2(int rowIndex)
    {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++)
        {
            row.add(0);
            for (int j = i; j > 0; --j)
            {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    /**
     * 递推公式
     */
    public List<Integer> getRow_3(int rowIndex)
    {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i)
        {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
