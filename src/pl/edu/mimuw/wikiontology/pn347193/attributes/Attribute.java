package pl.edu.mimuw.wikiontology.pn347193.attributes;

import pl.edu.mimuw.wikiontology.pn347193.Identifier;

/**
 * Models an attribute of an entity.
 *
 * @param <T> the type of the attribute
 */
public interface Attribute<T> {

    /**
     * An identifier describing this attribute, like "color".
     *
     * @return attribute`s identifier
     */
    Identifier getIdentifier();

    /**
     * A default value returned by getAttribute when there is no attribute.
     *
     * @return a default value
     */
    T getDefaultValue();

}
