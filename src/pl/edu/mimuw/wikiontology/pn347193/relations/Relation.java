package pl.edu.mimuw.wikiontology.pn347193.relations;

import pl.edu.mimuw.wikiontology.pn347193.Identifier;

/**
 * Models a relation between two entities.
 */
public interface Relation {

    /**
     * @return the target for this relation
     */
    Identifier getTarget();

}
