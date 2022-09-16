package autowrride;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class TestClass {


    public static void main(String[] args) {
        AbcStruct abcStruct = new AbcStruct("nghia",18);
        //System.out.println("abcTestImpl.getName"+ abcTestImpl.getInfo());
        ApplicationContext context =  SpringApplication.run(TestClass.class, args);
        AbcTestImpl abcTest= context.getBean(AbcTestImpl.class);
        AbcStruct abcStructIml = context.getBean(AbcStruct.class);
        System.out.println("abcTest: "+abcTest.getInfo());
        System.out.println("abcStruct: "+abcStructIml.getName());

    }
}
