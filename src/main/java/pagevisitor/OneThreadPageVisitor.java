package pagevisitor;

import org.jsoup.nodes.Document;
import pagehelper.PageHelper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OneThreadPageVisitor extends PageVisitor {
    public OneThreadPageVisitor(PageHelper pageHelper) {
        super(pageHelper);
    }

    @Override
    public VisitorResult visitPage(String rootUrl, int depth) {
        LocalDateTime start = LocalDateTime.now();
        AtomicLong pageDownloadCounter = new AtomicLong();
        final Document pageContent = pageHelper.getPageContent(rootUrl, pageDownloadCounter);
        final long visitedPages = visitDependencies(pageContent, 0, depth);
        pageDownloadCounter.addAndGet(visitedPages);
        LocalDateTime end = LocalDateTime.now();
        return new VisitorResult(ChronoUnit.SECONDS.between(start, end), pageDownloadCounter.get());
    }

    long visitDependencies(Document page, int currentDepth, int maxDepth) {
        if (currentDepth >= maxDepth) {
            return 0;
        }
        AtomicLong pageDownloadCounter = new AtomicLong();
        final List<String> urls = pageHelper.extractUrlsFromPageContent(page);
        for (String url : urls) {
            final Document pageContent = pageHelper.getPageContent(url, pageDownloadCounter);
            final long visitedPages = visitDependencies(pageContent, currentDepth + 1, maxDepth);
            pageDownloadCounter.addAndGet(visitedPages);
        }
        return pageDownloadCounter.get();
    }

}
