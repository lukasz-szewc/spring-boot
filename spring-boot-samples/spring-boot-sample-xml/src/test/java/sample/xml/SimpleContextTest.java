package sample.xml;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sample.xml.service.HelloWorldService;

public class SimpleContextTest {

    private ConfigurableApplicationContext context;

    @Before
    public void setUp() throws Exception {
        Object[] sources = {HelloWorldService.class};
        SpringApplication springApplication = new SpringApplication(sources);
        context = springApplication.run();
    }

    @After
    public void tearDown() throws Exception {
        context.stop();
    }

    @Test
    public void testName() throws Exception {
        HelloWorldService bean = context.getBean(HelloWorldService.class);

        Assert.assertEquals("durant", bean.getAnotherProperty());
    }
}
