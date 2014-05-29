package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.Set;
import pl.edu.mimuw.wikiontology.pn347193.Article;

/**
 * Decides if an article is about a person.
 *
 * Dependencies: CategoryExtractor, PersondataExtractor. 
 * Result: whether the article is about a person.
 */
public class PersonClassifier implements Analysis<Boolean> {

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

    @Override
    public Boolean process(Article article) {
        Set<String> categories = article.getAnalysisResult(
            CategoryExtractor.getInstance());
        for (String category : categories) {
            for (String s : searchFor) {
                if (category.contains(s)) {
                    return true;
                }
            }
        }

        Boolean hasPersondata = article.getAnalysisResult(PersondataFinder.
            getInstance());
        return hasPersondata;
    }

}
