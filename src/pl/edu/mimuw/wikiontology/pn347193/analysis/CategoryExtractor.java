package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.HashSet;
import java.util.Set;
import pl.edu.mimuw.wikiontology.pn347193.Article;
import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;
import pl.edu.mimuw.wikiontology.pn347193.relations.IsInCategory;
import pl.edu.mimuw.wikiontology.pn347193.relations.LinksTo;

/**
 * Extracts categories from a wiki article.
 */
public class CategoryExtractor implements Analysis {

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
    public void process(EntityBuilder builder) {
        builder.requireAnalysis(LinkExtractor.getInstance());

        Set<LinksTo> links = builder.getEntity().getRelationsOfClass(
            LinksTo.class);
        for (LinksTo link : links) {
            String asString = link.getTarget().toString();
            if (asString.startsWith("Category:")) {
                Identifier category = new Identifier(asString.substring(
                    "Category:".length()));
                builder.getEntity().addRelation(new IsInCategory(category));
            }
        }
    }

}
