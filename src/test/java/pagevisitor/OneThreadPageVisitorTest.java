package pagevisitor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.jupiter.api.Test;
import pagehelper.PageHelper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OneThreadPageVisitorTest {

    PageHelper pageHelper = new DummyPageHelper();
    OneThreadPageVisitor oneThreadPageVisitor = new OneThreadPageVisitor(pageHelper);

    @Test
    void shouldVisit1PageWhenDepthIs0() {
        // given
        String rootUrl = "test url";
        int depth = 0;

        // when
        final VisitorResult visitorResult = oneThreadPageVisitor.visitPage(rootUrl, depth);

        // then
        assertEquals(1, visitorResult.numberOfVisitedPages);
    }

    @Test
    void shouldVisit6PagesWhenDepthIs1() {
        // given
        String rootUrl = "test url";
        int depth = 1;

        // when
        final VisitorResult visitorResult = oneThreadPageVisitor.visitPage(rootUrl, depth);

        // then
        assertEquals(6, visitorResult.numberOfVisitedPages);
    }

    @Test
    void shouldVisit31PagesWhenDepthIs2() {
        // given
        String rootUrl = "test url";
        int depth = 2;

        // when
        final VisitorResult visitorResult = oneThreadPageVisitor.visitPage(rootUrl, depth);

        // then
        assertEquals(31, visitorResult.numberOfVisitedPages);
    }

}

