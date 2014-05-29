package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.edu.mimuw.wikiontology.pn347193.Article;

/**
 * Extracts categories from a wiki article.
 *
 * Dependencies: none.
 * Result: collection of categories that a wiki page belongs to.
 */
public class CategoryExtractor implements Analysis<Collection<String>> {
    
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
    
    private final Pattern pattern;

    protected CategoryExtractor() {
        pattern = Pattern.compile("\\[\\[Category:([^\\]]*)\\]\\]");
    }

    @Override
    public Collection<String> process(Article article) {
        ArrayList<String> categories = new ArrayList<>();
        Matcher matcher = pattern.matcher(article.getText());
        while (matcher.find()) {
            categories.add(matcher.group(1));
        }
        return categories;
    }

}
