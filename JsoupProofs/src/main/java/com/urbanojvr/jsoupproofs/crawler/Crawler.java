package com.urbanojvr.jsoupproofs.crawler;

import java.io.IOException;
import java.util.ArrayList;

public interface Crawler {

    void crawl() throws IOException;

    ArrayList<String> getScrapedLinks();
}
