package fdse.microservice.entity;

import edu.fudan.common.entity.Route;
import edu.fudan.common.entity.TrainType;
import lombok.Data;

/**
 * @author fdse
 */
@Data
public class AdminTrip {
    private fdse.microservice.entity.Trip trip;
    private TrainType trainType;
    private Route route;

    public AdminTrip(){
        //Default Constructor
    }

}
