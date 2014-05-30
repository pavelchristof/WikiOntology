package pl.edu.mimuw.wikiontology.pn347193.relations;

import pl.edu.mimuw.wikiontology.pn347193.Identifier;

/**
 * Models a "links to" relation.
 */
public final class LinksTo extends AbstractRelation {

    public LinksTo(Identifier target) {
        super(target);
    }

    @Override
    public String toString() {
        return "links to " + getTarget().toString();
    }

}
