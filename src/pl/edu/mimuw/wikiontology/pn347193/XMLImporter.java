package pl.edu.mimuw.wikiontology.pn347193;

import java.io.InputStream;

/**
 * Imports articles from an XML document and feeds them to a consumer.
 */
public class XMLImporter {
    
    private ArticleConsumer consumer;

    public XMLImporter(ArticleConsumer consumer) {
        this.consumer = consumer;
    }
    
    public ArticleConsumer getConsumer() {
        return consumer;
    }
    
    public void setConsumer(ArticleConsumer consumer) {
        this.consumer = consumer;
    }
    
    public void parseXML(InputStream input) {
        
    }
    
}
