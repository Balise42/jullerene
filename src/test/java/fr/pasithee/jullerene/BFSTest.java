package fr.pasithee.jullerene;

import fr.pasithee.jullerene.algorithms.BFS;
import fr.pasithee.jullerene.model.EdgeListsGraph;
import fr.pasithee.jullerene.model.Graph;
import fr.pasithee.jullerene.util.Node;
import fr.pasithee.jullerene.util.NodeFactory;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BFSTest {

    @Test
    public void BFSStepWithSingleNodeGraphShouldWork() {
        Graph g = new EdgeListsGraph<Node>();
        Map<Node, Integer> expected = new HashMap<Node, Integer>();
        BFS<Node> bfs = new BFS<Node>(g);
        assertEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithNoNodeGraphShouldWork() {
        Graph g = new EdgeListsGraph<Node>();
        Map<Node, Integer> expected = new HashMap<Node, Integer>();
        BFS<Node> bfs = new BFS<Node>(g);
        assertEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithTwoNodesOneUndirectedEdgeShouldWork() {
        Graph<Node> g = new EdgeListsGraph<Node>();
        g.setUndirected(true);

        String[] values = new String[]{"v0", "v1"};
        List<Node> nodes = NodeFactory.createNodes(values);

        g.addEdge(nodes.get(0), nodes.get(1));
        Map<Node, Integer> expected = new HashMap<Node, Integer>();
        expected.put(nodes.get(0), 0);
        expected.put(nodes.get(1), 1);
        BFS<Node> bfs = new BFS<Node>(g);
        assertEquals(expected, bfs.step());
    }


    /*@Test
    public void BFSStepWithK33ShouldWork() {
        Graph<Node> g = new EdgeListsGraph<Node>();

        String[] values = new String[]{"v0", "v1", "v2", "v3", "v4", "v5"};
        List<Node> nodes = NodeFactory.createNodes(values);
        g.addEdge(nodes.get(0), nodes.get(3));
        g.addEdge(nodes.get(0), nodes.get(4));
        g.addEdge(nodes.get(0), nodes.get(5));
        g.addEdge(nodes.get(1), nodes.get(3));
        g.addEdge(nodes.get(1), nodes.get(4));
        g.addEdge(nodes.get(1), nodes.get(5));
        g.addEdge(nodes.get(2), nodes.get(3));
        g.addEdge(nodes.get(2), nodes.get(4));
        g.addEdge(nodes.get(2), nodes.get(5));

        Set<Node> expectedFirstStep = new HashSet<>();
        Set<Node> expectedSecondStep = new HashSet<>();
        Set<Node> expectedThirdStep = new HashSet<>();
        expectedFirstStep.add(nodes.get(0));
        expectedSecondStep.add(nodes.get(3));
        expectedSecondStep.add(nodes.get(4));
        expectedSecondStep.add(nodes.get(5));
        expectedThirdStep.add(nodes.get(1));
        expectedThirdStep.add(nodes.get(2));
        BFS<Node> bfs = new BFS<Node>(g);

        Map<Node, Integer> result = bfs.step();

        Set<Node> resultFirstStep = new HashSet<>();
        Set<Node> resultSecondStep = new HashSet<>();
        Set<Node> resultThirdStep = new HashSet<>();
        for(int i = 0;i<6; i++) {
            if(result.get(nodes.get(i)) == 0) {
                resultFirstStep.add(nodes.get(i));
            } else if(result.get(nodes.get(i)) <= 3) {
                resultSecondStep.add(nodes.get(i));
            } else {
                resultThirdStep.add(nodes.get(i));
            }
        }
        assertEquals(expectedFirstStep, resultFirstStep);
        assertEquals(expectedSecondStep, resultSecondStep);
        assertEquals(expectedThirdStep, resultThirdStep);
    }*/

    /*@Test
    public void BFSStepWithDisconnectedGraphShouldWork() {
        EdgeListsGraph g = new EdgeListsGraph(6);
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
