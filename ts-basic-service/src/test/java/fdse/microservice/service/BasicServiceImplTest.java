package fdse.microservice.service;

import edu.fudan.common.entity.*;
import edu.fudan.common.util.Response;
import edu.fudan.common.util.StringUtils;
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
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@RunWith(JUnit4.class)
public class BasicServiceImplTest {


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testQueryForTravel() {

    }

    @Test
    public void testQueryForStationId() {

    }

    @Test
    public void testCheckStationExists() {

    }

    @Test
    public void testQueryTrainType() {

    }

}
