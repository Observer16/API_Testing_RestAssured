package Evolution.utils.pojos.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CatalogData {
    private ArrayList<CatalogCategory> categories;
    private CatalogSeo seo;
}