import pagehelper.PageHelper;
import pagevisitor.MultiThreadPageVisitor;
import pagevisitor.OneThreadPageVisitor;
import pagevisitor.ParallelStreamPageVisitor;
import pagevisitor.VisitorResult;

public class Start {

    public static void main(String[] args) {
        final String startUrl = "https://pl.wikipedia.org/wiki/Język_bułgarski";
        OneThreadPageVisitor oneThreadPageVisitor = new OneThreadPageVisitor(new PageHelper());
        final VisitorResult oneThreadPageVisitorResult = oneThreadPageVisitor.visitPage(startUrl, 2);
        MultiThreadPageVisitor multiThreadPageVisitor = new MultiThreadPageVisitor(new PageHelper());
        VisitorResult multiThreadPageVisitorResult = multiThreadPageVisitor.visitPage(startUrl, 2);
        ParallelStreamPageVisitor parallelStreamPageVisitor = new ParallelStreamPageVisitor(new PageHelper());
        final VisitorResult parallelStreamVisitorResult = parallelStreamPageVisitor.visitPage(startUrl, 2);
        System.out.println("One thread approach - parsing time: " + oneThreadPageVisitorResult.visitTimeInSeconds);
        System.out.println("One thread approach - number of visited pages: " + oneThreadPageVisitorResult.numberOfVisitedPages);
        System.out.println("Multi thread approach - parsing time: " + multiThreadPageVisitorResult.visitTimeInSeconds);
        System.out.println("Multi thread approach - number of visited pages: " + multiThreadPageVisitorResult.numberOfVisitedPages);
        System.out.println("Parallel streams approach - parsing time: " + parallelStreamVisitorResult.visitTimeInSeconds);
        System.out.println("Parallel streams approach - number of visited pages: " + parallelStreamVisitorResult.numberOfVisitedPages);
    }

}