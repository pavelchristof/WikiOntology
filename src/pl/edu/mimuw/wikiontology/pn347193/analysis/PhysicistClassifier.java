package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.Set;
import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;
import pl.edu.mimuw.wikiontology.pn347193.relations.IsA;
import pl.edu.mimuw.wikiontology.pn347193.relations.IsInCategory;

/**
 * Decides if an article is about a physicist.
 */
public class PhysicistClassifier implements Analysis {

    /**
     * Singleton reference of PhysicistClassifier.
     */
    private static PhysicistClassifier instance;

    /**
     * @return Singleton instance of PhysicistClassifier.
     */
    public static PhysicistClassifier getInstance() {
        if (instance == null) {
            instance = new PhysicistClassifier();
        }
        return instance;
    }

    protected PhysicistClassifier() {
    }

    private boolean isAPhysicist(EntityBuilder builder) {
        // A physicist must be a person.
        builder.requireAnalysis(PersonClassifier.getInstance());
        if (!builder.getEntity().hasRelation(new IsA(Identifier.PERSON))) {
            return false;
        }

        // Check categories.
        builder.requireAnalysis(CategoryExtractor.getInstance());
        Set<IsInCategory> categories = builder.getEntity().getRelationsOfClass(
            IsInCategory.class);
        for (IsInCategory cat : categories) {
            if (cat.getTarget().toString().contains("physicist")) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void process(EntityBuilder builder) {
        if (isAPhysicist(builder)) {
            builder.getEntity().addRelation(new IsA(Identifier.PHYSICIST));
        }
    }

}
