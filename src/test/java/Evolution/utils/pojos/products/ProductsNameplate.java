package Evolution.utils.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsNameplate {
    private String type;
    private String title;
    private String url;
    private String bgColor;
    private String textColor;
    private ProductsIcon icon;
}
