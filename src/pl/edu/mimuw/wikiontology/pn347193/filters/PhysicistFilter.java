package pl.edu.mimuw.wikiontology.pn347193.filters;

import pl.edu.mimuw.wikiontology.pn347193.Entity;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;
import pl.edu.mimuw.wikiontology.pn347193.relations.IsA;

public class PhysicistFilter implements EntityFilter {
    
    /**
     * Singleton reference of PhysicistFilter.
     */
    private static PhysicistFilter instance;

    /**
     * @return Singleton instance of PhysicistFilter.
     */
    public static PhysicistFilter getInstance() {
        if (instance == null) {
            instance = new PhysicistFilter();
        }
        return instance;
    }
    
    protected PhysicistFilter() {
    }

    @Override
    public boolean filter(Entity entity) {
        return entity.hasRelation(new IsA(Identifier.PHYSICIST));
    }

}
