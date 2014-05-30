package pl.edu.mimuw.wikiontology.pn347193;

import pl.edu.mimuw.wikiontology.pn347193.analysis.Analysis;
import java.util.HashSet;
import pl.edu.mimuw.wikiontology.pn347193.predicates.Predicate;

/**
 * Builds an ontology from a collection of articles.
 */
public class OntologyBuilder implements ArticleConsumer {

    private final HashSet<Analysis> analyses;
    private final HashSet<Predicate<EntityBuilder>> filters;
    private final Ontology ontology;
    private ArticleConsumer filteredArticleConsumer;

    public OntologyBuilder() {
        analyses = new HashSet<>();
        filters = new HashSet<>();
        ontology = new Ontology();
        filteredArticleConsumer = null;
    }

    public void addAnalysis(Analysis analysis) {
        analyses.add(analysis);
    }

    public void removeAnalysis(Analysis analysis) {
        analyses.remove(analysis);
    }

    /**
     * Adds a filter that can prevent entities being build.
     *
     * @param filter a predicate that returns true if an article should be
     * loaded.
     */
    public void addFilter(Predicate<EntityBuilder> filter) {
        filters.add(filter);
    }

    public void removeFilter(Predicate<EntityBuilder> filter) {
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
        for (Predicate<EntityBuilder> f : filters) {
            if (!f.test(builder)) {
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
        ontology.addEntity(builder.getEntity());
    }

    public Ontology getOntology() {
        return ontology;
    }

}
