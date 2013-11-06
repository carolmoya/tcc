package edu.tcc.screen;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

/**
 * @author carolina.moya
 */

public class MetricsView extends JPanel implements Observer {

	private static final long serialVersionUID = 5776288278936793106L;

	public MetricsView() {
		JEditorPane output = new JEditorPane();
		output.setEditable(false);
		output.setBorder(BorderFactory.createLineBorder(Color.black));
		add(output);

	}

	@Override
	public void update(Subject s) {
		// TODO Auto-generated method stub
	}

}
