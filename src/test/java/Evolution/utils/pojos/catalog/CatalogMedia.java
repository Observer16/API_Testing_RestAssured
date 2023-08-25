package Evolution.utils.pojos.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CatalogMedia {
    private String type;
    private String title;
    private String path;
    private String alternative;
}
