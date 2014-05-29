package wiki;

import java.util.Map;
import java.util.TreeMap;

public class Article {

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
        analysisResults = new TreeMap<>();
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public <T> T getAnalysisResult(Class<T> resultClass) {
        return (T) analysisResults.get(resultClass);
    }

    public <T> void setAnalysisResult(Class<T> resultClass, T result) {
        analysisResults.put(resultClass, result);
    }

    private final String title;
    private final String text;
    private final Map<Class, Object> analysisResults;

}
