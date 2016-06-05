package fr.pasithee.jullerene.model;

import java.util.*;

/**
 *  EdgeListsGraph model, no multi-edges, no loops.
 */
public class EdgeListsGraph<T> extends Graph<T> {
    /** Edges of the graph, sorted by the vertex they're adjacent to */
    private final List<Edge<T>> edges;

    /** Creates an empty graph. */
    public EdgeListsGraph() {
        edges = new ArrayList<>();
    }

    @Override
    public void addNode(T node) {
        return;
    }

    @Override
    public void deleteNode(T node) {
        List<Edge<T>> edgeCopy = new ArrayList<Edge<T>>();

        for (Edge<T> e : edges) {
            edgeCopy.add(e);
        }

        for (Edge<T> e : edgeCopy) {
            if (e.hasEndPoint(node)) {
                edges.remove(e);
            }
        }
    }

    @Override
    public boolean hasNode(T node) {
        for (Edge<T> e : edges) {
            if (e.hasEndPoint(node)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasEdge(T node1, T node2) {
        for (Edge<T> e : edges) {
            if (e.isBetween(node1, node2, isDirected())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addEdge(T node1, T node2) {
        Edge<T> e = new Edge<T>(node1, node2);
        boolean shouldAddEdge = shouldAddEdge(node1, node2);
        if (shouldAddEdge) {
            edges.add(e);
        }
    }

    @Override
    public List<Edge<T>> getEdges(T node) {
        List<Edge<T>> res = new ArrayList<>();
        for (Edge<T> e : edges) {
            if (e.hasEndPoint(node)) {
                res.add(e);
            }
        }
        return res;
    }

    @Override
    public List<Edge<T>> getOutEdges(T node) {
        List<Edge<T>> res = new ArrayList<>();
        for (Edge<T> e : edges) {
            if (e.hasFirstEndpoint(node) || (!isDirected() && e.hasEndPoint(node))) {
                res.add(e);
            }
        }
        return res;
    }

    @Override
    public List<Edge<T>> getInEdges(T node) {
        List<Edge<T>> res = new ArrayList<>();
        for (Edge<T> e : edges) {
            if (e.hasSecondEndpoint(node) || (!isDirected() && e.hasEndPoint(node))) {
                res.add(e);
            }
        }
        return res;
    }

    @Override
    public List<T> getNeighbors(T node) {
        List<T> neighbors = new ArrayList<T>();
        for (Edge<T> e : getOutEdges(node)) {
            neighbors.add(e.getOtherEnd(node));
        }
        return neighbors;
    }

    @Override
    public List<T> getVertices() {
        List<T> vertices = new ArrayList<T>();
        for (Edge<T> e : edges) {
            for (T node : e.getVertices()) {
                if (!vertices.contains(node))
                vertices.add(node);
            }
        }
        return vertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdgeListsGraph graph = (EdgeListsGraph) o;
        return Objects.equals(edges, graph.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edges);
    }
}
