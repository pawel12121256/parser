package pagevisitor;

import pagehelper.PageHelper;

public abstract class PageVisitor {
    protected PageHelper pageHelper;

    public PageVisitor(PageHelper pageHelper) {
        this.pageHelper = pageHelper;
    }

    protected abstract VisitorResult visitPage(String rootUrl, int depth);
}
