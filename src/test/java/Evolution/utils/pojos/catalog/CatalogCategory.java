package Evolution.utils.pojos.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CatalogCategory {
    private Integer id;
    private String type;
    private String title;
    private String code;
    private Integer nodeId;
    private Integer parentNodeId;
    private Integer amount;
    private CatalogMedia media;
}
