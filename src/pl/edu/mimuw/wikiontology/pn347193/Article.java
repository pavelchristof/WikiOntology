package pl.edu.mimuw.wikiontology.pn347193;

import java.util.HashMap;
import java.util.HashSet;

/**
 * A wiki article.
 *
 * This class is used during importing. It contains all information about an
 * article, including its text and all analysis results.
 */
public class Article {

    private final String title;
    private final String text;
    private final HashMap<Analysis<?>, Object> analysisResults;
    private final HashSet<Analysis<?>> runningAnalyses;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
        analysisResults = new HashMap<>();
        runningAnalyses = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    /**
     * Runs the analysis if it was not run before and returns its result.
     *
     * @param <R> result type.
     * @param analysis the analysis.
     * @return the analysis result.
     */
    public <R> R getAnalysisResult(Analysis<R> analysis) {
        // Was the analysis run before?    
        if (!analysisResults.containsKey(analysis)) {
            // First check for circular dependencies.
            if (runningAnalyses.contains(analysis)) {
                throw new CircularDependenciesException();
            }

            // Run the analysis and store its result.
            runningAnalyses.add(analysis);
            R result = analysis.process(this);
            analysisResults.put(analysis, result);
            runningAnalyses.remove(analysis);
        }

        return (R) analysisResults.get(analysis);
    }

}
