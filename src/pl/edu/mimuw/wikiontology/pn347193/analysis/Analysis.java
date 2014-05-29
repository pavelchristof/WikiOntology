package pl.edu.mimuw.wikiontology.pn347193.analysis;

import pl.edu.mimuw.wikiontology.pn347193.Article;

/**
 * An analysis that can process an article and produce a result.
 * One analysis can depend on others (and use their results).
 * 
 * @param <R> Result type.
 */
public interface Analysis<R> {

    /**
     * Runs this analysis on an article.
     * @param article the article.
     * @return the result.
     */
    R process(Article article);

}
