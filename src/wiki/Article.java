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

    public <T> T getAnalysisResult(Class<T> dataClass) {
        return (T) analysisResults.get(dataClass);
    }

    public <T> void setAnalysisResult(Class<T> dataClass, T data) {
        analysisResults.put(dataClass, data);
    }

    private String title;
    private String text;
    private Map<Class, Object> analysisResults;

}
