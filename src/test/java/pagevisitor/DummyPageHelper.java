package pagevisitor;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import pagehelper.PageHelper;

import java.util.concurrent.atomic.AtomicLong;

class DummyPageHelper extends PageHelper {
    @Override
    public Document getPageContent(String url, AtomicLong counter) {
        counter.incrementAndGet();
        Document page = new Document("test page");
        for (int i = 0; i < 5; i++) {
            Element link = new Element(Tag.valueOf("a"), "")
                    .text("Test " + i)
                    .attr("href", "http://test-url-" + i + ".pl");
            page.appendChild(link);
        }
        return page;
    }
}
