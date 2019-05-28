package com.mycompany.crawlerjsouptfg.crawler;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DocumentLoader {

    private Document doc;

    public DocumentLoader(){
        this.doc = null;
    }

    public DocumentLoader(String url) throws IOException {
        this.doc = Jsoup.connect(url).ignoreContentType(true).get();
    }

    public DocumentLoader(File fileToLoad, String charset) throws IOException {
        this.doc = Jsoup.parse(fileToLoad, charset);
    }

    public Element getBody(){
        return doc.body();
    }

    public Element getHead(){
        return doc.head();
    }

    public Document getDoc(){
        return doc;
    }

    public String getTitle(){
        return doc.title();
    }
}
