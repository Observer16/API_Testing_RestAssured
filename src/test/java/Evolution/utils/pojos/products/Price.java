package Evolution.utils.pojos.products;

import java.util.List;

public class Price {
    private Main main;

    private List<String> additional;

    private Accounting accounting;

    private int bonus;

    private String extraBonus;

    public void setMain(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return this.main;
    }

    public void setAdditional(List<String> additional) {
        this.additional = additional;
    }

    public List<String> getAdditional() {
        return this.additional;
    }

    public void setAccounting(Accounting accounting) {
        this.accounting = accounting;
    }

    public Accounting getAccounting() {
        return this.accounting;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setExtraBonus(String extraBonus) {
        this.extraBonus = extraBonus;
    }

    public String getExtraBonus() {
        return this.extraBonus;
    }
}
