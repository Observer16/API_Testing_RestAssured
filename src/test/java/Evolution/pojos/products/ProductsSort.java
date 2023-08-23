package Evolution.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductsSort {
    private String direction;
    private String title;
    private String comment;
    private Boolean isApplied;
}
