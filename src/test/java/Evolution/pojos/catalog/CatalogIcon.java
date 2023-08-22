package Evolution.pojos.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CatalogIcon {
    private String type;
    private String title;
    private String url;
    private String alternative;
}
