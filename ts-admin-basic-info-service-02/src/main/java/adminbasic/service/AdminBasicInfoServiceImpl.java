package adminbasic.service;

import adminbasic.entity.PriceInfo;
import edu.fudan.common.entity.Config;
import edu.fudan.common.entity.Contacts;
import edu.fudan.common.entity.Station;
import edu.fudan.common.entity.TrainType;
import edu.fudan.common.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author fdse
 */
@Service
public class AdminBasicInfoServiceImpl implements AdminBasicInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminBasicInfoServiceImpl.class);

    private String getServiceUrl(String serviceName) {
        return "http://" + serviceName;
    }

    @Override
    public Response getAllStations(HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(headers);
        String station_service_url = getServiceUrl("ts-station-service");
        String stations = station_service_url + "/api/v1/stationservice/stations";
        ResponseEntity<Response> re = restTemplate.exchange(
                stations,
                HttpMethod.GET,
                requestEntity,
                Response.class);

        return re.getBody();


    }

    @Override
    public Response addStation(Station s, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(s, headers);
        String station_service_url = getServiceUrl("ts-station-service");
        String stations = station_service_url + "/api/v1/stationservice/stations";
        ResponseEntity<Response> re = restTemplate.exchange(
                stations,
                HttpMethod.POST,
                requestEntity,
                Response.class);
        result = re.getBody();
        return result;
    }

    @Override
    public Response deleteStation(String id, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(headers);
        String station_service_url = getServiceUrl("ts-station-service");
        String path = station_service_url + "/api/v1/stationservice/stations/" + id;
        ResponseEntity<Response> re = restTemplate.exchange(
                path,
                HttpMethod.DELETE,
                requestEntity,
                Response.class);
        result = re.getBody();
        return result;
    }

    @Override
    public Response modifyStation(Station s, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(s, headers);
        String station_service_url = getServiceUrl("ts-station-service");
        String stations = station_service_url + "/api/v1/stationservice/stations";
        ResponseEntity<Response> re = restTemplate.exchange(
                stations,
                HttpMethod.PUT,
                requestEntity,
                Response.class);
        result = re.getBody();

        return result;

    }

    @Override
    public Response getAllTrains(HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(headers);
        String train_service_url = getServiceUrl("ts-train-service");
        String trains = train_service_url + "/api/v1/trainservice/trains";
        ResponseEntity<Response> re = restTemplate.exchange(
                trains,
                HttpMethod.GET,
                requestEntity,
                Response.class);

        return re.getBody();

    }

    @Override
    public Response addTrain(TrainType t, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(t, headers);
        String train_service_url = getServiceUrl("ts-train-service");
        String trains = train_service_url + "/api/v1/trainservice/trains";
        ResponseEntity<Response> re = restTemplate.exchange(
                trains,
                HttpMethod.POST,
                requestEntity,
                Response.class);
        result = re.getBody();
        return result;

    }

    @Override
    public Response deleteTrain(String id, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(headers);
        String train_service_url = getServiceUrl("ts-train-service");
        ResponseEntity<Response> re = restTemplate.exchange(
                train_service_url + "/api/v1/trainservice/trains/" + id,
                HttpMethod.DELETE,
                requestEntity,
                Response.class);
        result = re.getBody();
        return result;
    }

    @Override
    public Response modifyTrain(TrainType t, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(t, headers);
        String train_service_url = getServiceUrl("ts-train-service");
        String trains = train_service_url + "/api/v1/trainservice/trains";
        ResponseEntity<Response> re = restTemplate.exchange(
                trains,
                HttpMethod.PUT,
                requestEntity,
                Response.class);
        result = re.getBody();
        return result;
    }

}
