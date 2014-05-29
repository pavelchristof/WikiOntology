package wiki;

/**
 * An analysis that can process an article and produce a result.
 * 
 * One analysis can depend on others (and use their results).
 */
public interface Analysis<R> {

    /**
     * Runs this analysis on an article.
     * @param article the article.
     * @return the result.
     */
    R process(Article article);

}
