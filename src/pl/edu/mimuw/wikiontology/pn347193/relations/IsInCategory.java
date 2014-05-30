package pl.edu.mimuw.wikiontology.pn347193.relations;

import pl.edu.mimuw.wikiontology.pn347193.Identifier;

/**
 * Models an "is in category" relation.
 */
public final class IsInCategory extends AbstractRelation {

    public IsInCategory(Identifier target) {
        super(target);
    }

    @Override
    public String toString() {
        return "is in category " + getTarget().toString();
    }

}
