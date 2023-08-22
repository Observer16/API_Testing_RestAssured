package Evolution.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

class TakeToken {
    private String platform;
    private String version;
    private String build;
}
