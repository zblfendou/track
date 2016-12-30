package cn.track.observer;

import java.util.Observable;

/**
 * 被观察者
 */
public class ExampleObservable extends Observable {
	int data = 0;

	public void setData (int data) {
		this.data = data;
		this.setChanged ();//标记此Observable对象为已改变的对象
		this.notifyObservers ();//通知所有观察者
	}
}
