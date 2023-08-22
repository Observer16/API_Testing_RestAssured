package Evolution.pojos.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CatalogImage {
    private String type;
    private String title;
    private String url;
    private String alternative;
}
