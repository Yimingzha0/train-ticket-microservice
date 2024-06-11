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
     * get all configs
     *
     * @param headers headers
     * @return Response
     */
    Response getAllConfigs(  HttpHeaders headers);

    /**
     * add config with config info
     *
     * @param c config info
     * @param headers headers
     * @return Response
     */
    Response addConfig(Config c, HttpHeaders headers);

    /**
     * delete config with name
     *
     * @param name name
     * @param headers headers
     * @return Response
     */
    Response deleteConfig(String name, HttpHeaders headers);

    /**
     * modify config with config info
     *
     * @param c config info
     * @param headers headers
     * @return Response
     */
    Response modifyConfig(Config c, HttpHeaders headers);



    /**
     * get all prices
     *
     * @param headers headers
     * @return Response
     */
    Response getAllPrices(  HttpHeaders headers);

    /**
     * add price with price info
     *
     * @param pi price info
     * @param headers headers
     * @return Response
     */
    Response addPrice(PriceInfo pi, HttpHeaders headers);

    /**
     * delete price with price info
     *
     * @param pricesId price config id
     * @param headers headers
     * @return Response
     */
    Response deletePrice(String pricesId, HttpHeaders headers);

    /**
     * modify price with price info
     *
     * @param pi price info
     * @param headers headers
     * @return Response
     */
    Response modifyPrice(PriceInfo pi, HttpHeaders headers);


}
