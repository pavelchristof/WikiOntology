package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.Set;
import pl.edu.mimuw.wikiontology.pn347193.Article;

/**
 * Decides if an article is about a physicist.
 *
 * Dependencies: CategoryExtractor, PersonClassifier. 
 * Result: whether the article is about a physicist.
 */
public class PhysicistClassifier implements Analysis<Boolean> {

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

    @Override
    public Boolean process(Article article) {
        boolean isPerson = article.getAnalysisResult(PersonClassifier.
            getInstance());
        if (!isPerson) {
            return false;
        }

        Set<String> categories = article.getAnalysisResult(CategoryExtractor.
            getInstance());
        for (String category : categories) {
            if (category.contains("physicist")) {
                return true;
            }
        }

        return false;
    }

}
