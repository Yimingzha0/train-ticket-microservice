package adminbasic.controller;

import adminbasic.entity.*;
import adminbasic.service.AdminBasicInfoService;
import com.alibaba.fastjson.JSONObject;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(JUnit4.class)
public class AdminBasicInfoControllerTest {

    @InjectMocks
    private AdminBasicInfoController adminBasicInfoController;

    @Mock
    private AdminBasicInfoService adminBasicInfoService;
    private MockMvc mockMvc;
    private Response response = new Response();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminBasicInfoController).build();
    }

    @Test
    public void testHome() throws Exception {

    }

    @Test
    public void testGetAllContacts() throws Exception {

    }

    @Test
    public void testDeleteContacts() throws Exception {
        Mockito.when(adminBasicInfoService.deleteContact(Mockito.anyString(), Mockito.any(HttpHeaders.class))).thenReturn(response);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/adminbasicservice/adminbasic/contacts/contactsId"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals(response, JSONObject.parseObject(result, Response.class));
    }

    @Test
    public void testModifyContacts() throws Exception {
        Contacts mci = new Contacts();
        Mockito.when(adminBasicInfoService.modifyContact(Mockito.any(Contacts.class), Mockito.any(HttpHeaders.class))).thenReturn(response);
        String requestJson = JSONObject.toJSONString(mci);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/adminbasicservice/adminbasic/contacts").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals(response, JSONObject.parseObject(result, Response.class));
    }

    @Test
    public void testAddContacts() throws Exception {
        Contacts c = new Contacts();
        Mockito.when(adminBasicInfoService.addContact(Mockito.any(Contacts.class), Mockito.any(HttpHeaders.class))).thenReturn(response);
        String requestJson = JSONObject.toJSONString(c);
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/adminbasicservice/adminbasic/contacts").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals(response, JSONObject.parseObject(result, Response.class));
    }

    @Test
    public void testGetAllStations() throws Exception {
        Mockito.when(adminBasicInfoService.getAllStations(Mockito.any(HttpHeaders.class))).thenReturn(response);
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/adminbasicservice/adminbasic/stations"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals(response, JSONObject.parseObject(result, Response.class));
    }

    @Test
    public void testDeleteStation() throws Exception {
        Station s = new Station();
        Mockito.when(adminBasicInfoService.deleteStation(Mockito.anyString(), Mockito.any(HttpHeaders.class))).thenReturn(response);
        String requestJson = JSONObject.toJSONString(s);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/adminbasicservice/adminbasic/stations").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals(response, JSONObject.parseObject(result, Response.class));
    }

    @Test
    public void testModifyStation() throws Exception {
        Station s = new Station();
        Mockito.when(adminBasicInfoService.modifyStation(Mockito.any(Station.class), Mockito.any(HttpHeaders.class))).thenReturn(response);
        String requestJson = JSONObject.toJSONString(s);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/adminbasicservice/adminbasic/stations").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals(response, JSONObject.parseObject(result, Response.class));
    }

    @Test
    public void testAddStation() throws Exception {
        Station s = new Station();
        Mockito.when(adminBasicInfoService.addStation(Mockito.any(Station.class), Mockito.any(HttpHeaders.class))).thenReturn(response);
        String requestJson = JSONObject.toJSONString(s);
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/adminbasicservice/adminbasic/stations").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals(response, JSONObject.parseObject(result, Response.class));
    }

}
