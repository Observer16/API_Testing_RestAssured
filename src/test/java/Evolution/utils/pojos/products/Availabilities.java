package Evolution.utils.pojos.products;

import java.util.List;

public class Availabilities {
    private Store store;

    private String planDate;

    private int amount;

    private String unit;

    private String availText;

    private String extra;

    private List<String> placements;

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return this.store;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getPlanDate() {
        return this.planDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setAvailText(String availText) {
        this.availText = availText;
    }

    public String getAvailText() {
        return this.availText;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setPlacements(List<String> placements) {
        this.placements = placements;
    }

    public List<String> getPlacements() {
        return this.placements;
    }
}
