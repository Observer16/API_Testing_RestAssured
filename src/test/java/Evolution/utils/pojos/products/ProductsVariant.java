package Evolution.utils.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsVariant {
    private String code;
    private String title;
    private Boolean isEnabled;
    private Boolean isApplied;
    private Integer count;
    private ProductsImage image;
}
