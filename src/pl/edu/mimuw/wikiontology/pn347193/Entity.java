package pl.edu.mimuw.wikiontology.pn347193;

import java.util.HashMap;
import java.util.HashSet;
import pl.edu.mimuw.wikiontology.pn347193.attributes.Attribute;
import pl.edu.mimuw.wikiontology.pn347193.relations.Relation;

/**
 * An entity created from a wiki article.
 *
 * An entity contains its identifier, attributes and relations to other
 * entities.
 */
public class Entity {

    private final Identifier identifier;
    private final HashSet<Relation> relations;
    private final HashMap<Attribute<?>, Object> attributes;

    Entity(Identifier identifier) {
        this.identifier = identifier;
        this.relations = new HashSet<>();
        this.attributes = new HashMap<>();
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    /**
     * Adds a new relation to this article.
     *
     * @param relation the relation
     */
    public void addRelation(Relation relation) {
        relations.add(relation);
    }

    /**
     * Removes a relation from this article.
     *
     * @param relation the relation
     */
    public void removeRelation(Relation relation) {
        relations.remove(relation);
    }

    /**
     * Checks if the article contains a relation.
     *
     * @param relation the relation
     * @return whether the relation exists
     */
    public boolean hasRelation(Relation relation) {
        return relations.contains(relation);
    }

    /**
     * Get all relations.
     *
     * @return a hash set of relations
     */
    public HashSet<Relation> getRelations() {
        return relations;
    }

    /**
     * Get all relations of specific class.
     *
     * @param <T> the type of relation
     * @param relationClass the required class
     * @return a hash set of relations
     */
    public <T> HashSet<T> getRelationsOfClass(Class<T> relationClass) {
        HashSet<T> set = new HashSet<>();
        for (Relation rel : relations) {
            if (rel.getClass() == relationClass) {
                set.add((T) rel);
            }
        }
        return set;
    }

    /**
     * Get value of an attribute or a default value if the attribute is not set.
     *
     * @param <T> the type of the value
     * @param attribute the attribute
     * @return the value
     */
    public <T> T getAttribute(Attribute<T> attribute) {
        if (!attributes.containsKey(attribute)) {
            return attribute.getDefaultValue();
        }

        return (T) attributes.get(attribute);
    }

    /**
     * Sets value of an attribute.
     *
     * @param <T> the type of the value
     * @param attribute the attribute
     * @param value the value
     */
    public <T> void setAttribute(Attribute<T> attribute, T value) {
        attributes.put(attribute, value);
    }

}
