package fr.pasithee.jullerene.util;

import java.util.Objects;

public class Node {
    private String value;
    public Node(String v) {
        this.value = v;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node n = (Node) o;
        return Objects.equals(value, n.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
