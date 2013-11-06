package edu.tcc.screen;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author carolina.moya
 */

public class InputView extends JPanel {

	private static final long serialVersionUID = 1L;

	public InputView() {

		JLabel labelProjectDir = new JLabel("Diretório do Projeto:");
		JTextField textFieldProjectDir = new JTextField(20);
		JButton buttonProjectSearch = new JButton("Buscar");
		JLabel labelConfigDir = new JLabel("Arquivo de configuracoes:");
		JTextField textFieldConfigDir = new JTextField(20);
		JButton buttonConfigSearch = new JButton("Buscar");

		add(labelProjectDir);
		add(textFieldProjectDir);
		add(buttonProjectSearch);
		add(labelConfigDir);
		add(textFieldConfigDir);
		add(buttonConfigSearch);

	}

}
