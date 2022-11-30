package pagevisitor;

public class VisitorResult {
    public final long visitTimeInSeconds;
    public final long numberOfVisitedPages;

    public VisitorResult(long visitTimeInSeconds, long numberOfVisitedPages) {
        this.visitTimeInSeconds = visitTimeInSeconds;
        this.numberOfVisitedPages = numberOfVisitedPages;
    }
}
