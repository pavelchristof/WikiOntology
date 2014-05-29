package pl.edu.mimuw.wikiontology.pn347193;

public interface ArticleConsumer {
    
    /**
     * Performs this operation on the given article.
     * @param article the article.
     */
    void accept(Article article);
    
}
