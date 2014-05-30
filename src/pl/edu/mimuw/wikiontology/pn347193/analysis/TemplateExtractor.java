package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.edu.mimuw.wikiontology.pn347193.EntityBuilder;
import pl.edu.mimuw.wikiontology.pn347193.attributes.Templates;

/**
 * Extracts templates (like "{{center}}") from a wiki article.
 */
public class TemplateExtractor implements Analysis {

    /**
     * Singleton reference of TemplateExtractor.
     */
    private static TemplateExtractor instance;

    /**
     * @return Singleton instance of TemplateExtractor.
     */
    public static TemplateExtractor getInstance() {
        if (instance == null) {
            instance = new TemplateExtractor();
        }
        return instance;
    }

    private final Pattern pattern;

    protected TemplateExtractor() {
        pattern = Pattern.compile("\\{\\{([^\\}]*)\\}\\]");
    }

    @Override
    public void process(EntityBuilder builder) {
        ArrayList<String> templates = new ArrayList<>();
        Matcher matcher = pattern.matcher(builder.getArticle().getText());
        while (matcher.find()) {
            templates.add(matcher.group(1));
        }
        builder.getEntity().setAttribute(Templates.getInstance(), templates);
    }

}
