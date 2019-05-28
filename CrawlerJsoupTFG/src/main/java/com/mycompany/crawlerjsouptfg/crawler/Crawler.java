package com.mycompany.crawlerjsouptfg.crawler;

import java.util.ArrayList;

public interface Crawler {
    
    public void crawl();
    
    public ArrayList<String> getScrapedLinks();
}
