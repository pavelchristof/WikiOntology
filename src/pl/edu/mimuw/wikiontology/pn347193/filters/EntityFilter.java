package pl.edu.mimuw.wikiontology.pn347193.filters;

import pl.edu.mimuw.wikiontology.pn347193.Entity;

public interface EntityFilter {

    /**
     * Decides if an entity should be filtered out.
     *
     * @param entity the entity
     * @return whether this entity should be filtered out
     */
    boolean filter(Entity entity);

}
