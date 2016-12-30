package cn.track.observer;

/**
 * 观察者模式测试类
 */
public class ObserverTest {
	public static void main (String[] args) {
		ExampleObservable example = new ExampleObservable ();
		example.addObserver (new ExampleObserver ());
		example.setData (2);
		example.setData (- 5);
		example.setData (30);

	}
}
