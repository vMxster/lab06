package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import java.util.Map;
import java.util.HashMap;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.VisitStrategy;

public class DFS implements VisitStrategy{

    public List<String> path(final Graph<String> graph, final String source, final String target) {
        final Stack<String> stack = new Stack<String>();
        final Map<String,Boolean> visited = new HashMap<String,Boolean>(graph.nodeSet().size());
        mapInitialiser(graph,visited);
        final List<String> path = new ArrayList<String>();
        String tempNode;
        visited.put(source, true);
        stack.push(source);
    
        while (!isEmpty(stack)) {
            tempNode = stack.pop();
            path.add(tempNode);

            if(tempNode.equals(target)) {
                return path;
            }
    
            for (String i : graph.linkedNodes(tempNode)) {
                if(!visited.get(i)){
                    visited.put(i,true);
                    stack.push(i);
                }
            }
        }
        return path;
    }

    private void mapInitialiser(final Graph<String> graph, final Map<String, Boolean> visited) {
        final Set<String> setNode = graph.nodeSet();
        for (String i : setNode) {
            visited.put(i, false);
        }
    }

    private Boolean isEmpty(final Stack<String> stack) {
        return stack.size() == 0;
    }

}
