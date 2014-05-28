package wiki;

/**
 * An analysis that can process an article and produce a result.
 * 
 * One analysis can depend on others (and use their results).
 */
public interface Analysis {

    /**
     * @return the class of this analysis result.
     */
    Class resultClass();

    /**
     * @return An array of analyses that must be run before this one.
     */
    Analysis[] dependencies();

    /**
     * Runs this analysis on an article.
     * @param article the article.
     * @return the result, which class must be equal to resultClass().
     */
    Object process(Article article);

}
