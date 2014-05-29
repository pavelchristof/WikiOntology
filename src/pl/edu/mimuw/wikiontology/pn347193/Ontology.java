package pl.edu.mimuw.wikiontology.pn347193;

import java.util.HashMap;

/**
 * An ontology created from a wiki article.
 *
 * An ontology contains less information then an article. There is no article
 * text and only the analysis results requested by the user are stored.
 */
public class Ontology {

    private final String title;
    private final HashMap<Analysis<?>, Object> analysisResults;

    Ontology(String title,
        HashMap<Analysis<?>, Object> analysisResults) {
        this.title = title;
        this.analysisResults = analysisResults;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Gets result of an analysis that was run during importing.
     *
     * @param <R> result type.
     * @param analysis the analysis.
     * @return the result.
     */
    public <R> R getAnalysisResult(Analysis<R> analysis) {
        if (!analysisResults.containsKey(analysis)) {
            throw new AnalysisResultNotFoundException();
        }
 
        return (R) analysisResults.get(analysis);
    }

}
