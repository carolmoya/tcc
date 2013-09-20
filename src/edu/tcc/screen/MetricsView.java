package edu.tcc.screen;

import java.awt.Checkbox;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MetricsView extends JPanel implements Observer{

	private static final long serialVersionUID = 5776288278936793106L;
	
	public MetricsView() {
		
		setSize(400,400);
		
		JLabel labelProjectDir = new JLabel("Diretório do Projeto:");
		JTextField textFieldProjectDir = new JTextField(20);
		JButton buttonProjectSearch = new JButton("Buscar");
		JLabel labelConfigDir = new JLabel("Diretório do Projeto:");
		JTextField textFieldConfigDir = new JTextField(20);
		JButton buttonConfigSearch = new JButton("Buscar");
		Checkbox checkWMC = new Checkbox("WMC",null,false);
		Checkbox checkDIT = new Checkbox("DIT",null,false);
		Checkbox checkNOC = new Checkbox("NOC",null,false);
		Checkbox checkCBO = new Checkbox("CBO",null,false);
		Checkbox checkRFC = new Checkbox("RFC",null,false);
		Checkbox checkLCOM = new Checkbox("LCOM",null,false); 
		JButton buttonExecute = new JButton("Executar Medidas");
		
		add(labelProjectDir);
		add(textFieldProjectDir);
		add (buttonProjectSearch);
		add(labelConfigDir);
		add(textFieldConfigDir);
		add (buttonConfigSearch);
		add(checkWMC);
		add(checkDIT);
		add(checkNOC);
		add(checkCBO);
		add(checkRFC);
		add(checkLCOM);
		add(buttonExecute); 
	} 
	
	
	@Override
	public void update(Subject s) {
		// TODO Auto-generated method stub
		
	}
	
	

}
