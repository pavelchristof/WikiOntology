package wiki;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extracts categories from a wiki article.
 *
 * Dependencies: none.
 */
public class CategoryExtractor implements Analysis {

    /**
     * Result of a CategoryExtractor analysis.
     */
    public class Result {

        /**
         * Collection of categories that a wiki page belongs to.
         */
        public Collection<String> categories;

    }

    private static CategoryExtractor instance = null;

    public static CategoryExtractor getInstance() {
        if (instance == null) {
            instance = new CategoryExtractor();
        }
        return instance;
    }

    private final Pattern pattern;

    protected CategoryExtractor() {
        pattern = Pattern.compile("\\[\\[Category:([^\\]]*)\\]\\]");
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
        r.categories = new ArrayList<>();
        Matcher matcher = pattern.matcher(article.getText());
        while (matcher.find()) {
            r.categories.add(matcher.group(1));
        }
        return r;
    }

}
