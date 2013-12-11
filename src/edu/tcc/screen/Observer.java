package edu.tcc.screen;


/**
 * @author carolina.moya
 * @param <E>
 */

public interface Observer<E> {

	void update(Subject<E> s);


}
