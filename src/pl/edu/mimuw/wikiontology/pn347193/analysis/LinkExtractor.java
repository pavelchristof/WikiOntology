package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;
import pl.edu.mimuw.wikiontology.pn347193.relations.LinksTo;

/**
 * Extracts links (like "[[Aristotle]]") from a wiki article.
 */
public class LinkExtractor implements Analysis {

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
    public void process(EntityBuilder builder) {
        Matcher matcher = pattern.matcher(builder.getArticle().getText());
        while (matcher.find()) {
            Identifier identifier = new Identifier(matcher.group(1));
            builder.getEntity().addRelation(new LinksTo(identifier));
        }
    }

}
