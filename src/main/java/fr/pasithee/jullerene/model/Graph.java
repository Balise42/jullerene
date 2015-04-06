package fr.pasithee.jullerene.model;

import java.util.*;

/**
 *  Graph model, no multi-edges, no loops.
 */
public class Graph {
    /** Number of vertices */
    private final int nbVertices;
    /** List of all vertices */
    private final List<Vertex> vertices;
    /** Edges of the graph, sorted by the vertex they're adjacent to */
    private final Map<Vertex, Set<Edge>> edges;

    /** Creates a graph and all its vertices, no edges.
     * @param nbVertices number of vertices of the graph
     * */
    public Graph(int nbVertices) {
        this.nbVertices = nbVertices;
        vertices = new ArrayList<>(nbVertices);
        edges = new HashMap<>();
        for (int i = 0; i < nbVertices; i++) {
            Vertex v = new Vertex(i);
            vertices.add(v);
            edges.put(v, new HashSet<Edge>());
        }
    }

    /** Returns the ith vertex of the graph. */
    public Vertex get(int i) {
        validateVertex(i);
        return vertices.get(i);
    }

    /** Add a directed edge from source to target
     * @param source source of the edge (must be different from target)
     * @param target target of the edge (must be different from source)
     * */
    public void addDirectedEdge(Vertex source, Vertex target) {
        validateVertex(source);
        validateVertex(target);
        if(source.equals(target)) {
            throw new IllegalArgumentException("Edges cannot have twice the same endpoint.");
        }
        addEdge(source, target);
    }

    /** Add a directed edge from the source-th vertex to the target-th vertex
     * @param source index of the source vertex for the new edge (must be different from target)
     * @param target index of the target vertex for the new edge (must be different from source)
     * */
    public void addDirectedEdge(int source, int target) {
        validateVertex(source);
        validateVertex(target);
        if(source == target) {
            throw new IllegalArgumentException("Edges cannot have twice the same endpoint.");
        }
        addEdge(vertices.get(source), vertices.get(target));
    }

    /** Adds an undirected edge between v1-th and v2-th vertices.
     * @param v1 index of the first vertex for the new edge (must be different from v2)
     * @param v2 index of the second vertex for the new edge (must be different from v1)
     * */
    public void addUndirectedEdge(int v1, int v2) {
        validateVertex(v1);
        validateVertex(v2);
        if(v1 == v2) {
            throw new IllegalArgumentException("Edges cannot have twice the same endpoint.");
        }
        addEdge(vertices.get(v1), vertices.get(v2));
        addEdge(vertices.get(v2), vertices.get(v1));
    }

    /** Adds an undirected edge between v1 and v2.
     * @param v1 first vertex for the new edge (must be different from v2)
     * @param v2 second vertex for the new edge (must be different from v1)
     * */
    public void addUndirectedEdge(Vertex v1, Vertex v2) {
        validateVertex(v1);
        validateVertex(v2);
        if(v1.equals(v2)) {
            throw new IllegalArgumentException("Edges cannot have twice the same endpoint.");
        }
        addEdge(v1, v2);
        addEdge(v2, v1);
    }

    /** Adds edge between vertex source and target
     * @param source source of the edge (PRE: is a valid vertex in the graph)
     * @param target target of the edge (PRE: is a valid vertex in the graph) */
    private void addEdge(Vertex source, Vertex target) {
        edges.get(source).add(new Edge(source, target));
    }

    /** Returns the edges adjacent to a vertex
     * @param v vertex whose adjacent edges are wanted
     * @return edges adjacents to v */
    public Collection<Edge> getAdjacentEdges(Vertex v) {
        return edges.get(v);
    }

    /** Checks if two vertices are joined by an edge
     * @param v1 first vertex of the desired edge
     * @param v2 second vertex of the desired edge
     * @return true if (v1, v2) is an edge in the graph, false otherwise */
    public boolean hasEdge(Vertex v1, Vertex v2) {
        return getAdjacentEdges(v1).contains(new Edge(v1, v2));
    }

    /** Checks if the given vertex is a vertex of the graph
     * @param v the vertex to check
     * @throws IllegalArgumentException if the vertex is not in the graph */
    private void validateVertex(Vertex v) {
        if (!vertices.contains(v)) {
            throw new IllegalArgumentException("An operation has been requested on a vertex that is not in the graph.");
        }
    }

    /** Checks if the given index is a valid vertex index in the graph
     * @param i the index to check
     * @throws IllegalArgumentException if the vertex is not in the graph */
    private void validateVertex(int i) {
        if (i >= nbVertices) {
            throw new IllegalArgumentException("You asked for vertex " + i + " but graph only has " + nbVertices + "vertices.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Objects.equals(nbVertices, graph.nbVertices) &&
                Objects.equals(vertices, graph.vertices) &&
                Objects.equals(edges, graph.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbVertices, vertices, edges);
    }

    public int getNbVertices() {
        return nbVertices;
    }
}
