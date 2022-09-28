package solution.string;

/**
 * Description : Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 * <p>
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 * <p>
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 * <p>
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * <p>
 * 提示：
 * 1 <= columnNumber <= 231 - 1
 *
 * @author Eric L SHU
 * @date 2022-09-28 10:05 PM
 * @since jdk-11.0.14
 */
public class P0168ExcelSheetColumnTitle
{
    public String convertToTitle_1(int columnNumber)
    {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0)
        {
            int mod = columnNumber % 26;
            if (mod == 0)
            {
                sb.append('Z');
                columnNumber = columnNumber - 26;
            }
            else
            {
                sb.append((char) (mod + '@'));
            }
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }

    public String convertToTitle_2(int columnNumber)
    {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0)
        {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char) (a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }

    public String convertToTitle(int columnNumber)
    {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0)
        {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
