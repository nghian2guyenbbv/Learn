package spring.ServiceHandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class RabbitController {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "${spring.rabbitmq.app-id}")
    private Message getMessageFromQueue(Message message, byte[] messgageByte) throws Exception {
        JsonNode request = mapper.readTree(new String(messgageByte, "UTF-8"));
        System.out.println("message is:" + request.toString());
        Map<String, String> result = new HashMap<String, String>();
        result.put("status", "200");
        result.put("message", "Function is Ok");
        if (message.getMessageProperties().getReplyTo() != null) {
            try {
                return response(message, messgageByte, result);
            } catch (Exception ex) {
                ex.printStackTrace();
                return response(message, messgageByte, Map.of("status", 200, "data", Map.of("message", ex.getMessage())));
            }
        }
        return null;
    }

    public Message response(Message message, byte[] payload, Object object) throws Exception {
        ObjectNode mapperNode = mapper.createObjectNode();
        mapperNode.set("message", mapper.convertValue(object, JsonNode.class));
        mapperNode.put("payload", payload);
        return MessageBuilder.withBody(mapper.writeValueAsString(object).getBytes()).build();
    }

    public Map<String, Object> response(int code, JsonNode body, Object data) {
        Map<String, Object> res = new HashMap<>();
        res.put("result-code", 200);
        res.put("reference-id", 2001);
        return Map.of("status", 200, "result", res);
    }

    @PostConstruct
    private void init() {
        rabbitTemplate.setReplyTimeout(30000);
    }

}
