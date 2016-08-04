package cn.track.observer;

import java.util.Observable;

/**
 * Created by Administrator on 2016.8.2.
 */
public class ExampleObservable extends Observable {
	int data = 0;

	public void setData (int data) {
		this.data = data;
		this.setChanged ();//标记此Observable对象为已改变的对象
		this.notifyObservers ();//通知所有观察者
	}
}
