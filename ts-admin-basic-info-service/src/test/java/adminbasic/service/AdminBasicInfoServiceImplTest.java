package adminbasic.service;

import adminbasic.entity.*;
import edu.fudan.common.entity.Config;
import edu.fudan.common.entity.Contacts;
import edu.fudan.common.entity.Station;
import edu.fudan.common.entity.TrainType;
import edu.fudan.common.util.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@RunWith(JUnit4.class)
public class AdminBasicInfoServiceImplTest {

    @InjectMocks
    private AdminBasicInfoServiceImpl adminBasicInfoService;

    @Mock
    private RestTemplate restTemplate;

    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity requestEntity = new HttpEntity(headers);
    private Response response = new Response();
    private ResponseEntity<Response> re = new ResponseEntity<>(response, HttpStatus.OK);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllContacts() {
        Mockito.when(restTemplate.exchange(
                "http://ts-contacts-service:12347/api/v1/contactservice/contacts",
                HttpMethod.GET,
                requestEntity,
                Response.class)).thenReturn(re);
        response = adminBasicInfoService.getAllContacts(headers);
        Assert.assertEquals(new Response<>(null, null, null), response);
    }

    @Test
    public void testDeleteContact() {
        Mockito.when(restTemplate.exchange(
                "http://ts-contacts-service:12347/api/v1/contactservice/contacts/" + "contactsId",
                HttpMethod.DELETE,
                requestEntity,
                Response.class)).thenReturn(re);
        response = adminBasicInfoService.deleteContact("contactsId", headers);
        Assert.assertEquals(new Response<>(null, null, null), response);
    }

    @Test
    public void testModifyContact() {
        Contacts mci = new Contacts();
        HttpEntity<Contacts> requestEntity = new HttpEntity<>(mci, headers);
        Mockito.when(restTemplate.exchange(
                "http://ts-contacts-service:12347/api/v1/contactservice/contacts",
                HttpMethod.PUT,
                requestEntity,
                Response.class)).thenReturn(re);
        response = adminBasicInfoService.modifyContact(mci, headers);
        Assert.assertEquals(new Response<>(null, null, null), response);
    }

    @Test
    public void testAddContact() {
        Contacts c = new Contacts();
        HttpEntity<Contacts> requestEntity = new HttpEntity<>(c, headers);
        Mockito.when(restTemplate.exchange(
                "http://ts-contacts-service:12347/api/v1/contactservice/contacts/admin",
                HttpMethod.POST,
                requestEntity,
                Response.class)).thenReturn(re);
        response = adminBasicInfoService.addContact(c, headers);
        Assert.assertEquals(new Response<>(null, null, null), response);
    }

    @Test
    public void testGetAllStations() {
        Mockito.when(restTemplate.exchange(
                "http://ts-station-service:12345/api/v1/stationservice/stations",
                HttpMethod.GET,
                requestEntity,
                Response.class)).thenReturn(re);
        response = adminBasicInfoService.getAllStations(headers);
        Assert.assertEquals(new Response<>(null, null, null), response);
    }

    @Test
    public void testAddStation() {
        Station s = new Station();
        HttpEntity<Station> requestEntity = new HttpEntity<>(s, headers);
        Mockito.when(restTemplate.exchange(
                "http://ts-station-service:12345/api/v1/stationservice/stations",
                HttpMethod.POST,
                requestEntity,
                Response.class)).thenReturn(re);
        response = adminBasicInfoService.addStation(s, headers);
        Assert.assertEquals(new Response<>(null, null, null), response);
    }

    @Test
    public void testDeleteStation() {
        Station s = new Station();
        HttpEntity<Station> requestEntity = new HttpEntity<>(s, headers);
        Mockito.when(restTemplate.exchange(
                "http://ts-station-service:12345/api/v1/stationservice/stations",
                HttpMethod.DELETE,
                requestEntity,
                Response.class)).thenReturn(re);
        response = adminBasicInfoService.deleteStation(s.getId(), headers);
        Assert.assertEquals(new Response<>(null, null, null), response);
    }

    @Test
    public void testModifyStation() {
        Station s = new Station();
        HttpEntity<Station> requestEntity = new HttpEntity<>(s, headers);
        Mockito.when(restTemplate.exchange(
                "http://ts-station-service:12345/api/v1/stationservice/stations",
                HttpMethod.PUT,
                requestEntity,
                Response.class)).thenReturn(re);
        response = adminBasicInfoService.modifyStation(s, headers);
        Assert.assertEquals(new Response<>(null, null, null), response);
    }

}
