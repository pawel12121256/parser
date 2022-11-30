package pagevisitor;

import org.junit.jupiter.api.Test;
import pagehelper.PageHelper;

import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamPageVisitorTest {

    PageHelper pageHelper = new DummyPageHelper();
    ParallelStreamPageVisitor parallelStreamPageVisitor = new ParallelStreamPageVisitor(pageHelper);

    @Test
    void shouldVisit1PageWhenDepthIs0() {
        // given
        String rootUrl = "test url";
        int depth = 0;

        // when
        final VisitorResult visitorResult = parallelStreamPageVisitor.visitPage(rootUrl, depth);

        // then
        assertEquals(1, visitorResult.numberOfVisitedPages);
    }

    @Test
    void shouldVisit6PagesWhenDepthIs1() {
        // given
        String rootUrl = "test url";
        int depth = 1;

        // when
        final VisitorResult visitorResult = parallelStreamPageVisitor.visitPage(rootUrl, depth);

        // then
        assertEquals(6, visitorResult.numberOfVisitedPages);
    }

    @Test
    void shouldVisit31PagesWhenDepthIs2() {
        // given
        String rootUrl = "test url";
        int depth = 2;

        // when
        final VisitorResult visitorResult = parallelStreamPageVisitor.visitPage(rootUrl, depth);

        // then
        assertEquals(31, visitorResult.numberOfVisitedPages);
    }

}