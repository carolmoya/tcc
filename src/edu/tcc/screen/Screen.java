package edu.tcc.screen;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


import java.awt.*;
import java.awt.event.*;


/**
 * @author diego.pinho
 */

public class Screen extends JFrame implements ActionListener {
	
	// JTextField
	private JTextField textFieldDir;
	
	//JLabel
	private JLabel labelDir;
	
	//Chechbox
	private Checkbox checkWMC;
	private Checkbox checkDIT;
	private Checkbox checkNOC;
	private Checkbox checkCBO;
	private Checkbox checkRFC;
	private Checkbox checkLCOM;
	
	//Buttons
	private JButton buttonExecute;
	
	
	/**
	 * Initializes the application screen
	 * @since 1.0
	 */
	public void initScreen(){
		setSize(600,600);
		setLocation(380,10);
		setTitle("Projeto de TCC - Versão 1.0");
		setLayout(new FlowLayout());
		
		
		labelDir = new JLabel("Diretório:");
		add(labelDir);
		textFieldDir = new JTextField(20);
		add(textFieldDir);
		
		checkWMC = new Checkbox("WMC",null,false); 
		checkDIT = new Checkbox("DIT",null,false); 
		checkNOC = new Checkbox("NOC",null,false); 
		checkCBO = new Checkbox("CBO",null,false); 
		checkRFC = new Checkbox("RFC",null,false); 
		checkLCOM = new Checkbox("LCOM",null,false); 
		
		add(checkWMC);
		add(checkDIT);
		add(checkNOC);
		add(checkCBO);
		add(checkRFC);
		add(checkLCOM);
		
		buttonExecute = new JButton("Executar Medidas");
		buttonExecute.setCursor(new Cursor (Cursor.HAND_CURSOR));
		add(buttonExecute);
//		jButton.addActionListener(this);
		
		
		setResizable(false);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		//use o método setBounds() para declarar a posição e tamanho dos objetos na tela
//		checkbox1.setBounds(newRectangle(10,20,140,40));
//		checkbox2.setBounds(newRectangle(10,50,100,40));
//		checkbox3.setBounds(newRectangle(10,80,100,40));
		
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
