package edu.tcc.screen;

import java.util.LinkedList;
import java.util.List;

/**
 * @author carolina.moya
 */

public abstract class Subject {

	List<Observer> observers;

	protected void notifyObservers() {
		for (Observer o : observers) {
			o.update(this);
		}
	}

	public void attach(Observer o) {
		if (observers == null) {
			observers = new LinkedList<Observer>();
		}
		observers.add(o);
	}
}
