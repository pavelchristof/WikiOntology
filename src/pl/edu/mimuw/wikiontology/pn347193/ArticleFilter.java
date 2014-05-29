package pl.edu.mimuw.wikiontology.pn347193;

public interface ArticleFilter {
    
    /**
     * Decides if an article should be filtered out.
     * 
     * @param article the article.
     * @return whether this article should be filtered out.
     */
    boolean filter(Article article);
    
}
