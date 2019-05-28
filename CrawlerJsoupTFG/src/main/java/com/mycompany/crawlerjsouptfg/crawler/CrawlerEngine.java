package com.mycompany.crawlerjsouptfg.crawler;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerEngine implements Crawler{

    private static final int DEFAULT_LIST_SIZE = 500;
    
    protected String baseURI;
    private String rootURI;
    ArrayList<String> linksList;
    private int listSize;
    
    public CrawlerEngine(String baseURI) throws IOException {
        this.baseURI = baseURI;
        this.rootURI = String.valueOf(baseURI);
        linksList = new ArrayList<>();
        listSize = DEFAULT_LIST_SIZE;
    }
    
    public CrawlerEngine(String baseURI, int crawlerLimit) throws IOException {
        this.baseURI = baseURI;
        this.rootURI = String.valueOf(baseURI);
        linksList = new ArrayList<>();
        listSize = crawlerLimit;
    }
    
    @Override
    public void crawl() {
        System.out.println("Crawler Engine Starting");
        crawl(rootURI);
    }
    
    public void crawl(String url){
        try{
            SintaxEngine sintaxEngine = new SintaxEngine(url);
            Elements links = sintaxEngine.getAWithRef();

            
            
            for(Element link : links){
                String actualUrl = link.attr("abs:href");
                if(!linksList.contains(actualUrl) & actualUrl.startsWith(baseURI) && linksList.size() < listSize){
                    print(" * a: <%s>  (%s)", actualUrl, trim(link.text(), 35));
                    linksList.add(actualUrl);
                    if((linksList.size() % 100) == 0){
                        System.out.println(linksList.size());
                    }
                    crawl(actualUrl);
                }
            }
        } catch (Exception error){
            System.out.println(error.getMessage());
        } catch (StackOverflowError stackOverflowError){
            System.err.println("[" + linksList.size() + "]");
        }
    }
    
    protected void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    protected String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }

    public String getRootURI() {
        return rootURI;
    }

    public void setRootURI(String rootURI) {
        this.rootURI = rootURI;
    }

    @Override
    public ArrayList<String> getScrapedLinks() {
        return linksList;
    }

    public void setLinksList(ArrayList<String> linksList) {
        this.linksList = linksList;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
}
