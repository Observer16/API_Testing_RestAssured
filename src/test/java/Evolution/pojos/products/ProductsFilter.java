package Evolution.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsFilter {
    private String code;
    private String type;
    private String title;
    private String hint;
    private Boolean isMultiple;
    private Boolean isCollapsed;
    private ArrayList<ProductsVariant> variants;
    private Boolean isApplied;
    private Object minRange;
    private Object maxRange;
    private Object minValue;
    private Object maxValue;
    private Integer step;
    private String unit;
}
