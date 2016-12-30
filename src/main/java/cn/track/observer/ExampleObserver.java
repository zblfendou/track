package cn.track.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class ExampleObserver implements Observer {
	/**
	 * This method is called whenever the observed object is changed. An
	 * application calls an <tt>Observable</tt> object's
	 * <code>notifyObservers</code> method to have all the object's
	 * observers notified of the change.
	 * @param o
	 * 		the observable object.
	 * @param arg
	 * 		an argument passed to the <code>notifyObservers</code>
	 */
	@Override
	public void update (Observable o, Object arg) {
		ExampleObservable example = (ExampleObservable) o;
		System.out.println ("发生变化:" + example.data);
	}
}
