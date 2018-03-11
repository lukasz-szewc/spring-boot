package sample.jsp;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

public class MormalStartWithoutAnnotations {

    public static void main(String[] args) {
        Object[] sources = {
                DispatcherServletAutoConfiguration.class,
                EmbeddedServletContainerAutoConfiguration.class,
                ErrorMvcAutoConfiguration.class,
                HttpEncodingAutoConfiguration.class,
                HttpMessageConvertersAutoConfiguration.class,
                JacksonAutoConfiguration.class,
//                JacksonHttpMessageConvertersConfiguration.class,
                JmxAutoConfiguration.class,
                MultipartAutoConfiguration.class,
                PropertyPlaceholderAutoConfiguration.class,
                ValidationAutoConfiguration.class,
                WebMvcAutoConfiguration.class,
                WebSocketAutoConfiguration.class,
                ServerPropertiesAutoConfiguration.class
        };
        SpringApplication springApplication = new SpringApplication(sources);
        ConfigurableApplicationContext context = springApplication.run(args);


        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            LoggerFactory.getLogger("beanName").warn(beanDefinitionName);
        }

        context.stop();
    }
}
