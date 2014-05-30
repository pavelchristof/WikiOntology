package pl.edu.mimuw.wikiontology.pn347193.predicates;

import pl.edu.mimuw.wikiontology.pn347193.Entity;
import pl.edu.mimuw.wikiontology.pn347193.relations.Relation;

public class HasARelationPredicate implements Predicate<Entity> {

    private final Relation relation;

    public HasARelationPredicate(Relation relation) {
        this.relation = relation;
    }

    @Override
    public boolean test(Entity entity) {
        return entity.hasRelation(relation);
    }

}
