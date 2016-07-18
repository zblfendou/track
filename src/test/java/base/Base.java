package base;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016.6.21.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration ({"classpath:application-context.xml", "classpath:application-amqp.xml"})
@Rollback (false)
public class Base {
}
