package pl.edu.mimuw.wikiontology.pn347193;

public class AnalysisResultNotFoundException extends RuntimeException {

    public AnalysisResultNotFoundException() {
        super("The requested analysis result was not found. "
            + "Did you forget to add it during importing?");
    }

}
