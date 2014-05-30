package pl.edu.mimuw.wikiontology.pn347193.filters;

import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;
import pl.edu.mimuw.wikiontology.pn347193.analysis.PersonClassifier;
import pl.edu.mimuw.wikiontology.pn347193.relations.IsA;

/**
 * Filters out non-persons.
 */
public class PersonFilter implements ArticleFilter {

    /**
     * Singleton reference of PersonFilter.
     */
    private static PersonFilter instance;

    /**
     * @return Singleton instance of PersonFilter.
     */
    public static PersonFilter getInstance() {
        if (instance == null) {
            instance = new PersonFilter();
        }
        return instance;
    }

    protected PersonFilter() {
    }

    @Override
    public boolean filter(EntityBuilder builder) {
        builder.requireAnalysis(PersonClassifier.getInstance());
        return !builder.getEntity().hasRelation(new IsA(Identifier.PERSON));
    }

}
