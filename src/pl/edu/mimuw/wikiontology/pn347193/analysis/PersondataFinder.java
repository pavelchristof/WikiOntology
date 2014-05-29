package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.List;
import pl.edu.mimuw.wikiontology.pn347193.Article;

/**
 * Finds Persondata metadata in a wiki article.
 *
 * Dependencies: TemplateExtractor. 
 * Result: whether the article contains a Persondata template.
 */
public class PersondataFinder implements Analysis<Boolean> {

    /**
     * Singleton reference of PersondataExtractor.
     */
    private static PersondataFinder instance;

    /**
     * @return Singleton instance of PersondataExtractor.
     */
    public static PersondataFinder getInstance() {
        if (instance == null) {
            instance = new PersondataFinder();
        }
        return instance;
    }

    protected PersondataFinder() {
    }

    @Override
    public Boolean process(Article article) {
        List<String> templates = article.getAnalysisResult(TemplateExtractor.
            getInstance());
        for (String template : templates) {
            if (template.startsWith("Persondata")) {
                return true;
            }
        }
        return false;
    }

}
