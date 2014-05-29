package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.Collection;
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
    
    protected PersonClassifier() {
    }

    @Override
    public Boolean process(Article article) {
        Collection<String> categories = article.getAnalysisResult(
            CategoryExtractor.getInstance());
        for (String category : categories) {
            if (category.contains("birth")) {
                return true;
            }
        }

        Boolean hasPersondata = article.getAnalysisResult(PersondataExtractor.
            getInstance());
        return hasPersondata;
    }

}
