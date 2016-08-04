package cn.track.observer;

/**
 * Created by Administrator on 2016.8.2.
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
