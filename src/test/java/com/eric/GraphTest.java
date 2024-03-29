package com.eric;

import com.eric.solution.graph.P0797AllPathsFromSourceToTarget;
import com.eric.solution.graph.P1971FindIfPathExistsInGraph;
import com.eric.solution.graph.P1976NumberOfWaysToArriveAtDestination;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-12-19 19:26
 * @since jdk-11.0.14
 */
public class GraphTest
{
    @Test
    public void test1971()
    {
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        P1971FindIfPathExistsInGraph p1971 = new P1971FindIfPathExistsInGraph();
        assertTrue(p1971.validPath_bfs(3, edges1, 0, 2));
        assertTrue(p1971.validPath_dfs(3, edges1, 0, 2));
        assertFalse(p1971.validPath_dfs(6, edges2, 0, 5));
        assertFalse(p1971.validPath_bfs(6, edges2, 0, 5));
    }

    @Test
    public void test0797()
    {
        P0797AllPathsFromSourceToTarget p0797 = new P0797AllPathsFromSourceToTarget();
        int[][] graph1 = {{1, 2}, {3}, {3}, {}};
        int[][] graph2 = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        assertEquals("[[0, 1, 3], [0, 2, 3]]",
                p0797.allPathsSourceTarget_dfs(graph1).toString());
        assertEquals("[[0, 4], [0, 3, 4], [0, 1, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4]]",
                p0797.allPathsSourceTarget_bfs(graph2).toString());
    }

    @Test
    public void test1976()
    {
        P1976NumberOfWaysToArriveAtDestination p1976 = new P1976NumberOfWaysToArriveAtDestination();
        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}};
        assertEquals(0, p1976.countPaths(7, roads));
    }
}
