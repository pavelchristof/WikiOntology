package wiki;

import java.util.Collection;

/**
 * Decides if an article is about a person.
 *
 * Dependencies: CategoryExtractor, PersondataExtractor. 
 * Result: whether the article is about a person.
 */
public class PersonClassifier implements Analysis<Boolean> {

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
    public Boolean process(Article article) {
        boolean isPerson = false;

        Collection<String> categories = article.getAnalysisResult(
            CategoryExtractor.getInstance());
        for (String category : categories) {
            if (category.contains("birth")) {
                isPerson = true;
                break;
            }
        }

        Boolean hasPersondata = article.getAnalysisResult(PersondataExtractor.
            getInstance());
        if (hasPersondata) {
            isPerson = true;
        }

        return isPerson;
    }

}
