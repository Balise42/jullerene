package fr.pasithee.jullerene;

import fr.pasithee.jullerene.algorithms.BFS;
import fr.pasithee.jullerene.model.EdgeListsGraph;
import fr.pasithee.jullerene.model.Graph;
import fr.pasithee.jullerene.util.Node;
import fr.pasithee.jullerene.util.NodeFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BFSTest {

    List<Node> nodes;
    Graph<Node> k33;
    Graph<Node> disconnected;

    @Before
    public void setUp() {
        String[] values = new String[]{"v0", "v1", "v2", "v3", "v4", "v5"};
        nodes = NodeFactory.createNodes(values);

        k33 = new EdgeListsGraph<>();
        k33.addEdge(nodes.get(0), nodes.get(3));
        k33.addEdge(nodes.get(0), nodes.get(4));
        k33.addEdge(nodes.get(0), nodes.get(5));
        k33.addEdge(nodes.get(1), nodes.get(3));
        k33.addEdge(nodes.get(1), nodes.get(4));
        k33.addEdge(nodes.get(1), nodes.get(5));
        k33.addEdge(nodes.get(2), nodes.get(3));
        k33.addEdge(nodes.get(2), nodes.get(4));
        k33.addEdge(nodes.get(2), nodes.get(5));

        disconnected = new EdgeListsGraph<>();
        disconnected.addEdge(nodes.get(0), nodes.get(1));
        disconnected.addEdge(nodes.get(1), nodes.get(2));
        disconnected.addEdge(nodes.get(3), nodes.get(4));
        disconnected.addEdge(nodes.get(3), nodes.get(5));
        disconnected.addEdge(nodes.get(4), nodes.get(5));
    }

    @Test
    public void BFSStepWithSingleNodeGraphShouldWork() {
        Graph<Node> g = new EdgeListsGraph<>();
        Map<Node, Integer> expected = new HashMap<>();
        BFS<Node> bfs = new BFS<>(g);
        assertEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithNoNodeGraphShouldWork() {
        Graph<Node> g = new EdgeListsGraph<>();
        Map<Node, Integer> expected = new HashMap<>();
        BFS<Node> bfs = new BFS<>(g);
        assertEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithTwoNodesOneUndirectedEdgeShouldWork() {
        Graph<Node> g = new EdgeListsGraph<>();
        g.setUndirected(true);

        String[] values = new String[]{"v0", "v1"};
        List<Node> nodes = NodeFactory.createNodes(values);

        g.addEdge(nodes.get(0), nodes.get(1));
        Map<Node, Integer> expected = new HashMap<>();
        expected.put(nodes.get(0), 0);
        expected.put(nodes.get(1), 1);
        BFS<Node> bfs = new BFS<>(g);
        assertEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithK33ShouldWork() {
        BFS<Node> bfs = new BFS<>(k33);

        Map<Node, Integer> result = bfs.step();
        int firstNodeIndex = -1;
        for (Map.Entry<Node, Integer> kv : result.entrySet()) {
            if (kv.getValue() == 0) {
                firstNodeIndex = nodes.indexOf(kv.getKey());
                break;
            }
        }

        assertTrue(firstNodeIndex != -1);

        if (firstNodeIndex < 3) {
            assertTrue(firstNodeIndex == 0 || (result.get(nodes.get(0)) >= 4));
            assertTrue(firstNodeIndex == 1 || (result.get(nodes.get(1)) >= 4));
            assertTrue(firstNodeIndex == 2 || (result.get(nodes.get(2)) >= 4));
            assertTrue(result.get(nodes.get(3)) > 0 && result.get(nodes.get(3)) < 4);
            assertTrue(result.get(nodes.get(4)) > 0 && result.get(nodes.get(4)) < 4);
            assertTrue(result.get(nodes.get(5)) > 0 && result.get(nodes.get(5)) < 4);
        } else {
            assertTrue(firstNodeIndex == 3 || (result.get(nodes.get(3)) >= 4));
            assertTrue(firstNodeIndex == 4 || (result.get(nodes.get(4)) >= 4));
            assertTrue(firstNodeIndex == 5 || (result.get(nodes.get(5)) >= 4));
            assertTrue(result.get(nodes.get(0)) > 0 && result.get(nodes.get(0)) < 4);
            assertTrue(result.get(nodes.get(1)) > 0 && result.get(nodes.get(1)) < 4);
            assertTrue(result.get(nodes.get(2)) > 0 && result.get(nodes.get(2)) < 4);
        }
    }

    @Test
    public void BFSStepWithDisconnectedGraphShouldWork() {
        BFS<Node> bfs = new BFS<>(disconnected);
        Map<Node, Integer> result = bfs.step();
        if (result.get(nodes.get(0)) != -1) {
            assertTrue(result.get(nodes.get(1)) != -1);
            assertTrue(result.get(nodes.get(2)) != -1);
            assertTrue(result.get(nodes.get(3)) == -1);
            assertTrue(result.get(nodes.get(4)) == -1);
            assertTrue(result.get(nodes.get(5)) == -1);
        } else {
            assertTrue(result.get(nodes.get(1)) == -1);
            assertTrue(result.get(nodes.get(2)) == -1);
            assertTrue(result.get(nodes.get(3)) != -1);
            assertTrue(result.get(nodes.get(4)) != -1);
            assertTrue(result.get(nodes.get(5)) != -1);
        }
    }

    /*@Test
    public void traversalWithK33ShouldWork() {
        EdgeListsGraph g = new EdgeListsGraph(6);
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
        EdgeListsGraph g = new EdgeListsGraph(7);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(1,2);
        g.addUndirectedEdge(2,6);
        g.addUndirectedEdge(3,4);
        g.addUndirectedEdge(3,5);
        g.addUndirectedEdge(4, 5);
        BFS bfs = new BFS(g);
        int[] result = bfs.traversal();
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result[2]);
        assertEquals(3, result[6]);
        assertEquals(4, result[3]);
        assertTrue((result[4] == 5 && result[5] == 6) || (result[4] == 6 && result[5] == 5));
    }*/

}
