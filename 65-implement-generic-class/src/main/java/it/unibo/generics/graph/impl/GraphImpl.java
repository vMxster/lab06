package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.VisitStrategy;

public class GraphImpl implements Graph<String> {

    private final Map<String, List<String>> adjList;
    private final Set<String> nodes;
    private final VisitStrategy visitStrategy;

    public GraphImpl (final Boolean visitStrategy) {
        this.nodes = new TreeSet<String>();
        this.adjList = new HashMap<>();
        if (visitStrategy) {
            this.visitStrategy = new BFS();
        } else {
            this.visitStrategy = new DFS();
        }
    }

    public void addNode(final String node) {
        this.nodes.add(node);
        this.adjList.put(node, new ArrayList<>());
    }

    public void addEdge(final String source, final String target) {
        if (!adjList.containsKey(source)) {
            addNode(source);
        }
        if (!adjList.containsKey(target)) {
            addNode(target);
        }
        adjList.get(source).add(target);
    }

    public Set<String> nodeSet() {
        final Set<String> setNode = new HashSet<>();
        for (final String i : this.nodes) {
            setNode.add(i);
        }
        return setNode;
    }

    public Set<String> linkedNodes(final String node) {       // Risolvi Problema per 2nd Test
        final Set<String> setNode = new HashSet<>();
        for (final String i : this.adjList.get(node)) {
            setNode.add(i);
        }
        return setNode;
    }

    public List<String> getPath(final String source, final String target) {
        return this.visitStrategy.path(this, source, target);
    }
    
}
