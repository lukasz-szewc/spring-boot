package sample.xml;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sample.xml.service.HelloWorldService;

public class AppCtxStart {

    public static void main(String[] args) {
        Object[] sources = {HelloWorldService.class};
        SpringApplication springApplication = new SpringApplication(sources);
        ConfigurableApplicationContext context = springApplication.run(args);

        HelloWorldService bean = context.getBean(HelloWorldService.class);
        System.out.println(bean.getAnotherProperty());

        context.stop();
    }
}
