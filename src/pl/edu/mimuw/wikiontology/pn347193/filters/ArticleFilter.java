package pl.edu.mimuw.wikiontology.pn347193.filters;

import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;

public interface ArticleFilter {
    
    /**
     * Decides if an article should be filtered out.
     * 
     * @param builder the builder.
     * @return whether this article should be filtered out.
     */
    boolean filter(EntityBuilder builder);
    
}
