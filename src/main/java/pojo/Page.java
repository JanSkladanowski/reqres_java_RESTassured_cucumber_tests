package pojo;

public class Page {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private Data[] data;
    private Object support;

    public Integer getPage() {
        return page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public Data[] getData() {
        return data;
    }

    public Object getSupport() {
        return support;
    }

    private Page(PageBuilder builder){
        this.page = builder.page;
        this.per_page = builder.per_page;
        this.total = builder.total;
        this.total_pages = builder.total_pages;
        this.data= builder.data;
        this.support = builder.support;
    }

    public static class PageBuilder{

        private Integer page;
        private Integer per_page;
        private Integer total;
        private Integer total_pages;
        private Data[] data;
        private Object support;

        public PageBuilder setPage(Integer page) {
            this.page = page;
            return this;
        }

        public PageBuilder setPer_page(Integer per_page) {
            this.per_page = per_page;
            return this;
        }

        public PageBuilder setTotal(Integer total) {
            this.total = total;
            return this;
        }

        public PageBuilder setTotal_pages(Integer total_pages) {
            this.total_pages = total_pages;
            return this;
        }

        public PageBuilder setData(Data[] data) {
            this.data = data;
            return this;
        }

        public PageBuilder setSupport(Object support) {
            this.support = support;
            return this;
        }
        public Page build(){
            return new Page(this);
        }
    }
}
