package spring;

import org.springframework.amqp.rabbit.logback.AmqpAppender;
import org.springframework.stereotype.Service;

@Service
public class AmqpService extends AmqpAppender {
    public AmqpService(){
        this.setExchangeName("");
        this.setExchangeType("direct");

    }

}
