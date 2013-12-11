package edu.tcc.screen;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class ScreenFactory {
	
	public static JFrame newScreen(ScreenController controller, ScreenModel model)
	{
        UIManager.put("swing.boldMetal", Boolean.FALSE); 
        JFrame frame = new JFrame("TCC");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Screen screen = new Screen(controller);
	    model.attach(screen);
	    frame.add(screen);
	 
	    frame.pack();
	    frame.setVisible(true);
		return frame;
	}

}
