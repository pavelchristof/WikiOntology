package pl.edu.mimuw.wikiontology.pn347193;

import java.util.Collection;

/**
 * A read-only ontology interface.
 */
public interface ReadableOntology {

    /**
     * Checks if the ontology contains an entity.
     *
     * @param entity the entity
     * @return whether the ontology contains the entity
     */
    public boolean containsEntity(Entity entity);

    /**
     * Checks if the ontology contains an entity.
     *
     * @param identifier the entity identifier
     * @return whether the ontology contains the entity
     */
    public boolean containsEntity(Identifier identifier);

    /**
     * Gets an entity.
     *
     * @param identifier the entity identifier
     * @return the entity
     */
    public Entity getEntity(Identifier identifier);

    /**
     * @return a collection of entities in this ontology.
     */
    public Collection<Entity> getEntities();

    /**
     * @return the number of entities.
     */
    public int entityCount();

}
