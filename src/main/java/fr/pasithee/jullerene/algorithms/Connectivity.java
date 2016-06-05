package fr.pasithee.jullerene.algorithms;

import fr.pasithee.jullerene.model.EdgeListsGraph;
import fr.pasithee.jullerene.model.Constants;
import fr.pasithee.jullerene.model.Graph;

import java.util.Map;

/** Connectivity algorithms for {@link EdgeListsGraph}*/
public class Connectivity<T> {
    /** EdgeListsGraph to which the algorithms can be applied. */
    private final Graph<T> g;
    /** Traversal algorithm for the connectivity algorithm */
    private final Traversal traversal;

    /** Constructor.
     * @param g graph to which the algorithms can be applied
     * @param traversal traversal algorithm used by connectivity algorithms */
    public Connectivity(Graph<T> g, Traversal traversal) {
        this.g = g;
        this.traversal = traversal;
    }

    /** Checks connectivity of the graph
     * @return true if the graph is connected, false otherwise */
    public boolean isConnected() {
        Map<T, Integer> visitOrder = traversal.step();
        for(T node : g.getVertices()) {
            if(visitOrder.get(node) ==  Constants.NOT_VISITED) {
                return false;
            }
        }
        return true;
    }
}
