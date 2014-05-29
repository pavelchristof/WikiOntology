package pl.edu.mimuw.wikiontology.pn347193;

import pl.edu.mimuw.wikiontology.pn347193.filters.ArticleFilter;
import pl.edu.mimuw.wikiontology.pn347193.analysis.Analysis;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Builds a collection of ontologies from articles.
 */
public class OntologyCollectionBuilder implements ArticleConsumer {
    
    private final HashSet<Analysis<?>> analyses;
    private final HashSet<ArticleFilter> filters;
    private final ArrayList<Ontology> ontologies;

    public OntologyCollectionBuilder() {
        analyses = new HashSet<>();
        filters = new HashSet<>();
        ontologies = new ArrayList<>();
    }
    
    public void addAnalysis(Analysis<?> analysis) {
        analyses.add(analysis);
    }
    
    public void removeAnalysis(Analysis<?> analysis) {
        analyses.remove(analysis);
    }
    
    public void addFilter(ArticleFilter filter) {
        filters.add(filter);
    }
    
    public void removeFilter(ArticleFilter filter) {
        filters.remove(filter);
    }

    @Override
    public void accept(Article article) {
        // First filter the article.
        for (ArticleFilter f : filters) {
            if (f.filter(article)) {
                return;
            }
        }
        
        // Get all analysis results.
        HashMap<Analysis<?>, Object> results = new HashMap<>();
        for (Analysis<?> analysis : analyses) {
            results.put(analysis, article.getAnalysisResult(analysis));
        }

        // Create the ontology.
        ontologies.add(new Ontology(article.getTitle(), results));
    }
    
    public Collection<Ontology> build() {
        return ontologies;
    }
   
}
