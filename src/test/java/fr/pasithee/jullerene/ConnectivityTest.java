package fr.pasithee.jullerene;

import fr.pasithee.jullerene.algorithms.Connectivity;
import fr.pasithee.jullerene.algorithms.Traversal;
import fr.pasithee.jullerene.model.EdgeListsGraph;
import fr.pasithee.jullerene.util.Node;
import fr.pasithee.jullerene.util.NodeFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ConnectivityTest {
    @Mock
    private Traversal traversal;
    @Mock
    private EdgeListsGraph graph;
    @InjectMocks
    private Connectivity connectivity;

    private List<Node> nodes;
    private Map<Node, Integer> visited;

    @Before
    public void setup() {
        initMocks(this);
        nodes = NodeFactory.createNodes(new String[]{"v0", "v1", "v2"});
        visited = new HashMap<>();
        when(traversal.step()).thenReturn(visited);
        when(graph.getVertices()).thenReturn(nodes);
    }

    @Test
    public void isConnectedWithConnectedArrayShouldReturnTrue() {
        visited.put(nodes.get(0), 0);
        visited.put(nodes.get(1), 1);
        visited.put(nodes.get(2), 2);
        assertTrue(connectivity.isConnected());
    }

    @Test
    public void isConnectedWithDisconnectedArrayShouldReturnFalse() {
        visited.put(nodes.get(0), 0);
        visited.put(nodes.get(1), -1);
        visited.put(nodes.get(2), 1);
        assertFalse(connectivity.isConnected());
    }
}
