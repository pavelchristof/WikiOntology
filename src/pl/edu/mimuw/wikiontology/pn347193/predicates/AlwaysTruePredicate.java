package pl.edu.mimuw.wikiontology.pn347193.predicates;

/**
 * A predicate that always returns true.
 *
 * @param <T> argument type
 */
public class AlwaysTruePredicate<T> implements Predicate<T> {

    @Override
    public boolean test(T argument) {
        return true;
    }

}
