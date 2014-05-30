package pl.edu.mimuw.wikiontology.pn347193.analysis;

import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;

/**
 * An analysis can process an article and modify an entity. It can require other
 * analysis to be run.
 */
public interface Analysis {

    /**
     * Runs the analysis.
     *
     * @param builder the builder
     */
    void process(EntityBuilder builder);

}
