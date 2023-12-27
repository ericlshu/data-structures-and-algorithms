package com.eric;

import com.eric.solution.sort.BubbleSort;
import com.eric.solution.sort.SelectionSort;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2023-12-27 11:44 AM
 * @since jdk-11.0.14
 */
public class SortTest
{
    int[] arr;

    @Before
    public void setup()
    {
        arr = new int[]{0, 3, 7, 2, 5, 8, 1, 4, 9, 6};
    }

    @Test
    public void testBubbleSort()
    {
        System.out.println("before : " + Arrays.toString(arr));
        BubbleSort.sort(arr);
        System.out.println("after  : " +Arrays.toString(arr));
    }

    @Test
    public void testSelectionSort()
    {
        System.out.println("before : " + Arrays.toString(arr));
        SelectionSort.sort(arr);
        System.out.println("after  : " +Arrays.toString(arr));
    }
}
