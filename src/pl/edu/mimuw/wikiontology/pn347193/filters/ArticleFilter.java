package pl.edu.mimuw.wikiontology.pn347193.filters;

import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;

/**
 * A filter run during entity building.
 */
public interface ArticleFilter {
    
    /**
     * Decides if an article should be filtered out.
     * 
     * @param builder the builder containing the article.
     * @return whether this article should be filtered out.
     */
    boolean filter(EntityBuilder builder);
    
}
