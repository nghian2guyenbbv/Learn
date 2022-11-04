package redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import redis.service.RedisService;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RedisApplication.class, args);
        RedisService service = context.getBean(RedisService.class);
        try {
            service.saveRedis();
            //service.deleteKey("name");
           /* String name = service.getStringValueFromRedis("name");
            System.out.print("sucess save redis: "+name);*/
            //--------- save list to resdis --//
            List<String> listUser = new ArrayList<String>();
            listUser.add("nghia");
            listUser.add("Ngoc");
            boolean saveListResult = service.saveListToRedis("listTEST", listUser);
            //service.deleteKey("listTEST");
            if (saveListResult) {
                List<String> listUSER = service.getListStringRedis("listTEST");
                if (listUSER != null) {
                    for (String user : listUSER) {
                        System.out.println(user);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
