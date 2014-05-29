package wiki;

/**
 * Thrown if analysis graph contains circular dependencies.
 */
public class CircularDependenciesException extends RuntimeException {

    public CircularDependenciesException() {
        super("Analysis graph contains circular dependencies.");
    }
    
}
