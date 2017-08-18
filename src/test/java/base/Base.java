package base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by Administrator on 2016.6.21.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration ({"classpath:application-context.xml", "classpath:application-amqp.xml", "classpath:application-quartz.xml"})
@Rollback (false)
public class Base {
    @Test
    public void ignoreTest() {
        System.out.println("test");
    }
}
