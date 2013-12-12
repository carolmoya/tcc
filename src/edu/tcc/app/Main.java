package edu.tcc.app;

import javax.swing.SwingUtilities;

import edu.tcc.screen.ScreenController;
import edu.tcc.screen.ScreenFactory;
import edu.tcc.screen.ScreenModel;

/**
 * @author carolina.moya
 * @author diego.pinho
 * @author hugo.hennies
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ScreenModel model = new ScreenModel();
            	ScreenController controller = new ScreenController(model);
            	ScreenFactory.newScreen(controller, model);
            }
        });
	}
}
