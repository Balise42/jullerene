package fr.pasithee.jullerene;

import fr.pasithee.jullerene.algorithms.BFS;
import fr.pasithee.jullerene.model.Graph;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BFSTest {
    @Test
    public void BFSStepWithSingleNodeGraphShouldWork() {
        Graph g = new Graph(1);
        int[] expected = new int[1];
        expected[0] = 0;
        BFS bfs = new BFS(g);
        assertArrayEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithNoNodeGraphShouldWork() {
        Graph g = new Graph(0);
        int[] expected = new int[0];
        BFS bfs = new BFS(g);
        assertArrayEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithTwoNodesOneUndirectedEdgeShouldWork() {
        Graph g = new Graph(2);
        g.addUndirectedEdge(0, 1);
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;
        BFS bfs = new BFS(g);
        assertArrayEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithK33ShouldWork() {
        Graph g = new Graph(6);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(0, 4);
        g.addUndirectedEdge(0, 5);
        g.addUndirectedEdge(1, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(1, 5);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(2, 4);
        g.addUndirectedEdge(2, 5);
        Set<Integer> expectedFirstStep = new HashSet<>();
        Set<Integer> expectedSecondStep = new HashSet<>();
        Set<Integer> expectedThirdStep = new HashSet<>();
        expectedFirstStep.add(0);
        expectedSecondStep.add(3);
        expectedSecondStep.add(4);
        expectedSecondStep.add(5);
        expectedThirdStep.add(1);
        expectedThirdStep.add(2);
        BFS bfs = new BFS(g);
        int[] result = bfs.step();
        Set<Integer> resultFirstStep = new HashSet<>();
        Set<Integer> resultSecondStep = new HashSet<>();
        Set<Integer> resultThirdStep = new HashSet<>();
        for(int i = 0;i<6; i++) {
            if(result[i] == 0) {
                resultFirstStep.add(i);
            } else if(result[i] <= 3) {
                resultSecondStep.add(i);
            } else {
                resultThirdStep.add(i);
            }
        }
        assertEquals(expectedFirstStep, resultFirstStep);
        assertEquals(expectedSecondStep, resultSecondStep);
        assertEquals(expectedThirdStep, resultThirdStep);
    }

    @Test
    public void BFSStepWithDisconnectedGraphShouldWork() {
        Graph g = new Graph(6);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(1,2);
        g.addUndirectedEdge(3,4);
        g.addUndirectedEdge(3,5);
        g.addUndirectedEdge(4,5);
        int[] expected = new int[6];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;
        expected[3] = -1;
        expected[4] = -1;
        expected[5] = -1;
        BFS bfs = new BFS(g);
        assertArrayEquals(expected, bfs.step());
    }

    @Test
    public void traversalWithK33ShouldWork() {
        Graph g = new Graph(6);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(0, 4);
        g.addUndirectedEdge(0, 5);
        g.addUndirectedEdge(1, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(1, 5);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(2, 4);
        g.addUndirectedEdge(2, 5);
        Set<Integer> expectedFirstStep = new HashSet<>();
        Set<Integer> expectedSecondStep = new HashSet<>();
        Set<Integer> expectedThirdStep = new HashSet<>();
        expectedFirstStep.add(0);
        expectedSecondStep.add(3);
        expectedSecondStep.add(4);
        expectedSecondStep.add(5);
        expectedThirdStep.add(1);
        expectedThirdStep.add(2);
        BFS bfs = new BFS(g);
        int[] result = bfs.traversal();
        Set<Integer> resultFirstStep = new HashSet<>();
        Set<Integer> resultSecondStep = new HashSet<>();
        Set<Integer> resultThirdStep = new HashSet<>();
        for(int i = 0;i<6; i++) {
            if(result[i] == 0) {
                resultFirstStep.add(i);
            } else if(result[i] <= 3) {
                resultSecondStep.add(i);
            } else {
                resultThirdStep.add(i);
            }
        }
        assertEquals(expectedFirstStep, resultFirstStep);
        assertEquals(expectedSecondStep, resultSecondStep);
        assertEquals(expectedThirdStep, resultThirdStep);
    }

    @Test
    public void BFSWithDisconnectedGraphShouldWork() {
        Graph g = new Graph(6);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(1,2);
        g.addUndirectedEdge(3,4);
        g.addUndirectedEdge(3,5);
        g.addUndirectedEdge(4, 5);
        BFS bfs = new BFS(g);
        int[] result = bfs.traversal();
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result[2]);
        assertEquals(3, result[3]);
        assertTrue((result[4] == 4 && result[5] == 5) || (result[4] == 5 && result[5] == 4));
    }

}
