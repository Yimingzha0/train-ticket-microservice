package adminbasic.controller;

import adminbasic.entity.PriceInfo;
import adminbasic.service.AdminBasicInfoService;
import edu.fudan.common.entity.Config;
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
@RequestMapping("/api/v1/adminbasicservice03")
public class AdminBasicInfoController {

    @Autowired
    AdminBasicInfoService adminBasicInfoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminBasicInfoController.class);

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/adminbasic/configs")
    public HttpEntity getAllConfigs(@RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[getAllConfigs][Find All Config by admin][getAllConfigs]");
        return ok(adminBasicInfoService.getAllConfigs(headers));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/adminbasic/configs/{name}")
    public HttpEntity deleteConfig(@PathVariable String name, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[deleteConfig][Delete Config by admin][Config name: {}]", name);
        return ok(adminBasicInfoService.deleteConfig(name, headers));
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/adminbasic/configs")
    public HttpEntity modifyConfig(@RequestBody Config c, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[modifyConfig][Modify Config by admin][Config name: {}]", c.getName());
        return ok(adminBasicInfoService.modifyConfig(c, headers));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adminbasic/configs")
    public HttpEntity addConfig(@RequestBody Config c, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[addConfig][Add Config by admin][Config name: {}]", c.getName());
        return ok(adminBasicInfoService.addConfig(c, headers));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/adminbasic/prices")
    public HttpEntity getAllPrices(@RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[getAllPrices][Find All Price by admin][getAllPrices]");
        return ok(adminBasicInfoService.getAllPrices(headers));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/adminbasic/prices/{pricesId}")
    public HttpEntity deletePrice(@PathVariable String pricesId, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[deletePrice][Delete Price by admin][PriceInfo id: {}]", pricesId);
        return ok(adminBasicInfoService.deletePrice(pricesId, headers));
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/adminbasic/prices")
    public HttpEntity modifyPrice(@RequestBody PriceInfo pi, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[modifyPrice][Modify Price by admin][PriceInfo id: {}]", pi.getId());
        return ok(adminBasicInfoService.modifyPrice(pi, headers));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adminbasic/prices")
    public HttpEntity addPrice(@RequestBody PriceInfo pi, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[addPrice][Add Price by admin[PriceInfo id: {}]", pi.getId());
        return ok(adminBasicInfoService.addPrice(pi, headers));
    }

}
