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
        System.out.println("/******************************************************/");
        arr = new int[]{0, 3, 2, 7, 2, 5, -1, 4, 4, -2, 8, 1, 4, 9, 6};
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

    @Test
    public void testMergeSortTopDown()
    {
        MergeSort.sortTopDown(arr);
    }

    @Test
    public void testMergeBottomUp()
    {
        MergeSort.sortBottomUp(arr);
    }

    @Test
    public void testQuickSort()
    {
        QuickSort.sort(arr);
    }

    @Test
    public void testCountingSort()
    {
        CountingSort.sort(arr);
    }

    @Test
    public void testBucketSortByRange()
    {
        BucketSort.sortByRange(arr);
    }

    @Test
    public void testBucketSortByCount()
    {
        BucketSort.sortByCount(arr);
    }

    @Test
    public void testRadixSort()
    {
        String[] phoneNumbers = new String[10];  // 0~127
        phoneNumbers[0] = "13812345678";  // int long
        phoneNumbers[1] = "13912345678";
        phoneNumbers[2] = "13612345678";
        phoneNumbers[3] = "13712345678";
        phoneNumbers[4] = "13512345678";
        phoneNumbers[5] = "13412345678";
        phoneNumbers[6] = "15012345678";
        phoneNumbers[7] = "15112345678";
        phoneNumbers[8] = "15212345678";
        phoneNumbers[9] = "15712345678";
        System.out.println("before : " + Arrays.toString(phoneNumbers));
        RadixSort.sort(phoneNumbers, 11);
        System.out.println("after  : " + Arrays.toString(phoneNumbers));
    }

    @After
    public void after()
    {
        System.out.println("after  : " + Arrays.toString(arr));
        System.out.println("/******************************************************/");
    }
}
