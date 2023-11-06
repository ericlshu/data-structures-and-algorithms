package com.eric.solution.array;

import java.util.Arrays;

public class P0295FindMedianFromDataStream
{
    private final Heap maxHeap;
    private final Heap minHeap;

    public P0295FindMedianFromDataStream()
    {
        maxHeap = new Heap(10, true);
        minHeap = new Heap(10, false);
    }

    public void addNum(int num)
    {
        if (maxHeap.size == minHeap.size)
        {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else
        {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian()
    {
        if (maxHeap.size == minHeap.size)
        {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else
        {
            return maxHeap.peek();
        }
    }

    @Override
    public String toString()
    {
        int size = maxHeap.size;
        int[] left = new int[size];
        for (int i = 0; i < left.length; i++)
        {
            left[size - 1 - i] = this.maxHeap.arr[i];
        }
        int[] right = Arrays.copyOf(this.minHeap.arr, this.minHeap.size);
        return Arrays.toString(left) + " <-> " + Arrays.toString(right);
    }

    public static class Heap
    {
        int[] arr;
        int size;
        boolean max;

        public Heap(int capacity, boolean max)
        {
            this.arr = new int[capacity];
            this.max = max;
        }

        // public Heap(int[] array, boolean max)
        // {
        //     this.arr = array;
        //     this.size = array.length;
        //     this.max = max;
        //     heapify();
        // }
        //
        // private void heapify()
        // {
        //     for (int i = size / 2 - 1; i >= 0; i--)
        //     {
        //         down(i);
        //     }
        // }

        public int peek()
        {
            return arr[0];
        }

        public int poll()
        {
            int top = arr[0];
            swap(0, --size);
            down(0);
            return top;
        }

        // public void replace(int replaced)
        // {
        //     arr[0] = replaced;
        //     down(0);
        // }

        public void offer(int offered)
        {
            if (size == arr.length)
                grow();
            up(offered);
            size++;
        }

        private void grow()
        {
            int capacity = size + (size >> 1);
            int[] newArray = new int[capacity];
            System.arraycopy(arr, 0, newArray, 0, size);
            arr = newArray;
        }

        private void up(int offered)
        {
            int child = size;
            while (child > 0)
            {
                int parent = (child - 1) / 2;
                boolean boo = max ? offered > arr[parent] : offered < arr[parent];
                if (boo)
                    arr[child] = arr[parent];
                else
                    break;
                child = parent;
            }
            arr[child] = offered;
        }

        private void down(int parent)
        {
            int left = parent * 2 + 1;
            int right = left + 1;
            int next = parent;
            if (left < size && (max ? arr[left] > arr[next] : arr[left] < arr[next]))
            {
                next = left;
            }
            if (right < size && (max ? arr[right] > arr[next] : arr[right] < arr[next]))
            {
                next = right;
            }
            if (next != parent)
            {
                swap(next, parent);
                down(next);
            }
        }

        private void swap(int i, int j)
        {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
