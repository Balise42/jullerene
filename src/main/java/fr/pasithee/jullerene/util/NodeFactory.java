package fr.pasithee.jullerene.util;

import java.util.ArrayList;
import java.util.List;

public class NodeFactory {
    public static Node createNode(String s) {
        return new Node(s);
    }

    public static List<Node> createNodes(String[] values) {
        List<Node> nodes = new ArrayList<Node>(values.length);
        for (String v : values) {
            nodes.add(createNode(v));
        }
        return nodes;
    }
}
