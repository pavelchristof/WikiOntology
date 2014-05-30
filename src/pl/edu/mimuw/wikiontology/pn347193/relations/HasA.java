package pl.edu.mimuw.wikiontology.pn347193.relations;

import pl.edu.mimuw.wikiontology.pn347193.Identifier;

/**
 * Models a "has a" relation.
 */
public class HasA extends AbstractRelation {

    public HasA(Identifier target) {
        super(target);
    }

    @Override
    public String toString() {
        return "has a " + getTarget().toString();
    }

}
