package it.unibo.generics.graph.api;

import java.util.List;

public interface VisitStrategy {
    
    List<String> path(final Graph<String> graph, final String source, final String target);

}
