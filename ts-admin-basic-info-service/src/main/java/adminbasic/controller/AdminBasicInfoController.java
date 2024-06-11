package adminbasic.controller;

import adminbasic.entity.*;
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
@RequestMapping("/api/v1/adminbasicservice")
public class AdminBasicInfoController {

    @Autowired
    AdminBasicInfoService adminBasicInfoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminBasicInfoController.class);

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/adminbasic/contacts")
    public HttpEntity getAllContacts(@RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[getAllContacts][Find All Contacts by admin][getAllContacts] ");
        return ok(adminBasicInfoService.getAllContacts(headers));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/adminbasic/contacts/{contactsId}")
    public HttpEntity deleteContacts(@PathVariable String contactsId, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[deleteContacts][Delete Contacts by admin][contactsId: {}]", contactsId);
        return ok(adminBasicInfoService.deleteContact(contactsId, headers));
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/adminbasic/contacts")
    public HttpEntity modifyContacts(@RequestBody Contacts mci, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[modifyContacts][Modify Contacts by admin][Contacts name:{}]", mci.getName());
        return ok(adminBasicInfoService.modifyContact(mci, headers));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adminbasic/contacts")
    public HttpEntity addContacts(@RequestBody Contacts c, @RequestHeader HttpHeaders headers) {
        AdminBasicInfoController.LOGGER.info("[addContacts][Modify Contacts by admin][Contacts name: {}]", c.getName());
        return ok(adminBasicInfoService.addContact(c, headers));
    }

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

}
