package com.eric.solution.array;

import java.util.PriorityQueue;

public class P0295FindMedianFromDataStream2
{
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public P0295FindMedianFromDataStream2()
    {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num)
    {
        if (maxHeap.size() == minHeap.size())
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
        if (maxHeap.size() == minHeap.size())
        {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else
        {
            return maxHeap.peek();
        }
    }
}
