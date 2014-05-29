package pl.edu.mimuw.wikiontology.pn347193.filters;

import pl.edu.mimuw.wikiontology.pn347193.Article;
import pl.edu.mimuw.wikiontology.pn347193.analysis.PersonClassifier;

/**
 * Filters out non-persons.
 * 
 * Dependencies: PersonClassifier.
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
    public boolean filter(Article article) {
        return !article.getAnalysisResult(PersonClassifier.getInstance());
    }

}
