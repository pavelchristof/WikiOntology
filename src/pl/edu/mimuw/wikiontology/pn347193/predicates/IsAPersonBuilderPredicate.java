package pl.edu.mimuw.wikiontology.pn347193.predicates;

import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;
import pl.edu.mimuw.wikiontology.pn347193.analysis.PersonClassifier;
import pl.edu.mimuw.wikiontology.pn347193.relations.IsA;

/**
 * Checks if an entity is a person.
 */
public class IsAPersonBuilderPredicate implements BuilderPredicate {

    /**
     * Singleton reference of IsAPersonBuilderPredicate.
     */
    private static IsAPersonBuilderPredicate instance;

    /**
     * @return Singleton instance of IsAPersonBuilderPredicate.
     */
    public static IsAPersonBuilderPredicate getInstance() {
        if (instance == null) {
            instance = new IsAPersonBuilderPredicate();
        }
        return instance;
    }

    protected IsAPersonBuilderPredicate() {
    }

    @Override
    public boolean test(EntityBuilder builder) {
        builder.requireAnalysis(PersonClassifier.getInstance());
        return builder.getEntity().hasRelation(new IsA(Identifier.PERSON));
    }

}
