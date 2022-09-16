package spring;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringWithRabbitAndMongo {
    @Value("${spring.rabbitmq.app-id}")
    private String appId;

    @Bean
    public Queue queue() {
        return new Queue(appId, true, false, false);
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringWithRabbitAndMongo.class, args);

    }
}
