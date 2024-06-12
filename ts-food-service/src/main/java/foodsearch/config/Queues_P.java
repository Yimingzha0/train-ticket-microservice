package foodsearch.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Queues_P {

    public final static String queueName = "email";

    @Bean
    public Queue emailQueue_P() {
        return new Queue(queueName);
    }
}
