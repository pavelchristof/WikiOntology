package pl.edu.mimuw.wikiontology.pn347193;

import java.util.HashSet;
import pl.edu.mimuw.wikiontology.pn347193.analysis.Analysis;

public class EntityBuilder {

    private final Article article;
    private final Entity entity;
    private final HashSet<Analysis> analysisDone;
    private final HashSet<Analysis> analysisRunning;

    public EntityBuilder(Article article) {
        this.article = article;
        this.entity = new Entity(new Identifier(article.getTitle()));
        this.analysisDone = new HashSet<>();
        this.analysisRunning = new HashSet<>();
    }

    public void requireAnalysis(Analysis analysis) {
        if (analysisDone.contains(analysis)) {
            return;
        }

        if (analysisRunning.contains(analysis)) {
            throw new CircularDependenciesException();
        }

        analysisRunning.add(analysis);
        analysis.process(this);
        analysisDone.add(analysis);
        analysisRunning.remove(analysis);
    }

    public Article getArticle() {
        return article;
    }

    public Entity getEntity() {
        return entity;
    }

}
