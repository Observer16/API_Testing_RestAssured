package Evolution.utils.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsIcon {
    private String type;
    private String title;
    private String url;
    private String alternative;
}
