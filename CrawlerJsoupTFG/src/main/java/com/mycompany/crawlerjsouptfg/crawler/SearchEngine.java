package com.mycompany.crawlerjsouptfg.crawler;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.nodes.Element;

public class SearchEngine implements Searcher {

    private final ArrayList<String> matchedLinks;

    public SearchEngine() {
        matchedLinks = new ArrayList<>();
        System.out.println("SEARCH ENGINE STARTING");
    }

    @Override
    public void search(ArrayList<?> objs, String target) throws IOException {
        try {
            for (Object obj : objs) {
                String url = obj.toString();
                System.out.println(url);
                Element body = new DocumentLoader(url).getBody();
                if (!body.getElementsContainingText(target).isEmpty()) {
                    matchedLinks.add(url);
                    System.out.println("YES");
                }
            }
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
    }

    @Override
    public ArrayList<String> getMatchedLinks() {
        return matchedLinks;
    }

}
