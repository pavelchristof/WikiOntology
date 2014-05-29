package pl.edu.mimuw.wikiontology.pn347193.importers.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import pl.edu.mimuw.wikiontology.pn347193.Article;
import pl.edu.mimuw.wikiontology.pn347193.ArticleConsumer;

enum SAXState {

    START,
    MEDIAWIKI,
    PAGE,
    TITLE,
    REVISION,
    TEXT,
    END

}

class SAXHandler extends DefaultHandler {

    private ArticleConsumer consumer;
    private SAXState state;
    private StringBuilder title;
    private StringBuilder text;

    public SAXHandler(ArticleConsumer consumer) {
        this.consumer = consumer;
    }

    public ArticleConsumer getConsumer() {
        return consumer;
    }

    public void setConsumer(ArticleConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void startDocument() throws SAXException {
        this.state = SAXState.START;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
        Attributes attributes) throws SAXException {
        switch (state) {
            case START:
                if (qName.equals("mediawiki")) {
                    state = SAXState.MEDIAWIKI;
                }
                break;

            case MEDIAWIKI:
                if (qName.equals("page")) {
                    state = SAXState.PAGE;
                }
                break;

            case PAGE:
                if (qName.equals("title")) {
                    state = SAXState.TITLE;
                    title = new StringBuilder();
                } else if (qName.equals("revision")) {
                    state = SAXState.REVISION;
                }
                break;

            case REVISION:
                if (qName.equals("text")) {
                    state = SAXState.TEXT;
                    text = new StringBuilder();
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (state) {
            case TITLE:
                title.append(ch, start, length);
                break;

            case TEXT:
                text.append(ch, start, length);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws
        SAXException {
        switch (state) {
            case MEDIAWIKI:
                if (qName.equals("mediawiki")) {
                    state = SAXState.END;
                }
                break;

            case PAGE:
                if (qName.equals("page")) {
                    state = SAXState.MEDIAWIKI;
                    consumer.accept(new Article(title.toString(), text.
                        toString()));
                }
                break;

            case TITLE:
                if (qName.equals("title")) {
                    state = SAXState.PAGE;
                }
                break;

            case REVISION:
                if (qName.equals("revision")) {
                    state = SAXState.PAGE;
                }
                break;

            case TEXT:
                if (qName.equals("text")) {
                    state = SAXState.REVISION;
                }
                break;
        }
    }

}
