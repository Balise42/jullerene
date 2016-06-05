package fr.pasithee.jullerene.model;

import java.util.List;
import java.util.Set;

public abstract class Graph<T> {
    private boolean allowMultiedges;
    private boolean directed = false;

    public abstract void addNode(T node);
    public abstract void deleteNode(T node);
    public abstract boolean hasNode(T node);
    public abstract boolean hasEdge(T node1, T node2);
    public abstract void addEdge(T node1, T node2);
    public abstract List<Edge<T>> getEdges(T node);
    public abstract List<Edge<T>> getOutEdges(T node);
    public abstract List<Edge<T>> getInEdges(T node);
    public abstract List<T> getNeighbors(T node);

    public boolean shouldAddEdge(T node1, T node2) {
        return allowMultiedges || !hasEdge(node1, node2);
    }

    public boolean isAllowMultiedges() {
        return allowMultiedges;
    }

    public void setAllowMultiEdges(boolean allowMultiedges) {
        this.allowMultiedges = allowMultiedges;
    }

    public boolean isDirected() {
        return this.directed;
    }

    public void setUndirected(boolean directed) {
        this.directed = directed;
    }


    public abstract List<T> getVertices();
}
