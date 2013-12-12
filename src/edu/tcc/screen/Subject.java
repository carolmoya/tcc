package edu.tcc.screen;

import java.util.LinkedList;
import java.util.List;

/**
 * @author carolina.moya
 */

public abstract class Subject<E> {

	List<Observer<E>> observers = new LinkedList<Observer<E>>();

	protected void notifyObservers() {
		for (Observer<E> o : observers) {
			o.update(this);
		}
	}

	public void attach(Observer<E> o) {
		if (observers == null) {
			observers = new LinkedList<Observer<E>>();
		}
		observers.add(o);
	}

	public E changedState() {
		return null;
	}
}
