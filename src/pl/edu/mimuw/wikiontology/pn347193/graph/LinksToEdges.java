package pl.edu.mimuw.wikiontology.pn347193.graph;

import java.util.HashSet;
import pl.edu.mimuw.wikiontology.pn347193.Entity;
import pl.edu.mimuw.wikiontology.pn347193.Ontology;
import pl.edu.mimuw.wikiontology.pn347193.relations.LinksTo;

/**
 * Extracts edges from wiki links.
 */
public class LinksToEdges implements EdgeExtractor {

    @Override
    public HashSet<Entity> extract(Ontology ontology, Entity vertex) {
        HashSet<Entity> entities = new HashSet<>();
        
        for (LinksTo link : vertex.getRelationsOfClass(LinksTo.class)) {
            Entity entity = ontology.getEntity(link.getTarget());
            if (entity != null) {
                entities.add(entity);
            }
        }
        
        return entities;
    }

}
