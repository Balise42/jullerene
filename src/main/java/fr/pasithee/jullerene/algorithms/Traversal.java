package fr.pasithee.jullerene.algorithms;

import fr.pasithee.jullerene.model.EdgeListsGraph;
import fr.pasithee.jullerene.model.Graph;

import java.util.HashMap;
import java.util.Map;

import static fr.pasithee.jullerene.model.Constants.NOT_VISITED;

/** Traversal */
public abstract class Traversal<T> {
    protected final Graph<T> graph;
    protected int lastVisited = -1;

    public Traversal(Graph<T> graph) {
        this.graph = graph;
    }

    public Map<T, Integer> traversal() {
        Map<T, Integer> visitOrder = step();
        while(!isFullyTraversed(visitOrder)) {
            visitOrder = step(visitOrder);
        }
        return visitOrder;
    }

    private boolean isFullyTraversed(Map<T, Integer> visitOrder) {
        for(int visited : visitOrder.values()) {
            if(visited == NOT_VISITED) {
                return false;
            }
        }
        return true;
    }

    protected abstract Map<T, Integer> step(Map<T, Integer> visitOrder);

    public Map<T, Integer> step() {
        lastVisited = -1;
        Map<T, Integer> visitOrder = new HashMap<T, Integer>();
        for(T n : graph.getVertices()) {
            visitOrder.put(n, NOT_VISITED);
        }
        return step(visitOrder);
    }

}
