package pl.edu.mimuw.wikiontology.pn347193;

import java.util.Collection;
import java.util.HashMap;

public class Ontology implements ReadableOntology {

    private final HashMap<Identifier, Entity> entities;

    /**
     * Creates an empty ontology.
     */
    public Ontology() {
        entities = new HashMap<>();
    }

    /**
     * Checks if the ontology contains an entity.
     *
     * @param entity the entity
     * @return whether the ontology contains the entity
     */
    @Override
    public boolean containsEntity(Entity entity) {
        return entities.containsKey(entity.getIdentifier());
    }

    /**
     * Checks if the ontology contains an entity.
     *
     * @param identifier the entity identifier
     * @return whether the ontology contains the entity
     */
    @Override
    public boolean containsEntity(Identifier identifier) {
        return entities.containsKey(identifier);
    }

    /**
     * Gets an entity.
     *
     * @param identifier the entity identifier
     * @return the entity
     */
    @Override
    public Entity getEntity(Identifier identifier) {
        return entities.get(identifier);
    }

    /**
     * Adds a new entity to the ontology.
     *
     * If there is already an entity with the same identifier it will be
     * replaced.
     *
     * @param entity the entity
     */
    public void addEntity(Entity entity) {
        entities.put(entity.getIdentifier(), entity);
    }

    /**
     * Removes an entity from the ontology.
     *
     * @param entity the entity to be removed
     */
    public void removeEntity(Entity entity) {
        entities.remove(entity.getIdentifier());
    }

    /**
     * Removes an entity from the ontology.
     *
     * @param identifier identifier of the entity to be removed
     */
    public void removeEntity(Identifier identifier) {
        entities.remove(identifier);
    }

    /**
     * @return a collection of entities in this ontology.
     */
    @Override
    public Collection<Entity> getEntities() {
        return entities.values();
    }

    /**
     * @return the number of entities.
     */
    @Override
    public int entityCount() {
        return entities.size();
    }

}
