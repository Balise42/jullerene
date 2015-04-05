package fr.pasithee.jullerene.model;

import java.util.*;

public class Graph {
    private final int nb_vertices;
    private final List<Vertex> vertices;
    private final Map<Vertex, Set<Edge>> edges;

    public Graph(int nb_vertices) {
        this.nb_vertices = nb_vertices;
        vertices = new ArrayList<>(nb_vertices);
        edges = new HashMap<>();
        for (int i = 0; i < nb_vertices; i++) {
            Vertex v = new Vertex(i);
            vertices.add(v);
            edges.put(v, new HashSet<Edge>());
        }
    }

    public Vertex get(int i) {
        validateVertex(i);
        return vertices.get(i);
    }

    public void addDirectedEdge(Vertex source, Vertex target) {
        validateVertex(source);
        validateVertex(target);
        if(source.equals(target)) {
            throw new IllegalArgumentException("Edges cannot have twice the same endpoint.");
        }
        addEdge(source, target);
    }

    public void addDirectedEdge(int source, int target) {
        validateVertex(source);
        validateVertex(target);
        if(source == target) {
            throw new IllegalArgumentException("Edges cannot have twice the same endpoint.");
        }
        addEdge(vertices.get(source), vertices.get(target));
    }

    public void addUndirectedEdge(int v1, int v2) {
        validateVertex(v1);
        validateVertex(v2);
        if(v1 == v2) {
            throw new IllegalArgumentException("Edges cannot have twice the same endpoint.");
        }
        addEdge(vertices.get(v1), vertices.get(v2));
        addEdge(vertices.get(v2), vertices.get(v1));
    }

    public void addUndirectedEdge(Vertex v1, Vertex v2) {
        validateVertex(v1);
        validateVertex(v2);
        if(v1.equals(v2)) {
            throw new IllegalArgumentException("Edges cannot have twice the same endpoint.");
        }
        addEdge(v1, v2);
        addEdge(v2, v1);
    }

    private void addEdge(Vertex source, Vertex target) {
        edges.get(source).add(new Edge(source, target));
    }

    public Collection<Edge> getAdjacentEdges(Vertex v) {
        return edges.get(v);
    }

    public boolean hasEdge(Vertex v1, Vertex v2) {
        return getAdjacentEdges(v1).contains(new Edge(v1, v2));
    }

    private void validateVertex(Vertex v) {
        if (!vertices.contains(v)) {
            throw new IllegalArgumentException("An operation has been requested on a vertex that is not in the graph.");
        }
    }

    private void validateVertex(int i) {
        if (i >= nb_vertices) {
            throw new IllegalArgumentException("You asked for vertex " + i + " but graph only has " + nb_vertices + "vertices.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Objects.equals(nb_vertices, graph.nb_vertices) &&
                Objects.equals(vertices, graph.vertices) &&
                Objects.equals(edges, graph.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nb_vertices, vertices, edges);
    }
}
