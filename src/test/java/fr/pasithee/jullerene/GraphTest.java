package fr.pasithee.jullerene;

import fr.pasithee.jullerene.model.Graph;
import fr.pasithee.jullerene.model.Vertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    @Test
    public void hasEdgeWithUndirectedEdgesShouldReturnCorrectValues() {
        Graph g = new Graph(4);
        g.addUndirectedEdge(g.get(0), g.get(1));
        g.addUndirectedEdge(g.get(0), g.get(2));
        g.addUndirectedEdge(g.get(0), g.get(3));

        assertTrue(g.hasEdge(g.get(0), g.get(1)));
        assertTrue(g.hasEdge(g.get(0), g.get(2)));
        assertTrue(g.hasEdge(g.get(0), g.get(3)));
        assertTrue(g.hasEdge(g.get(1), g.get(0)));
        assertTrue(g.hasEdge(g.get(2), g.get(0)));
        assertTrue(g.hasEdge(g.get(3), g.get(0)));
        assertFalse(g.hasEdge(g.get(1), g.get(2)));
        assertFalse(g.hasEdge(g.get(1), g.get(3)));
        assertFalse(g.hasEdge(g.get(2), g.get(1)));
        assertFalse(g.hasEdge(g.get(2), g.get(3)));
        assertFalse(g.hasEdge(g.get(3), g.get(1)));
        assertFalse(g.hasEdge(g.get(3), g.get(2)));
    }

    @Test
    public void hasEdgeWithDirectedEdgesShouldReturnCorrectValues() {
        Graph g = new Graph(4);
        g.addDirectedEdge(g.get(0), g.get(1));
        g.addDirectedEdge(g.get(0), g.get(2));
        g.addDirectedEdge(g.get(0), g.get(3));

        assertTrue(g.hasEdge(g.get(0), g.get(1)));
        assertTrue(g.hasEdge(g.get(0), g.get(2)));
        assertTrue(g.hasEdge(g.get(0), g.get(3)));
        assertFalse(g.hasEdge(g.get(1), g.get(0)));
        assertFalse(g.hasEdge(g.get(2), g.get(0)));
        assertFalse(g.hasEdge(g.get(3), g.get(0)));
        assertFalse(g.hasEdge(g.get(1), g.get(2)));
        assertFalse(g.hasEdge(g.get(1), g.get(3)));
        assertFalse(g.hasEdge(g.get(2), g.get(1)));
        assertFalse(g.hasEdge(g.get(2), g.get(3)));
        assertFalse(g.hasEdge(g.get(3), g.get(1)));
        assertFalse(g.hasEdge(g.get(3), g.get(2)));
    }

    @Test
    public void insertDirectedEdgeWithVertexNumberShouldWork() {
        Graph g = new Graph(3);
        g.addDirectedEdge(0, 1);
        g.addDirectedEdge(1, 2);
        Graph expected = new Graph(3);
        expected.addDirectedEdge(expected.get(0), expected.get(1));
        expected.addDirectedEdge(expected.get(1), expected.get(2));
        assertEquals(expected, g);
    }

    @Test
    public void insertUndirectedEdgeWithVertexNumberShouldWork() {
        Graph g = new Graph(3);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(1, 2);
        Graph expected = new Graph(3);
        expected.addUndirectedEdge(expected.get(0), expected.get(1));
        expected.addUndirectedEdge(expected.get(1), expected.get(2));
        assertEquals(expected, g);
    }

    @Test
    public void getVertexWithVertexNumberShouldWork() {
        Graph g = new Graph(3);
        Vertex result = g.get(1);
        assertEquals(1, result.getLabel());
    }

    @Test(expected=IllegalArgumentException.class)
    public void getVertexWithInvalidValueShouldThrow() {
        Graph g = new Graph(3);
        g.get(4);
    }

    @Test(expected=IllegalArgumentException.class)
    public void addDirectedEdgeWithInvalidVertexShouldThrow() {
        Graph g = new Graph(3);
        Vertex v = new Vertex(4);
        g.addDirectedEdge(v, v);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLoopUndirectedVertexEdgeShouldThrow() {
        Graph g = new Graph(3);
        g.addUndirectedEdge(g.get(0), g.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLoopDirectedVertexEdgeShouldThrow() {
        Graph g = new Graph(3);
        g.addDirectedEdge(g.get(0), g.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLoopUndirectedIntEdgeShouldThrow() {
        Graph g = new Graph(3);
        g.addUndirectedEdge(0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLoopDirectedIntEdgeShouldThrow() {
        Graph g = new Graph(3);
        g.addDirectedEdge(0,0);
    }
}
