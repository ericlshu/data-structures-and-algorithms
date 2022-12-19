import org.junit.Test;
import solution.graph.P1971FindIfPathExistsInGraph;

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
        System.out.println(p1971.validPath_bfs(3, edges1, 0, 2));
        System.out.println(p1971.validPath_dfs(3, edges1, 0, 2));
        System.out.println(p1971.validPath_dfs(6, edges2, 0, 5));
        System.out.println(p1971.validPath_bfs(6, edges2, 0, 5));
    }
}
