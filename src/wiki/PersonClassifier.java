package wiki;

/**
 * Decides if an article is about a person.
 *
 * Dependencies: CategoryExtractor, PersondataExtractor.
 */
public class PersonClassifier implements Analysis {

    /**
     * Result of a PersonClassifier analysis.
     */
    public class Result {

        /**
         * Whether this article is about a person.
         */
        public boolean isPerson;

    }

    private static PersonClassifier instance = null;

    public static PersonClassifier getInstance() {
        if (instance == null) {
            instance = new PersonClassifier();
        }
        return instance;
    }

    protected PersonClassifier() {
    }

    @Override
    public Class resultClass() {
        return Result.class;
    }

    @Override
    public Analysis[] dependencies() {
        return new Analysis[] {CategoryExtractor.getInstance(),
            PersondataExtractor.getInstance()};
    }

    @Override
    public Result process(Article article) {
        Result r = new Result();
        r.isPerson = false;

        CategoryExtractor.Result cer = article.getAnalysisResult(
            CategoryExtractor.getInstance().resultClass());
        for (String category : cer.categories) {
            if (category.contains("birth")) {
                r.isPerson = true;
                break;
            }
        }

        return r;
    }

}
