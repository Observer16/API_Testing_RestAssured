package Evolution.utils.pojos.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LocationLocation {
    private Integer id;
    private String name;
    private String region;
    private String latitude;
    private String longitude;
    private ArrayList<LocationStore> stores;
    private LocationOrderEmail orderEmail;
    private String telegram;
    private String viber;
}
