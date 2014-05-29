package pl.edu.mimuw.wikiontology.pn347193;

/**
 * Thrown if analysis graph contains circular dependencies.
 */
public class CircularDependenciesException extends RuntimeException {

    public CircularDependenciesException() {
        super("Analysis graph contains circular dependencies.");
    }
    
}
