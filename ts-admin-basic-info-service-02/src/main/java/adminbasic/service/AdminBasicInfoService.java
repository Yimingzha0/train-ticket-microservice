package adminbasic.service;

import adminbasic.entity.PriceInfo;
import edu.fudan.common.entity.Config;
import edu.fudan.common.entity.Contacts;
import edu.fudan.common.entity.Station;
import edu.fudan.common.entity.TrainType;
import edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;


/**
 * @author fdse
 */
public interface AdminBasicInfoService {


    /**
     * get all stations
     *
     * @param headers headers
     * @return Response
     */
    Response getAllStations(  HttpHeaders headers);

    /**
     * add station with station information
     *
     * @param s station information
     * @param headers headers
     * @return Response
     */
    Response addStation(Station s, HttpHeaders headers);

    /**
     * delete station with station information
     *
     * @param id station id
     * @param headers headers
     * @return Response
     */
    Response deleteStation(String id, HttpHeaders headers);

    /**
     * modify station with station information
     *
     * @param s station information
     * @param headers headers
     * @return Response
     */
    Response modifyStation(Station s, HttpHeaders headers);



    /**
     * get all trains
     *
     * @param headers headers
     * @return Response
     */
    Response getAllTrains(  HttpHeaders headers);

    /**
     * add train with train type
     *
     * @param t train type
     * @param headers headers
     * @return Response
     */
    Response addTrain(TrainType t, HttpHeaders headers);

    /**
     * delete train with id
     *
     * @param id id
     * @param headers headers
     * @return Response
     */
    Response deleteTrain(String id,   HttpHeaders headers);

    /**
     * modify train with train type
     *
     * @param t train type
     * @param headers headers
     * @return Response
     */
    Response modifyTrain(TrainType t, HttpHeaders headers);


}
