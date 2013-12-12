package edu.tcc.screen;

import java.util.LinkedList;
import java.util.List;

/**
 * @author carolina.moya
 */
public class ScreenModel extends Subject<List<String>> {

	private List<String> messages = new LinkedList<String>();

	/**
	 * @param message
	 */
	public void addMessage(String message) {
		messages.add(message);
		notifyObservers();
	}

	/**
	 * @return messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	@Override
	public List<String> changedState() {
		return messages;
	}

}
