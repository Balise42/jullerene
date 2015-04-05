package fr.pasithee.jullerene;

import fr.pasithee.jullerene.algorithms.BFS;
import fr.pasithee.jullerene.model.Graph;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BFSTest {
    @Test
    public void BFSWithSingleNodeGraphShouldWork() {
        Graph g = new Graph(1);
        int[] expected = new int[1];
        expected[0] = 0;
        BFS bfs = new BFS(g);
        assertArrayEquals(expected, bfs.step());
    }

    @Test
    public void BFSWithNoNodeGraphShouldWork() {
        Graph g = new Graph(0);
        int[] expected = new int[0];
        BFS bfs = new BFS(g);
        assertArrayEquals(expected, bfs.step());
    }

    @Test
    public void BFSWithTwoNodesOneUndirectedEdgeShouldWork() {
        Graph g = new Graph(2);
        g.addUndirectedEdge(0, 1);
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;
        BFS bfs = new BFS(g);
        assertArrayEquals(expected, bfs.step());
    }
}
