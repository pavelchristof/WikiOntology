package wiki;

import java.util.regex.Pattern;

/**
 * Extracts Persondata metadata from a wiki article.
 *
 * Dependencies: none.
 */
public class PersondataExtractor implements Analysis {

    /**
     * Result of a PersondataExtractor analysis.
     */
    public class Result {

        /**
         * Whether the article contains a Persondata template.
         */
        boolean hasPersondata;

    }

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
    public Class<Result> resultClass() {
        return Result.class;
    }

    @Override
    public Analysis[] dependencies() {
        return new Analysis[] {};
    }

    @Override
    public Result process(Article article) {
        Result r = new Result();
        r.hasPersondata = pattern.matcher(article.getText()).find();
        return r;
    }

}
