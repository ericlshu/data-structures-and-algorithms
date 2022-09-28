package solution.string;

/**
 * Description : Excel 表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
 * 示例 1:
 * 输入: columnTitle = "A"
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: columnTitle = "AB"
 * 输出: 28
 * <p>
 * 示例 3:
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * <p>
 * 提示：
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 *
 * @author Eric L SHU
 * @date 2022-09-28 9:39 PM
 * @since jdk-11.0.14
 */
public class P0171ExcelSheetColumnNumber
{
    public int titleToNumber_1(String columnTitle)
    {
        int len = columnTitle.length();
        int ret = 0;
        for (int i = 0; i < len; i++)
        {
            ret += Math.pow(26, len - i - 1) * (columnTitle.charAt(i) - '@');
        }
        return ret;
    }

    public int titleToNumber(String columnTitle)
    {
        int len = columnTitle.length();
        int ret = 0;
        // int multiple = 1;
        // for (int i = len - 1; i >= 0; i--)
        // {
        //     ret += (columnTitle.charAt(i) - '@') * multiple;
        //     multiple *= 26;
        // }
        for (int i = 0; i < len; i++)
        {
            ret = ret * 26 + (columnTitle.charAt(i) - '@');
        }
        return ret;
    }
}
