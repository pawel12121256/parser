package pagehelper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class PageHelper {

    public Document getPageContent(String url, AtomicLong counter) {
        try {
            final String encodedUrl = URLDecoder.decode(url, StandardCharsets.UTF_8);
            final Document document = Jsoup.connect(encodedUrl).get();
            counter.incrementAndGet();
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return new Document("empty");
        }
    }

    public List<String> extractUrlsFromPageContent(Document page) {
        return page.select("a").stream().map( aSection -> {
            final String href = aSection.attr("href");
            if (href.startsWith("/wiki/")) {
                return "https://pl.wikipedia.org" + href;
            } else {
                return href;
            }
                }
        ).collect(Collectors.toList());
    }
}
