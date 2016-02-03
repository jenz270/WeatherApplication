package main.java.weather;

import javax.swing.SwingUtilities;

/**
 * Swing is a class for the GUI 
 * @author Team 20
 */

public class Swing {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
                try {
                    WeatherFrame window = new WeatherFrame();
                    window.setResizable(false);
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

			}
		});
	}
}