package pl.edu.mimuw.wikiontology.pn347193.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import pl.edu.mimuw.wikiontology.pn347193.Entity;

/**
 * An utility class for graph searches, helps with tracking visited vertices and
 * path rebuilding.
 */
class GraphSearch {

    private final HashMap<Entity, Entity> predecessors;
    private final Entity startingVertex;

    public GraphSearch(Entity startingVertex) {
        this.predecessors = new HashMap<>();
        this.predecessors.put(startingVertex, null);
        this.startingVertex = startingVertex;
    }

    public Entity getStartingVertex() {
        return startingVertex;
    }

    public Entity getPredecessor(Entity vertex) {
        return predecessors.get(vertex);
    }
    
    public boolean isVisited(Entity vertex) {
        return predecessors.containsKey(vertex);
    }
    
    public void visit(Entity predecessor, Entity vertex) {
        predecessors.put(vertex, predecessor);
    }

    public List<Entity> rebuildPath(Entity endingVertex) {
        List<Entity> path = new ArrayList<>();
        
        // If the vertex hasn't been visited then there is no path.
        if (!isVisited(endingVertex))
            return path;
    
        // Construct the path backwards.
        Entity vertex = endingVertex;
        while (vertex != null) {
            path.add(vertex);
            vertex = predecessors.get(vertex);
        }
        
        // Return the reversed path.
        Collections.reverse(path);
        return path;
    }
}
