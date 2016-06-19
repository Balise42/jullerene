package fr.pasithee.jullerene;

import fr.pasithee.jullerene.model.EdgeListsGraph;
import fr.pasithee.jullerene.util.Node;
import fr.pasithee.jullerene.util.NodeFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EdgeListGraphTest {
    @Test
    public void hasEdgeWithUndirectedEdgesShouldReturnCorrectValues() {
        EdgeListsGraph<Node> graph = new EdgeListsGraph<>();
        List<Node> nodes =NodeFactory.createNodes(new String[]{"v0", "v1", "v2", "v3"});
        graph.addEdge(nodes.get(0), nodes.get(1));
        graph.addEdge(nodes.get(0), nodes.get(2));
        graph.addEdge(nodes.get(0), nodes.get(3));

        assertTrue(graph.hasEdge(nodes.get(0), nodes.get(1)));
        assertTrue(graph.hasEdge(nodes.get(0), nodes.get(2)));
        assertTrue(graph.hasEdge(nodes.get(0), nodes.get(3)));
        assertTrue(graph.hasEdge(nodes.get(1), nodes.get(0)));
        assertTrue(graph.hasEdge(nodes.get(2), nodes.get(0)));
        assertTrue(graph.hasEdge(nodes.get(3), nodes.get(0)));
        assertFalse(graph.hasEdge(nodes.get(1), nodes.get(2)));
        assertFalse(graph.hasEdge(nodes.get(1), nodes.get(3)));
        assertFalse(graph.hasEdge(nodes.get(2), nodes.get(1)));
        assertFalse(graph.hasEdge(nodes.get(2), nodes.get(3)));
        assertFalse(graph.hasEdge(nodes.get(3), nodes.get(1)));
        assertFalse(graph.hasEdge(nodes.get(3), nodes.get(2)));
    }

    @Test
    public void hasEdgeWithDirectedEdgesShouldReturnCorrectValues() {
        EdgeListsGraph<Node> graph = new EdgeListsGraph<>();
        graph.setDirected(true);
        List<Node> nodes = NodeFactory.createNodes(new String[]{"v0", "v1", "v2", "v3"});
        graph.addEdge(nodes.get(0), nodes.get(1));
        graph.addEdge(nodes.get(0), nodes.get(2));
        graph.addEdge(nodes.get(0), nodes.get(3));

        assertTrue(graph.hasEdge(nodes.get(0), nodes.get(1)));
        assertTrue(graph.hasEdge(nodes.get(0), nodes.get(2)));
        assertTrue(graph.hasEdge(nodes.get(0), nodes.get(3)));
        assertFalse(graph.hasEdge(nodes.get(1), nodes.get(0)));
        assertFalse(graph.hasEdge(nodes.get(2), nodes.get(0)));
        assertFalse(graph.hasEdge(nodes.get(3), nodes.get(0)));
        assertFalse(graph.hasEdge(nodes.get(1), nodes.get(2)));
        assertFalse(graph.hasEdge(nodes.get(1), nodes.get(3)));
        assertFalse(graph.hasEdge(nodes.get(2), nodes.get(1)));
        assertFalse(graph.hasEdge(nodes.get(2), nodes.get(3)));
        assertFalse(graph.hasEdge(nodes.get(3), nodes.get(1)));
        assertFalse(graph.hasEdge(nodes.get(3), nodes.get(2)));
    }

}
