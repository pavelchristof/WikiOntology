package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.Set;
import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;
import pl.edu.mimuw.wikiontology.pn347193.relations.HasA;
import pl.edu.mimuw.wikiontology.pn347193.relations.IsA;
import pl.edu.mimuw.wikiontology.pn347193.relations.IsInCategory;

/**
 * Decides if an article is about a person.
 */
public class PersonClassifier implements Analysis {

    /**
     * Singleton reference of PersonClassifier.
     */
    private static PersonClassifier instance;

    /**
     * @return Singleton instance of PersonClassifier.
     */
    public static PersonClassifier getInstance() {
        if (instance == null) {
            instance = new PersonClassifier();
        }
        return instance;
    }

    private final String[] searchFor;

    protected PersonClassifier() {
        searchFor = new String[] {"births", "deaths"};
    }

    private boolean isAPerson(EntityBuilder builder) {
        // First look for a persondata template.
        builder.requireAnalysis(PersondataFinder.getInstance());
        if (builder.getEntity().hasRelation(new HasA(Identifier.PERSONDATA))) {
            return true;
        }

        // Search categories.
        builder.requireAnalysis(CategoryExtractor.getInstance());
        Set<IsInCategory> categories = builder.getEntity().getRelationsOfClass(
            IsInCategory.class);
        for (IsInCategory cat : categories) {
            for (String s : searchFor) {
                if (cat.getTarget().toString().contains(s)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void process(EntityBuilder builder) {
        if (isAPerson(builder)) {
            builder.getEntity().addRelation(new IsA(Identifier.PERSON));
        }
    }

}
