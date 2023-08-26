package Evolution.utils.pojos.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LocationData {
    private ArrayList<LocationLocation> locations;
    private String mapKey;
}
