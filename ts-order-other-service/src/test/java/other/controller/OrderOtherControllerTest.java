package other.controller;

import com.alibaba.fastjson.JSONObject;
import edu.fudan.common.entity.Seat;
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
import other.entity.Order;
import other.entity.QueryInfo;
import other.service.OrderOtherService;

import java.util.Date;

@RunWith(JUnit4.class)
public class OrderOtherControllerTest {

    @InjectMocks
    private OrderOtherController orderOtherController;

    @Mock
    private OrderOtherService orderService;
    private MockMvc mockMvc;
    private Response response = new Response();


}
