package pl.edu.mimuw.wikiontology.pn347193.attributes;

import java.util.ArrayList;
import java.util.List;
import pl.edu.mimuw.wikiontology.pn347193.Identifier;

public class Templates implements Attribute<List<String>> {

    /**
     * Singleton reference of Templates.
     */
    private static Templates instance;

    /**
     * @return Singleton instance of Templates.
     */
    public static Templates getInstance() {
        if (instance == null) {
            instance = new Templates();
        }
        return instance;
    }

    protected Templates() {
    }

    @Override
    public Identifier getIdentifier() {
        return Identifier.TEMPLATES;
    }

    @Override
    public List<String> getDefaultValue() {
        return new ArrayList<>();
    }

}
