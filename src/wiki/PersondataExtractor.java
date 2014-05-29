package wiki;

import java.util.regex.Pattern;

/**
 * Extracts Persondata metadata from a wiki article.
 *
 * Dependencies: none.
 * Result: whether the article contains a Persondata template.
 */
public class PersondataExtractor implements Analysis<Boolean> {

    private static PersondataExtractor instance = null;

    public static PersondataExtractor getInstance() {
        if (instance == null) {
            instance = new PersondataExtractor();
        }
        return instance;
    }

    private final Pattern pattern;

    protected PersondataExtractor() {
        pattern = Pattern.compile("\\{\\{Persondata([^\\}]*)\\}\\}");
    }
 
    @Override
    public Boolean process(Article article) {
        return pattern.matcher(article.getText()).find();
    }

}
