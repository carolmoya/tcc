package edu.tcc.screen;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 * @author carolina.moya
 */

public class Screen  {
	
	
		
	public Screen() {
		JFrame father = new JFrame();
		Container contentPane = father.getContentPane();
		father.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InputView inputView = new InputView();
		MetricsView metricsView = new MetricsView();
		
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		FlowLayout childrenlayout = new FlowLayout();
		inputView.setLayout(childrenlayout);
		metricsView.setLayout(childrenlayout);
		
		father.setSize(500,500);
		father.setLocation(380,10);
		father.setTitle("Projeto de TCC - Versão 1.5.2");
		
		inputView.setBorder(BorderFactory.createLineBorder(Color.black));
		metricsView.setBorder(BorderFactory.createLineBorder(Color.black));
		
		contentPane.add(inputView);
		contentPane.add(metricsView);
		
		father.setVisible(true);
	}

	

	
}
