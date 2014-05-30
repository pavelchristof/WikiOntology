package pl.edu.mimuw.wikiontology.pn347193;

import java.util.ArrayList;
import java.util.Collection;
import pl.edu.mimuw.wikiontology.pn347193.predicates.Predicate;

/**
 * An ontology decorator that filters entities.
 */
public class FilteredOntology implements ReadableOntology {

    private final Ontology ontology;
    private final Predicate<Entity> filter;

    /**
     * Creates a new filtered ontology.
     *
     * @param ontology the underlying ontology
     * @param filter a predicate that returns true if an entity should be NOT
     * filtered out
     */
    public FilteredOntology(Ontology ontology, Predicate<Entity> filter) {
        this.ontology = ontology;
        this.filter = filter;
    }

    @Override
    public boolean containsEntity(Entity entity) {
        if (!ontology.containsEntity(entity)) {
            return false;
        }

        return filter.test(entity);
    }

    @Override
    public boolean containsEntity(Identifier identifier) {
        if (!ontology.containsEntity(identifier)) {
            return false;
        }

        return filter.test(ontology.getEntity(identifier));
    }

    @Override
    public Entity getEntity(Identifier identifier) {
        Entity entity = ontology.getEntity(identifier);
        if (entity == null) {
            return null;
        }

        return filter.test(entity) ? entity : null;
    }

    @Override
    public Collection<Entity> getEntities() {
        Collection<Entity> entities = ontology.getEntities();
        ArrayList<Entity> filtered = new ArrayList<>();

        for (Entity entity : entities) {
            if (filter.test(entity)) {
                filtered.add(entity);
            }
        }

        return filtered;
    }

    @Override
    public int entityCount() {
        Collection<Entity> entities = ontology.getEntities();
        int count = 0;

        for (Entity entity : entities) {
            if (filter.test(entity)) {
                count += 1;
            }
        }

        return count;
    }

}
