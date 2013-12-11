package edu.tcc.screen;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Screen extends JPanel implements ActionListener, Observer<List<String>>{
	
	private static final long serialVersionUID = 7142015044725707085L;
	
	private JButton openConfigurationButton, openDirectoryButton, runButton;
	private JTextArea resultsArea;
	private JFileChooser configurationfileChooser, directoryFileChooser;
	private ScreenController controller;

	public Screen(ScreenController controller) {
		super(new BorderLayout());
		
		this.controller = controller;

		resultsArea = new JTextArea(5,20);
		resultsArea.setMargin(new Insets(5,5,5,5));
		resultsArea.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(resultsArea);

		configurationfileChooser = new JFileChooser();
		
		directoryFileChooser = new JFileChooser();
		directoryFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//directoryFileChooser.setAcceptAllFileFilterUsed(false);

		openConfigurationButton = new JButton("Open a File...");
		openConfigurationButton.addActionListener(this);

		openDirectoryButton = new JButton("Open a directory...");
		openDirectoryButton.addActionListener(this);
		
		runButton = new JButton("Run...");
		runButton.addActionListener(this);

		JPanel buttonPanel = new JPanel(); //use FlowLayout
		buttonPanel.add(openConfigurationButton);
		buttonPanel.add(openDirectoryButton);
		buttonPanel.add(runButton);

		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScrollPane, BorderLayout.CENTER);   
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == openConfigurationButton) 
		{
			int returnVal = configurationfileChooser.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) 
			{
				controller.setConfigurationFilePath(configurationfileChooser.getSelectedFile().toURI());
			} 
		}
		else if (e.getSource() == openDirectoryButton)
		{
			int returnVal = directoryFileChooser.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) 
			{
				controller.setProjectDirectory(directoryFileChooser.getCurrentDirectory().toURI());
			}
		}
		else
		{
			controller.runTestsAndMetrics();
		}
	}

	@Override
	public void update(Subject<List<String>> s) 
	{
		List<String> messages = s.changedState();
		for (String string : messages) {
			resultsArea.append(string);
			resultsArea.append("\n");
		}

	}
}


