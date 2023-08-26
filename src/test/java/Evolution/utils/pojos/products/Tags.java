package Evolution.utils.pojos.products;

import java.util.List;

public class Tags {
    private int id;

    private String title;

    private String code;

    private int amount;

    private List<Filters> filters;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setFilters(List<Filters> filters) {
        this.filters = filters;
    }

    public List<Filters> getFilters() {
        return this.filters;
    }
}
