package pl.edu.mimuw.wikiontology.pn347193;

public interface Filter {
    
    /**
     * Decides if an article should be imported.
     * 
     * @param article the article.
     * @return whether this article should be imported.
     */
    boolean filter(Article article);
    
}
