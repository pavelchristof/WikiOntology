package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.edu.mimuw.wikiontology.pn347193.Article;

/**
 * Extracts links (like "[[Aristotle]]") from a wiki article.
 * 
 * Dependencies: none.
 * Result: a collection of links.
 */
public class LinkExtractor implements Analysis<Set<String>> {

    /**
     * Singleton reference of LinkExtractor.
     */
    private static LinkExtractor instance;

    /**
     * @return Singleton instance of LinkExtractor.
     */
    public static LinkExtractor getInstance() {
        if (instance == null) {
            instance = new LinkExtractor();
        }
        return instance;
    }
    
    private final Pattern pattern;
    
    protected LinkExtractor() {
        pattern = Pattern.compile("\\[\\[([^|\\]]*)[^\\]]*\\]\\]");
    }
    
    @Override
    public Set<String> process(Article article) {
        HashSet<String> links = new HashSet<>();
        Matcher matcher = pattern.matcher(article.getText());
        while (matcher.find()) {
            links.add(matcher.group(1));
        }
        return links;
    }

}
