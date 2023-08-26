package Evolution.utils.pojos.locations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LocationWorkingHours {
    private String title;
    private String from;
    @JsonProperty("to")
    private String myto;
}
