package fr.pasithee.jullerene.algorithms;

import fr.pasithee.jullerene.model.Graph;

import static fr.pasithee.jullerene.model.Constants.NOT_VISITED;

public abstract class Traversing {
    protected final Graph graph;

    public Traversing(Graph graph) {
        this.graph = graph;
    }

    public int[] traversal() {
        int[] visitOrder = step();
        while(!isFullyTraversed(visitOrder)) {
            visitOrder = step(visitOrder);
        }
        return visitOrder;
    }

    private boolean isFullyTraversed(int[] visitOrder) {
        for(int visited :visitOrder) {
            if(visited == NOT_VISITED) {
                return false;
            }
        }
        return true;
    }

    protected abstract int[] step(int[] visitOrder);

    public int[] step() {
        int[] visitOrder = new int[graph.getNbVertices()];
        for(int i = 0; i< graph.getNbVertices(); i++) {
            visitOrder[i] = NOT_VISITED;
        }
        return step(visitOrder);
    }

}
