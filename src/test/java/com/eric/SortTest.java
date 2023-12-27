package com.eric;

import com.eric.solution.sort.*;
import org.junit.After;
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
        System.out.println("/*************************************/");
        arr = new int[]{0, 3, 7, 2, 5, 8, 1, 4, 9, 6};
        System.out.println("before : " + Arrays.toString(arr));
    }

    @Test
    public void testBubbleSort()
    {
        BubbleSort.sort(arr);
    }

    @Test
    public void testSelectionSort()
    {
        SelectionSort.sort(arr);
    }

    @Test
    public void testHeapSort()
    {
        HeapSort.sort(arr);
    }

    @Test
    public void testInsertionSort()
    {
        InsertionSort.sort(arr);
    }

    @Test
    public void testShellSort()
    {
        ShellSort.sort(arr);
    }

    @After
    public void after()
    {
        System.out.println("after  : " + Arrays.toString(arr));
        System.out.println("/*************************************/");
    }
}
