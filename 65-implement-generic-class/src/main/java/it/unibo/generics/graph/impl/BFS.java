package it.unibo.generics.graph.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Queue;

import java.util.Map;
import java.util.HashMap;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.VisitStrategy;

public class BFS implements VisitStrategy{

    public List<String> path(Graph<String> graph, String source, String target) {
        final Queue<String> queue = new ArrayDeque<String>();
        final Map<String,Boolean> visited = new HashMap<String,Boolean>(graph.nodeSet().size());
        mapInitialiser(graph,visited);
        final List<String> path = new ArrayList<String>();
        String tempNode;
        visited.put(source, true);
        queue.add(source);
    
        while (!isEmpty(queue)) {
            tempNode = queue.poll();
            path.add(tempNode);

            if(tempNode.equals(target)) {
                return path;
            }
    
            for (String i : graph.linkedNodes(tempNode)) {
                if(!visited.get(i)){
                    visited.put(i,true);
                    queue.add(i);
                }
            }
        }
        return path;
    }

    private void mapInitialiser(Graph<String> graph, Map<String, Boolean> visited) {
        Set<String> setNode = graph.nodeSet();
        for (String i : setNode) {
            visited.put(i, false);
        }
    }

    private Boolean isEmpty(Queue<String> queue) {
        return queue.size() == 0;
    }

}
