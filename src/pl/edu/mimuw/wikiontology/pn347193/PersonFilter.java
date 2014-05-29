package pl.edu.mimuw.wikiontology.pn347193;

/**
 * Filters out non-persons.
 */
public class PersonFilter implements Filter {

    @Override
    public boolean filter(Article article) {
        return article.getAnalysisResult(PersonClassifier.getInstance());
    }

}
