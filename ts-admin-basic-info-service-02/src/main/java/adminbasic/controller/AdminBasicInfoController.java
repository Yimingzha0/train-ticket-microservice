package adminbasic.controller;

import adminbasic.entity.PriceInfo;
import adminbasic.service.AdminBasicInfoService;
import edu.fudan.common.entity.Config;
import edu.fudan.common.entity.Contacts;
import edu.fudan.common.entity.Station;
import edu.fudan.common.entity.TrainType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author fdse
 */
@RestController
@RequestMapping("/api/v1/adminbasicservice02")
public class AdminBasicInfoController {

    @Autowired
    AdminBasicInfoService adminBasicInfoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminBasicInfoController.class);


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/adminbasic/stations")
    public HttpEntity getAllStations(@RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[getAllStations][Find All Station by admin][getAllStations]");
        return ok(adminBasicInfoService.getAllStations(headers));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/adminbasic/stations/{id}")
    public HttpEntity deleteStation(@PathVariable String id, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[deleteStation][Delete Station by admin][Station id: {}]", id);
        return ok(adminBasicInfoService.deleteStation(id, headers));
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/adminbasic/stations")
    public HttpEntity modifyStation(@RequestBody Station s, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[modifyStation][Modify Station by admin][Station id: {}]", s.getId());
        return ok(adminBasicInfoService.modifyStation(s, headers));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adminbasic/stations")
    public HttpEntity addStation(@RequestBody Station s, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[addStation][Add Station by admin][Station id: {}]", s.getId());
        return ok(adminBasicInfoService.addStation(s, headers));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/adminbasic/trains")
    public HttpEntity getAllTrains(@RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[getAllTrains][Find All Train by admin][getAllStations]");
        return ok(adminBasicInfoService.getAllTrains(headers));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/adminbasic/trains/{id}")
    public HttpEntity deleteTrain(@PathVariable String id, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[deleteTrain][Delete Train by admin][train id: {}]", id);
        return ok(adminBasicInfoService.deleteTrain(id, headers));
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/adminbasic/trains")
    public HttpEntity modifyTrain(@RequestBody TrainType t, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[modifyTrain][Modify Train by admin][TrainType id: {}]", t.getId());
        return ok(adminBasicInfoService.modifyTrain(t, headers));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adminbasic/trains")
    public HttpEntity addTrain(@RequestBody TrainType t, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[addTrain][Add Train by admin][TrainType id: {}]", t.getId());
        return ok(adminBasicInfoService.addTrain(t, headers));
    }

}
