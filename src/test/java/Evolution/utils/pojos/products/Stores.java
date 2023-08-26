package Evolution.utils.pojos.products;

import lombok.Getter;

import java.util.List;

public class Stores {
    @Getter
    private int id;

    @Getter
    private Store store;

    @Getter
    private String planDate;

    @Getter
    private int amount;

    @Getter
    private String unit;

    @Getter
    private String availText;

    @Getter
    private String extra;

    @Getter
    private List<String> placements;

    private boolean isApplied;

    @Getter
    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setAvailText(String availText) {
        this.availText = availText;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setPlacements(List<String> placements) {
        this.placements = placements;
    }

    public void setIsApplied(boolean isApplied){
        this.isApplied = isApplied;
    }

    public boolean getIsApplied(){
        return this.isApplied;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
