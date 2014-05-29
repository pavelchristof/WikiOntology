package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.HashSet;
import java.util.Set;
import pl.edu.mimuw.wikiontology.pn347193.Article;

/**
 * Extracts categories from a wiki article.
 *
 * Dependencies: LinkExtractor. 
 * Result: set of categories that a wiki page belongs to.
 */
public class CategoryExtractor implements Analysis<Set<String>> {

    /**
     * Singleton reference of CategoryExtractor.
     */
    private static CategoryExtractor instance;

    /**
     * @return Singleton instance of CategoryExtractor.
     */
    public static CategoryExtractor getInstance() {
        if (instance == null) {
            instance = new CategoryExtractor();
        }
        return instance;
    }

    protected CategoryExtractor() {
    }

    @Override
    public Set<String> process(Article article) {
        HashSet<String> categories = new HashSet<>();
        Set<String> links = article.getAnalysisResult(LinkExtractor.
            getInstance());
        for (String link : links) {
            if (link.startsWith("Category:")) {
                categories.add(link.substring("Category:".length()));
            }
        }
        return categories;
    }

}
