package pl.edu.mimuw.wikiontology.pn347193;

/**
 * A wiki article.
 *
 * This class is used during importing. It contains article title and text.
 */
public class Article {

    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

}
