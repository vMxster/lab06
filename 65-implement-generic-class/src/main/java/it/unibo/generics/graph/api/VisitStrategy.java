package it.unibo.generics.graph.api;

import java.util.List;

public interface VisitStrategy {
    
    List<String> path(Graph<String> graph, String source, String target);

}
