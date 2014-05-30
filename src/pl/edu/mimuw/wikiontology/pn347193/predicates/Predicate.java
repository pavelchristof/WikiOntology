package pl.edu.mimuw.wikiontology.pn347193.predicates;

/**
 * A predicate that takes a single argument of type T.
 *
 * @param <T> the argument type
 */
public interface Predicate<T> {

    /**
     * Runs the predicate on an T object.
     *
     * @param argument the argument
     * @return predicate result
     */
    boolean test(T argument);

}
