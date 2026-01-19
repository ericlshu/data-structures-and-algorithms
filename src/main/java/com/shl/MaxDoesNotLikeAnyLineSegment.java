package com.shl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description :
 * Max does not like any line segment that he sees on the X-axis.
 * Today,his brother drew N line segments on itMax has a magical marker that can erase all the line segments that pass
 * through a point on the X-axis when he places the marker on that point. For example,he wishes to erase two line segments-one with endpoints (1,0) and (4,O),
 * and another with endpoints (3,0) and (7,0). He can clear both lines at once by placing the marker either at point (3,0) or (4,0) but he cannot do so if he places the marker anywhere else
 * <p>
 * Write an algorithm to find the minimum number of times Max must use the marker to dear the X-axis.
 * <p>
 * Input
 * The first line of the input consists of an integer - num5,representing the number of starting X-coordinates of ine segments on the X-axis (N).
 * The second line consists of N space-separated integers - startXo startX,... startXr-,representing the X coordinates of the starting points of line segments
 * The third line consists of an integer - numE, representing the number of ending X-coordinates of line
 * segments on the X-axis (M=N always).The last line consists of M space-separated integers-endxo endX,... endXw-, representing the X-
 * coordinates of the ending points of the line segments.
 * OutputPrint an integer representing the minimum number of times Max must use the marker to clear all the line segments on the X-axis
 * <p>
 * Example
 * Input:
 * 4
 * 0 2 4 -8
 * 4
 * 4 5 6 -9
 * Output:
 * 2
 * <p>
 * Explanation
 * Placing the marker at point 4 on the X-axis will erase the first three line segments.
 * The remaining line segment must be erased by placing the marker at any point on -9or-8.
 * So,the number of times the marker must be placed on the X-axis Is 2
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:15
 */
public class MaxDoesNotLikeAnyLineSegment
{
    public static int markerPlaced(int[] startX, int[] endX)
    {
        int n = startX.length;
        // 将所有线段按结束点从小到大排序
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++)
        {
            segments[i][0] = startX[i];
            segments[i][1] = endX[i];
        }

        Arrays.sort(segments, (a, b) -> Integer.compare(a[1], b[1]));

        int markerCount = 0;
        int lastMarkerPos = Integer.MIN_VALUE;

        for (int[] seg : segments)
        {
            int segStart = seg[0];
            int segEnd = seg[1];

            // 如果当前线段未被已放置的标记器覆盖，则放一个新的标记器
            if (segStart > lastMarkerPos)
            {
                markerCount++;
                lastMarkerPos = segEnd;
            }
        }

        return markerCount;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // 输入起始点
        int startX_size = in.nextInt();
        int[] startX = new int[startX_size];
        for (int i = 0; i < startX_size; i++)
        {
            startX[i] = in.nextInt();
        }

        // 输入终点
        int endX_size = in.nextInt();
        int[] endX = new int[endX_size];
        for (int i = 0; i < endX_size; i++)
        {
            endX[i] = in.nextInt();
        }

        int result = markerPlaced(startX, endX);
        System.out.println(result);
    }
}
