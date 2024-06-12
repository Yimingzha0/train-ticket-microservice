package contacts.init;

import contacts.entity.Config;
import contacts.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author fdse
 */
@Component
public class InitData_Con implements CommandLineRunner{

    @Autowired
    ConfigService service;

    @Override
    public void run(String... args) throws Exception {
        Config config = new Config();

        config.setName("DirectTicketAllocationProportion");
        config.setValue("0.5");
        config.setDescription("Allocation Proportion Of The Direct Ticket - From Start To End");
        service.create(config,null);

    }
}
