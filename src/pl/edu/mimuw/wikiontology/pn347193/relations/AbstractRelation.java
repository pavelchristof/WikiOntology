package pl.edu.mimuw.wikiontology.pn347193.relations;

import java.util.Objects;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;

public abstract class AbstractRelation implements Relation {

    private final Identifier target;

    public AbstractRelation(Identifier target) {
        this.target = target;
    }

    @Override
    public Identifier getTarget() {
        return target;
    }

    /**
     * Default equality for relations. Checks if object class and target
     * identifier are equal.
     *
     * @param obj the object to compare
     * @return whether the objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractRelation other = (AbstractRelation) obj;
        return Objects.equals(this.target, other.target);
    }

    /**
     * Default hashCode for relations. Hashes the target identifier and the
     * class of this object.
     *
     * @return the hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.target);
        hash = 67 * hash + Objects.hashCode(this.getClass());
        return hash;
    }

}
