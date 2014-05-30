package pl.edu.mimuw.wikiontology.pn347193.graph;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import pl.edu.mimuw.wikiontology.pn347193.Entity;
import pl.edu.mimuw.wikiontology.pn347193.Ontology;

public class Graph {

    private final Entity[] vertices;
    private final HashMap<Entity, Collection<Entity>> edges;

    /**
     * Creates a graph from an ontology using an edge extractor.
     *
     * @param ontology the ontology
     * @param edgeExtractor the edge extractor
     */
    public Graph(Ontology ontology, EdgeExtractor edgeExtractor) {
        Collection<Entity> entities = ontology.getEntities();
        vertices = entities.toArray(new Entity[entities.size()]);
        edges = new HashMap<>();

        for (Entity vertex : vertices) {
            edges.put(vertex, edgeExtractor.extract(vertex));
        }
    }

    /**
     * Finds a shortest path between two vertices.
     *
     * @param from the starting vertex
     * @param to the ending vertex
     * @return a list of all vertices on the path or null if there is no path.
     */
    public List<Entity> shortestPath(Entity from, Entity to) {
        // Perform BFS saving predecessors.
        GraphSearch search = new GraphSearch(from);
        Queue<Entity> queue = new ArrayDeque<>();

        queue.add(from);
        while (!queue.isEmpty()) {
            Entity vertex = queue.poll();

            // End if we find the destination.
            if (vertex == to) {
                break;
            }

            // Skip the vertex if we visited it before.
            if (search.isVisited(vertex)) {
                continue;
            }

            // Visit all unvisited neighbours.
            for (Entity neighbour : edges.get(vertex)) {
                if (!search.isVisited(neighbour)) {
                    search.visit(vertex, neighbour);
                    queue.add(neighbour);
                }
            }
        }

        return search.rebuildPath(to);
    }

}
