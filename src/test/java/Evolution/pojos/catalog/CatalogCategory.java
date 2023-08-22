package Evolution.pojos.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CatalogCategory {
    private String id;
    private String code;
    private String type;
    private String title;
    private CatalogIcon icon;
    private CatalogImage image;
    private String parentCategoryId;
    private Integer nodeId;
    private Integer parentNodeId;

}
