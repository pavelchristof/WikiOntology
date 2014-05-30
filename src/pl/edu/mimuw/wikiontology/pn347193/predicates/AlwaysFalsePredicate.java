package pl.edu.mimuw.wikiontology.pn347193.predicates;

/**
 * A predicate that always returns false.
 *
 * @param <T> argument type
 */
public class AlwaysFalsePredicate<T> implements Predicate<T> {

    @Override
    public boolean test(T argument) {
        return false;
    }

}
