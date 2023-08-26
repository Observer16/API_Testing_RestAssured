package Evolution.utils.pojos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Filters{
    private String id;
    private String type;
    private String title;
    private Boolean isMultiple;
    private String hint;
    private List<Variants> variants;
    private String minId;
    private String maxId;
    private Integer minRange;
    private Integer maxRange;
    private Integer minValue;
    private Integer maxValue;
    private Integer step;
    private String unit;
    private String value;
}