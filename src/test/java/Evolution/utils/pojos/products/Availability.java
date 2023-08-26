package Evolution.utils.pojos.products;

import java.util.List;

public class Availability {
    private String title;

    private String type;

    private AvailabilityCount availabilityCount;

    private List<Stores> stores;

    private String availabilityDate;

    private String hint;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setAvailabilityCount(AvailabilityCount availabilityCount) {
        this.availabilityCount = availabilityCount;
    }

    public AvailabilityCount getAvailabilityCount() {
        return this.availabilityCount;
    }

    public void setStores(List<Stores> stores) {
        this.stores = stores;
    }

    public List<Stores> getStores() {
        return this.stores;
    }

    public void setAvailabilityDate(String availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public String getAvailabilityDate() {
        return this.availabilityDate;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return this.hint;
    }
}
