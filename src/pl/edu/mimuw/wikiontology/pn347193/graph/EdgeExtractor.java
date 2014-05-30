package pl.edu.mimuw.wikiontology.pn347193.graph;

import java.util.HashSet;
import pl.edu.mimuw.wikiontology.pn347193.Entity;
import pl.edu.mimuw.wikiontology.pn347193.Ontology;

public interface EdgeExtractor {

    /**
     * Extracts all edges coming out of an vertex.
     *
     * @param ontology ontology that @a vertex belongs to.
     * @param vertex the vertex (that is, the entity)
     * @return a hash set of entities representing vertices.
     */
    HashSet<Entity> extract(Ontology ontology, Entity vertex);

}
