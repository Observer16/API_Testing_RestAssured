package Evolution.utils.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsBase {
    private Integer price;
    private String currency;
}
