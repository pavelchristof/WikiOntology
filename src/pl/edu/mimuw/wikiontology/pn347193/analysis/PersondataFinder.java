package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.List;
import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;
import pl.edu.mimuw.wikiontology.pn347193.attributes.Templates;
import pl.edu.mimuw.wikiontology.pn347193.relations.HasA;

/**
 * Finds Persondata metadata in a wiki article.
 */
public class PersondataFinder implements Analysis {

    /**
     * Singleton reference of PersondataExtractor.
     */
    private static PersondataFinder instance;

    /**
     * @return Singleton instance of PersondataExtractor.
     */
    public static PersondataFinder getInstance() {
        if (instance == null) {
            instance = new PersondataFinder();
        }
        return instance;
    }

    protected PersondataFinder() {
    }

    private boolean hasPersondata(EntityBuilder builder) {
        builder.requireAnalysis(TemplateExtractor.getInstance());
        List<String> templates = builder.getEntity().getAttribute(Templates.
            getInstance());
        for (String template : templates) {
            if (template.startsWith("Persondata")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void process(EntityBuilder builder) {
        if (hasPersondata(builder)) {
            builder.getEntity().addRelation(new HasA(Identifier.PERSONDATA));
        }
    }

}
