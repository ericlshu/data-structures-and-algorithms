package com.shl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description :
 * <p>
 * Gregor is a salesperson employed in the city of Cartesia, which is an infinite plane, the locations of which follow the Cartesian coordinate System,
 * There are N+1 retailers in the city.
 * N recallers, with positions 1 to N, have the coordinates (Xi, O), Os2, O) to (s, O), The heade city.recaller, with position N+1,is located at the coordlinate Xr+1, Yo+1),
 * Gregor wishes to find the shortest possible path from a given Kth retailer to all the other retailers in the city.
 * He may visit a retailer twice along his route,The distance between anywo retallers Is the same as the distance between wo points in the Carcesian coordinarssystem.Write an algorithm to help Gregor to find the minimum distance of a path that willallow hinto visit all the gven retalers
 * <p>
 * Input
 * The first line of the input consists of an integer -posk, representing the position of the starting retailer (K).
 * The second line consists of an integer -nun,representing, the number of retailers on the axis(N).
 * The third line consists of N space-separated integers,representing the X coordinate of retailers on the X-axis.
 * The fourh line consists of an integer - XN+1, representing the X-coordinate of the head retailer,
 * The fith Iine consists of an integer . YN-1,representing the Y-coordinate of the head realler
 * <p>
 * Output
 * Print a real number representing the minimum possible length of the path that ravel through all the given points, rounded up to 6 decimal places.
 *
 * @author Eric L SHU
 * @date 2026-01-13 20:35
 */
public class GregorIsASalespersonEmployedInTheCityOfCartesia
{
    static class Point
    {
        int x, y;

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        double distance(Point p)
        {
            return Math.hypot(x - p.x, y - p.y);
        }
    }

    public static double minimumDistance(int posK, int num, int[] x, int headX, int headY)
    {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < num; i++)
        {
            points.add(new Point(x[i], 0));
        }
        points.add(new Point(headX, headY));

        Point start = points.get(posK - 1);
        List<Point> others = new ArrayList<>(points);
        others.remove(posK - 1);

        return tsp(start, others);
    }

    private static double tsp(Point start, List<Point> points)
    {
        boolean[] visited = new boolean[points.size()];
        return dfs(start, points, visited, 0, 0);
    }

    private static double dfs(Point current, List<Point> points, boolean[] visited, int count, double distSoFar)
    {
        if (count == points.size()) return distSoFar;

        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.size(); i++)
        {
            if (!visited[i])
            {
                visited[i] = true;
                double d = current.distance(points.get(i));
                min = Math.min(min, dfs(points.get(i), points, visited, count + 1, distSoFar + d));
                visited[i] = false;
            }
        }
        return min;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int posK = sc.nextInt();
        int num = sc.nextInt();
        int[] x = new int[num];
        for (int i = 0; i < num; i++)
        {
            x[i] = sc.nextInt();
        }
        int headX = sc.nextInt();
        int headY = sc.nextInt();
        double ans = minimumDistance(posK, num, x, headX, headY);
        System.out.printf("%.6f\n", ans);
    }
}
