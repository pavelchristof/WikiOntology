package pl.edu.mimuw.wikiontology.pn347193.graph;

import java.util.HashSet;
import pl.edu.mimuw.wikiontology.pn347193.Entity;

public interface EdgeExtractor {
   
    /**
     * Extracts all edges coming out of an vertex.
     * @param vertex the vertex (that is, the entity)
     * @return a hash set of entities representing vertices.
     */
    HashSet<Entity> extract(Entity vertex);
    
}
