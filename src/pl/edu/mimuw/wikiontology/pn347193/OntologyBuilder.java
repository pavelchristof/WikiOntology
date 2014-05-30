package pl.edu.mimuw.wikiontology.pn347193;

import pl.edu.mimuw.wikiontology.pn347193.filters.ArticleFilter;
import pl.edu.mimuw.wikiontology.pn347193.analysis.Analysis;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Builds an ontology from a collection of articles.
 */
public class OntologyBuilder implements ArticleConsumer {
    
    private final HashSet<Analysis> analyses;
    private final HashSet<ArticleFilter> filters;
    private final ArrayList<Entity> entities;
    private ArticleConsumer filteredArticleConsumer;

    public OntologyBuilder() {
        analyses = new HashSet<>();
        filters = new HashSet<>();
        entities = new ArrayList<>();
        filteredArticleConsumer = null;
    }
    
    public void addAnalysis(Analysis analysis) {
        analyses.add(analysis);
    }
    
    public void removeAnalysis(Analysis analysis) {
        analyses.remove(analysis);
    }
    
    public void addFilter(ArticleFilter filter) {
        filters.add(filter);
    }
    
    public void removeFilter(ArticleFilter filter) {
        filters.remove(filter);
    }

    public ArticleConsumer getFilteredArticleConsumer() {
        return filteredArticleConsumer;
    }

    public void setFilteredArticleConsumer(
        ArticleConsumer filteredArticleConsumer) {
        this.filteredArticleConsumer = filteredArticleConsumer;
    }

    @Override
    public void accept(Article article) {
        EntityBuilder builder = new EntityBuilder(article);
        
        // First filter the article.
        for (ArticleFilter f : filters) {
            if (f.filter(builder)) {
                if (filteredArticleConsumer != null) {
                    filteredArticleConsumer.accept(article);
                }
                return;
            }
        }
        
        // Require all analyses.
        for (Analysis analysis : analyses) {
            builder.requireAnalysis(analysis);
        }

        // The entity is ready.
        entities.add(builder.getEntity());
    }
    
    public ArrayList<Entity> build() {
        return entities;
    }
   
}
