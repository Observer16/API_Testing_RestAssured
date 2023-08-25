package Evolution.utils.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsData {
    private ArrayList<ProductsProduct> products;
    private ArrayList<ProductsFilter> filters;
    private ArrayList<ProductsSort> sorts;
    private ProductsPage page;
}
