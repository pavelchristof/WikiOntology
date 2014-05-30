package pl.edu.mimuw.wikiontology.pn347193.predicates;

/**
 * A predicate that wraps another predicate and negates its output.
 *
 * @param <T> the argument type
 */
public class NegatePredicate<T> implements Predicate<T> {

    private final Predicate<T> predicate;

    public NegatePredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(T argument) {
        return predicate.test(argument);
    }

}
