package pl.edu.mimuw.wikiontology.pn347193.importers.xml;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import pl.edu.mimuw.wikiontology.pn347193.ArticleConsumer;

/**
 * Imports articles from an XML document and feeds them to a consumer.
 */
public class XMLImporter {

    private final SAXHandler handler;
    private final SAXParser parser;

    public XMLImporter(ArticleConsumer consumer) throws SAXException,
        ParserConfigurationException {
        this.handler = new SAXHandler(consumer);
        this.parser = SAXParserFactory.newInstance().newSAXParser();
    }

    public ArticleConsumer getConsumer() {
        return handler.getConsumer();
    }

    public void setConsumer(ArticleConsumer consumer) {
        handler.setConsumer(consumer);
    }

    public void parse(InputStream input) throws SAXException, IOException {
        parser.parse(input, handler);
    }

}
