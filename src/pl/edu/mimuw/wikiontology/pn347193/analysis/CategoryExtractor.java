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

    /**
     * Runs this analysis on an EntityBuilder to generate IsInCategory relations.
     * 
     * @param builder The builder exposes both the partially built entity and
     *                the source article.
     */
    @Override
    public void process(EntityBuilder builder) {
        // Category extractor requires LinkTo relations to be present, we call
        // another analysis to get them. Note that analysis results are cached and 
        // an analysis will never be executed twice.
        builder.requireAnalysis(LinkExtractor.getInstance());

        // We can use getRelationsOfClass to get all relations of type "LinksTo".
        Set<LinksTo> links = builder.getEntity().getRelationsOfClass(
            LinksTo.class);
        for (LinksTo link : links) {
            // Categories are special articles that start with a "Category:" prefix.
            // An article belongs to a category iff it links to it.
            // getTarget() returns an Identifier of the relation target, it converts to a string nicely.
            String asString = link.getTarget().toString();
            if (asString.startsWith("Category:")) {
                // We remove the "Category:" prefix and wrap the string in an Identifier.
                Identifier category = new Identifier(asString.substring(
                    "Category:".length()));
                // And just add a new relation, addRelation is generic and knows the relation type.
                builder.getEntity().addRelation(new IsInCategory(category));
            }
        }
    }

}
