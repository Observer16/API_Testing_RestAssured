package Evolution.utils.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsAdditional {
    private Integer price;
    private String currency;
    private String unit;
}
