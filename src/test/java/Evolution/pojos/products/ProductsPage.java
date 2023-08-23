package Evolution.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsPage {
    private Integer page;
    private Integer limit;
    private Integer count;
}
