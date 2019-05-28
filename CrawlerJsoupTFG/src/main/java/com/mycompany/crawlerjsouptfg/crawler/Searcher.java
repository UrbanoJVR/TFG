package com.mycompany.crawlerjsouptfg.crawler;


import java.util.ArrayList;

public interface Searcher {
 
    public void search(ArrayList<?> obj, String target) throws Exception;
    
    public ArrayList<String> getMatchedLinks();
    
}
