package adminbasic.service;

import adminbasic.entity.*;
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
     * get all contacts
     *
     * @param headers headers
     * @return Response
     */
    Response getAllContacts(  HttpHeaders headers);

    /**
     * add contact with contact information
     *
     * @param c contact information
     * @param headers headers
     * @return Response
     */
    Response addContact(Contacts c, HttpHeaders headers);

    /**
     * delete contact with contact id
     *
     * @param contactsId contact id
     * @param headers headers
     * @return Response
     */
    Response deleteContact( String contactsId, HttpHeaders headers);

    /**
     * modify contact with contact information
     *
     * @param mci contact information
     * @param headers headers
     * @return Response
     */
    Response modifyContact(Contacts mci, HttpHeaders headers);



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

}
