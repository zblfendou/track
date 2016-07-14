package cn.track.service.dubbo;

/**
 * Created by Administrator on 2016.6.27.
 */
public interface DubboHello {
	String sayHello (String str);

	boolean saveUser (String name, String pwd);
}
