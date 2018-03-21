package udemy.algo.advanced.search;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;

public class WebCrawler {
    private final Queue<String> links;
    private final Set<String> visited;

    public WebCrawler() {
        this.links = new LinkedList<>();
        this.visited = new LinkedHashSet<>();
    }

    public void crawl(String rootUrl) {
        visit(rootUrl);

        while(! this.links.isEmpty()) {
            String current = this.links.poll();
            String content = readUrlContent(current);
            linksInPage(content).stream().filter(l -> ! isVisited(l)).forEach(this::visit);
        }
    }

    private void visit(String url) {
        this.links.offer(url);
        this.visited.add(url);
        System.out.printf("%s \n", url);
    }

    private boolean isVisited(String url) {
        return this.visited.contains(url);
    }

    //TODO: implement with jsoup
    private List<String> linksInPage(String content) {
        return Collections.emptyList();
    }

    private String readUrlContent(String url) {
        Scanner sc = null;
        try {
            sc =new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A");
            return sc.next();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if(sc != null) {
                sc.close();
            }
        }
    }
}
