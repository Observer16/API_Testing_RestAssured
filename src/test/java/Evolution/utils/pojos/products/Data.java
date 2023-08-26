package Evolution.utils.pojos.products;

import java.util.List;

public class Data {
    private List<Products> products;

    private List<Stores> stores;

    private List<Filters> filters;

    private List<Tags> tags;

    private List<Sorts> sorts;

    private Nav nav;

    private Seo seo;

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Products> getProducts() {
        return this.products;
    }

    public void setStores(List<Stores> stores) {
        this.stores = stores;
    }

    public List<Stores> getStores() {
        return this.stores;
    }

    public void setFilters(List<Filters> filters) {
        this.filters = filters;
    }

    public List<Filters> getFilters() {
        return this.filters;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Tags> getTags() {
        return this.tags;
    }

    public void setSorts(List<Sorts> sorts) {
        this.sorts = sorts;
    }

    public List<Sorts> getSorts() {
        return this.sorts;
    }

    public void setNav(Nav nav) {
        this.nav = nav;
    }

    public Nav getNav() {
        return this.nav;
    }

    public void setSeo(Seo seo) {
        this.seo = seo;
    }

    public Seo getSeo() {
        return this.seo;
    }
}
