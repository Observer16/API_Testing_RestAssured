package Evolution.utils.pojos.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LocationStore {
    private Integer id;
    private String name;
    private String title;
    private String address;
    private String latitude;
    private String longitude;
    private LocationWorkingHours workingHours;
    private LocationPhones phones;
    private String pageUrl;
}
