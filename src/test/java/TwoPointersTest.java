import org.junit.Test;
import solution.two_pointers.P0349_IntersectionOfTwoArrays;
import solution.two_pointers.P0845_LongestMountainInArray;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2021-03-27 14:25
 * @since JDK 1.8
 */
public class TwoPointersTest
{
    @Test
    public void testP0349()
    {
        P0349_IntersectionOfTwoArrays obj = new P0349_IntersectionOfTwoArrays();
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] result = obj.intersection(nums1, nums2);
        for (int i : result)
        {
            System.out.println("i = " + i);
        }
    }

    @Test
    public void testP0845()
    {
        P0845_LongestMountainInArray obj = new P0845_LongestMountainInArray();
        int[] nums = {0, 2, 0, 0, 2, 0, 2, 1, 1, 0, 2, 1, 0, 0, 1, 0, 2, 1, 2, 0, 1, 1, 0, 2, 2, 1, 2, 2, 0, 0, 0, 1, 0, 2, 0, 0, 1, 2, 0, 1, 0, 2, 0, 2, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 1, 0, 2, 1, 2, 2, 1, 0, 0, 1, 0, 2, 0, 0, 0, 2, 1, 0, 1, 2, 1, 0, 1, 0, 2, 1, 0, 2, 0, 2, 1, 1, 2, 0, 1, 0, 1, 1, 1, 1, 2, 1, 2, 2, 2, 0};
        System.out.println("result = " + obj.longestMountain(nums));
    }
}
