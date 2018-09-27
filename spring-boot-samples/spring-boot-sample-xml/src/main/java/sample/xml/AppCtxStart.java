package sample.xml;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import sample.xml.service.HelloWorldService;

public class AppCtxStart {

    public static final Logger LOGGER = LoggerFactory.getLogger(AppCtxStart.class);

    public static void main(String[] args) {
        Object[] sources = {HelloWorldService.class};
        SpringApplication springApplication = new SpringApplication(sources);
        springApplication.addListeners(new ApplicationEventApplicationListener());
        springApplication.addInitializers(new ConfigurableApplicationContextApplicationContextInitializer());
        springApplication.getListeners().forEach(applicationListener -> LOGGER.info("application listener {}", applicationListener));
        springApplication.getSources().forEach(o -> LOGGER.info("Source {}", o));
        LOGGER.info(springApplication.getMainApplicationClass().getCanonicalName());
        springApplication.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext context = springApplication.run(args);
        ConfigurableEnvironment environment = context.getEnvironment();
        context.stop();
    }

    private static class ApplicationEventApplicationListener implements ApplicationListener<ApplicationEvent> {
        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            LOGGER.info("Event happened: {}" , event.toString());
        }
    }

    private static class ConfigurableApplicationContextApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            LOGGER.info("Instance of app context {}" , applicationContext);
        }
    }
}
