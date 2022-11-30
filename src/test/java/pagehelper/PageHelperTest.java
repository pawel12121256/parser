package pagehelper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.jupiter.api.Test;
import pagehelper.PageHelper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PageHelperTest {

    PageHelper pageHelper = new PageHelper();

    @Test
    void shouldExtractFiveUrlsFromPage() {
        // given
        Document page = createDocument();
        List<String> expectedUrls = List.of("http://test-url-0.pl", "http://test-url-1.pl", "http://test-url-2.pl", "http://test-url-3.pl", "http://test-url-4.pl");

        // when
        final List<String> urls = pageHelper.extractUrlsFromPageContent(page);

        // then
        assertEquals(expectedUrls, urls);
    }

    private Document createDocument() {
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