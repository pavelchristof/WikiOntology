package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.edu.mimuw.wikiontology.pn347193.Article;

/**
 * Extracts templates (like "{{center}}") from a wiki article.
 *
 * Dependencies: none. 
 * Result: a list of templates.
 */
public class TemplateExtractor implements Analysis<List<String>> {

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
    public List<String> process(Article article) {
        ArrayList<String> templates = new ArrayList<>();
        Matcher matcher = pattern.matcher(article.getText());
        while (matcher.find()) {
            templates.add(matcher.group(1));
        }
        return templates;
    }

}
