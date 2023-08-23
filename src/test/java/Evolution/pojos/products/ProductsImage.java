package Evolution.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsImage {
    private String type;
    private String title;
    private String url;
    private String alternative;
}
