package pl.edu.mimuw.wikiontology.pn347193.relations;

import pl.edu.mimuw.wikiontology.pn347193.Identifier;

/**
 * Models an "is a" relations. For example "Albert Einstein" IsA "Person".
 */
public final class IsA extends AbstractRelation {

    public IsA(Identifier target) {
        super(target);
    }

    @Override
    public String toString() {
        return "is a " + getTarget().toString();
    }

}
