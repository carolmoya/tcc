package edu.tcc.screen;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame father = new JFrame();
		MetricsView metricsView = new MetricsView();
		FlowLayout layout = new FlowLayout();
		metricsView.setLayout(layout);
		
		Container contentPane = father.getContentPane();
		
		father.setSize(500,500);
		father.setLocation(380,10);
		father.setTitle("Projeto de TCC - Versão 1.0");
		
		contentPane.add(metricsView);
		
		father.setVisible(true);

		father.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
