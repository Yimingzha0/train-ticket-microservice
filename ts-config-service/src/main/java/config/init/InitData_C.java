package config.init;

import config.entity.ConsignPrice;
import config.service.ConsignPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author fdse
 */
@Component
public class InitData_C implements CommandLineRunner {
    @Autowired
    ConsignPriceService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(InitData_C.class);

    @Override
    public void run(String... strings) throws Exception {
        InitData_C.LOGGER.info("[InitData.run][Consign price service][Init data operation]");
        ConsignPrice config = new ConsignPrice();
        config.setId(UUID.randomUUID().toString());
        config.setIndex(0);
        config.setInitialPrice(8);
        config.setInitialWeight(1);
        config.setWithinPrice(2);
        config.setBeyondPrice(4);

        service.createAndModifyPrice(config, null);
    }
}
