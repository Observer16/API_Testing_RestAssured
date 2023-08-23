package Evolution.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsPrice {
    private ProductsBase base;
    private ProductsMain main;
    private ArrayList<ProductsAdditional> additional;
}
