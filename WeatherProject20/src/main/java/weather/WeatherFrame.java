package main.java.weather;


import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;



/**
 * Weather Frame is the GUI for the app
 *
 * @author Team 20
 */

public class WeatherFrame extends JFrame implements Serializable {

	/* Instance Variables */

	private DefaultListModel weatherList;   // Used for location list
	private WeatherData weatherData;
	private JLabel lastUpdatedLabel;    // Tells user the last time the weather was updated
	private JPanel contentPane;         // Main panel that contains everything
    private String currentUnit = "celsius"; // Default value

	private JList locationList;	        // JList of the locations
	private static java.util.ArrayList<WeatherData> locationNames;	//list of the locations
	private String userCityInput;		//what the user enters in the textbox when prompted to enter the city
	private String userCountryInput;	//what the user enters in the textbox when prompted to enter the country
	private String defaultCity; 		//default city added by the user at the start of runtime
	private String defaultCountry;		//default country added by the user at the start of runtime

	private DecimalFormat df;           // Used in formating temperatures

	private BufferedImage refreshImage; // Image used in button to refresh weather

	// Day images
	private BufferedImage icon01d;
	private BufferedImage icon02d;
	private BufferedImage icon03d;
	private BufferedImage icon04d;
	private BufferedImage icon09d;
	private BufferedImage icon11d;
	private BufferedImage icon10d;
	private BufferedImage icon13d;
	private BufferedImage icon50d;

	// Night images
	private BufferedImage icon01n;
	private BufferedImage icon02n;
	private BufferedImage icon03n;
	private BufferedImage icon04n;
	private BufferedImage icon09n;
	private BufferedImage icon11n;
	private BufferedImage icon10n;
	private BufferedImage icon13n;
	private BufferedImage icon50n;

    // Long term weather variables
	private JLabel longTermDay1;
	private JLabel longTermIcon1;
	private JLabel longWeatherCondition1;
	private JLabel longTermTemp1;
	private JLabel longMaxTemp1;
	private JLabel longMinTemp1;

	private JLabel longTermDay2;
	private JLabel longTermIcon2;
	private JLabel longWeatherCondition2;
	private JLabel longTermTemp2;
	private JLabel longMaxTemp2;
	private JLabel longMinTemp2;

	private JLabel longTermDay3;
	private JLabel longTermIcon3;
	private JLabel longWeatherCondition3;
	private JLabel longTermTemp3;
	private JLabel longMaxTemp3;
	private JLabel longMinTemp3;

	private JLabel longTermDay4;
	private JLabel longTermIcon4;
	private JLabel longWeatherCondition4;
	private JLabel longTermTemp4;
	private JLabel longMaxTemp4;
	private JLabel longMinTemp4;

	private JLabel longTermDay5;
	private JLabel longTermIcon5;
	private JLabel longWeatherCondition5;
	private JLabel longTermTemp5;
	private JLabel longMaxTemp5;
	private JLabel longMinTemp5;

    // Short term weather variables
	private JLabel shortTermTime1;
	private JLabel shortTermIcon1;
	private JLabel shortWeatherCondition1;
	private JLabel shortTermTemp1;

	private JLabel shortTermTime2;
	private JLabel shortTermIcon2;
	private JLabel shortWeatherCondition2;
	private JLabel shortTermTemp2;

	private JLabel shortTermTime3;
	private JLabel shortTermIcon3;
	private JLabel shortWeatherCondition3;
	private JLabel shortTermTemp3;

	private JLabel shortTermTime4;
	private JLabel shortTermIcon4;
	private JLabel shortWeatherCondition4;
	private JLabel shortTermTemp4;

	private JLabel shortTermTime5;
	private JLabel shortTermIcon5;
	private JLabel shortWeatherCondition5;
	private JLabel shortTermTemp5;

	private JLabel shortTermTime6;
	private JLabel shortTermIcon6;
	private JLabel shortWeatherCondition6;
	private JLabel shortTermTemp6;

	private JLabel shortTermTime7;
	private JLabel shortTermIcon7;
	private JLabel shortWeatherCondition7;
	private JLabel shortTermTemp7;

	private JLabel shortTermTime8;
	private JLabel shortTermIcon8;
	private JLabel shortWeatherCondition8;
	private JLabel shortTermTemp8;

    // Current weather variables
	private JLabel currLocationLabel;
	private JLabel currWeatherDescriptionLabel;
	private JLabel currSunriseLabel;
	private JLabel currSunsetLabel;
	private JLabel currWeatherIcon;
	private JLabel currWeatherConditionLabel;
	private JLabel currHumidityLabel;
	private JLabel currWindSpeedLabel;
	private JLabel currWindDirection;
	private JLabel currPressureLabel;
	private JLabel currTempOutput;
	private JLabel currLowestTemp;
	private JLabel currHighestTemp;

	private JLabel cityNotFoundText = new JLabel("<html><font color='red'>The city you entered could not be found.<br>  Please check your input and try again.</font></html>");
	private JLabel duplicateText  = new JLabel("<html><font color='red'>You have already added this location.</font></html>");

	private JTabbedPane tabbedWeatherPane;      // Used to display earth and mars weather in separate tabbed windows

    // Mars weather variables
	private JLabel marsConditionLabel;
	private JLabel marsIconLabel;
	private JLabel marsWeatherConditionsLabel;
	private JLabel marsHumidityLabel;
	private JLabel marsWindSpeedLabel;
	private JLabel marsWindDirectionLabel;
	private JLabel marsPressureLabel;
	private JLabel marsCurrentTempLabel;
	private JLabel marsCurrentTempOutput;
	private JLabel marsMinTempLabel;
	private JLabel marsMaxTempLabel;
	private JLabel marsLastUpdatedLabel;
    private String marsWindSpeedCheck;
    private String marsHumidityCheck;
    private float marsMinTempCheck;
    private float marsMaxTempCheck;

	/* Constructor */

	public WeatherFrame() throws IOException {

		initializePrimaryVariables();

		/*****IMAGES*****/

        // Gets weather images from openweathermap.org
		URL url = new URL("http://openweathermap.org/img/w/01d.png");
		icon01d = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/02d.png");
		icon02d = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/03d.png");
		icon03d = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/04d.png");
		icon04d = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/09d.png");
		icon09d = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/10d.png");
		icon10d = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/11d.png");
		icon11d = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/13d.png");
		icon13d = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/50d.png");
		icon50d = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/01n.png");
		icon01n = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/02n.png");
		icon02n = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/03n.png");
		icon03n = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/04n.png");
		icon04n = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/09n.png");
		icon09n = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/10n.png");
		icon10n = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/11n.png");
		icon11n = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/13n.png");
		icon13n = ImageIO.read(url);

		url = new URL("http://openweathermap.org/img/w/50n.png");
		icon50n = ImageIO.read(url);

		refreshImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("update.png"));

		/******END IMAGES*****/

		/******DF FUNCTION******/

		//To keep certain variables to 0 decimal place
		df = new DecimalFormat();
		df.setMaximumFractionDigits(0);

		/******END OF DF FUNCTION******/

		/******WEATHER PANE******/

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		final JPanel LocationPanel = new JPanel();
		LocationPanel.setBackground(Color.DARK_GRAY);

        /* Weather pane for switching between Earth and Mars weather */
		tabbedWeatherPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedWeatherPane.setBackground(Color.DARK_GRAY);
		tabbedWeatherPane.setBorder(null);
		tabbedWeatherPane.setForeground(Color.DARK_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(LocationPanel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
								.addGap(1)
								.addComponent(tabbedWeatherPane, GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(LocationPanel, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
						.addComponent(tabbedWeatherPane, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
		);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		tabbedWeatherPane.addTab("Earth", null, panel, null);
		tabbedWeatherPane.setBackgroundAt(0, new Color(0, 142, 165));
		panel.setLayout(null);

		/******END OF WEATHER PANE******/


		/*****CURRENT WEATHER*****/

		JPanel currWeatherPanel = new JPanel();
		currWeatherPanel.setBounds(0, 0, 621, 262);
		panel.add(currWeatherPanel);
		currWeatherPanel.setBackground(new Color(70, 130, 180));
		currWeatherPanel.setLayout(null);

		currLocationLabel = new JLabel(weatherData.getCurrentWeather().getCurrentCity() + ", " + weatherData.getCurrentWeather().getCountryCode());
		currLocationLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		currLocationLabel.setBounds(10, 11, 400, 40);
		currLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		currWeatherPanel.add(currLocationLabel);

		currSunriseLabel = new JLabel("Sunrise: " + weatherData.getCurrentWeather().getSunrise());
		currSunriseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currSunriseLabel.setBounds(181, 202, 200, 14);
		currWeatherPanel.add(currSunriseLabel);

		currSunsetLabel = new JLabel("Sunset: " + weatherData.getCurrentWeather().getSunset());
		currSunsetLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currSunsetLabel.setBounds(181, 227, 200, 14);
		currWeatherPanel.add(currSunsetLabel);

		currWeatherDescriptionLabel = new JLabel("Conditions: " + weatherData.getCurrentWeather().getDescription());
		currWeatherDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currWeatherDescriptionLabel.setBounds(10, 151, 400, 24);
		currWeatherPanel.add(currWeatherDescriptionLabel);

		// Adds an image
		currWeatherIcon = new JLabel(new ImageIcon(displayCorrectImage(weatherData.getCurrentWeather().getIcon())));
		currWeatherIcon.setBounds(10, 47, 75, 75);
		currWeatherPanel.add(currWeatherIcon);

		currWeatherConditionLabel = new JLabel("Weather Conditions");
		currWeatherConditionLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		currWeatherConditionLabel.setBounds(10, 127, 250, 24);
		currWeatherPanel.add(currWeatherConditionLabel);

		currHumidityLabel = new JLabel("Humidity: " + weatherData.getCurrentWeather().getHumidity() + "%\r\n");
		currHumidityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currHumidityLabel.setBounds(10, 197, 170, 24);
		currWeatherPanel.add(currHumidityLabel);


		currWindSpeedLabel = new JLabel("Wind Speed: " + df.format(weatherData.getCurrentWeather().getWindSpeed()) + " km/h\r\n");
		currWindSpeedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currWindSpeedLabel.setBounds(10, 174, 170, 24);
		currWeatherPanel.add(currWindSpeedLabel);


		currWindDirection = new JLabel("Wind Direction: " + weatherData.getCurrentWeather().getWindDirectionString());
		currWindDirection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currWindDirection.setBounds(181, 174, 200, 24);
		currWeatherPanel.add(currWindDirection);


		currPressureLabel = new JLabel("Pressure: " + df.format(weatherData.getCurrentWeather().getAirPressure()) + " kPa\r\n");
		currPressureLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currPressureLabel.setBounds(10, 221, 150, 24);
		currWeatherPanel.add(currPressureLabel);

		JLabel currTemp = new JLabel("Current Temperature: ");
		currTemp.setBounds(330, 22, 183, 50);
		currWeatherPanel.add(currTemp);


		currTempOutput = new JLabel(df.format(weatherData.getCurrentWeather().getTemperature()) + "\u00B0");
		currTempOutput.setFont(new Font("Tahoma", Font.PLAIN, 56));
		currTempOutput.setBounds(330, 46, 250, 68);
		currWeatherPanel.add(currTempOutput);


		currLowestTemp = new JLabel("\u2207" + df.format(weatherData.getCurrentWeather().getMinTemp()) + "\u00B0");
		currLowestTemp.setBounds(397, 125, 60, 15);
		currWeatherPanel.add(currLowestTemp);

		currHighestTemp = new JLabel("\u25B2" + df.format(weatherData.getCurrentWeather().getMaxTemp()) + "\u00B0");
		currHighestTemp.setBounds(330, 125, 60, 14);
		currWeatherPanel.add(currHighestTemp);

		lastUpdatedLabel = new JLabel("Last updated: " + weatherData.getCurrentWeather().getLastUpdatedTime());
		lastUpdatedLabel.setBounds(393, 227, 220, 14);
		currWeatherPanel.add(lastUpdatedLabel);

		JButton currRefreshButton = new JButton(new ImageIcon(refreshImage));
		currRefreshButton.setContentAreaFilled(false);
		currRefreshButton.setBounds(561, 11, 40, 40);
		currWeatherPanel.add(currRefreshButton);
        currRefreshButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						refreshGUI();
					}
				});

		/******END OF CURRENT WEATHER******/

		/////////////////////////////////////////////////

		/******SHORT TERM WEATHER******/
		int shortTermCounter = 0; //counts the getNext_24 method which will give the next (3hours) time in the next 24
		JPanel shortTermFullPanel = new JPanel();
		shortTermFullPanel.setBounds(0, 264, 621, 139);
		panel.add(shortTermFullPanel);
		shortTermFullPanel.setBackground(new Color(255, 69, 0));
		shortTermFullPanel.setLayout(null);

		JPanel shortTermPanel1 = new JPanel();
		shortTermPanel1.setBackground(new Color(255, 153, 0));
		shortTermPanel1.setBounds(11, 11, 60, 116);
		shortTermFullPanel.add(shortTermPanel1);
		shortTermPanel1.setLayout(null);

		shortTermTime1 = new JLabel("" + weatherData.getNext_24()[shortTermCounter++]);
		shortTermTime1.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTime1.setBounds(0, 11, 60, 14);
		shortTermPanel1.add(shortTermTime1);

		// Adds an image
		shortTermIcon1 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[0].getIcon())));
		shortTermIcon1.setBounds(10, 28, 40, 40);
		shortTermPanel1.add(shortTermIcon1);

		shortTermTemp1 = new JLabel(df.format(weatherData.shortTermWeather[0].getTemperature()) + "\u00B0");
		shortTermTemp1.setFont(new Font("Tahoma", Font.BOLD, 13));
		shortTermTemp1.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTemp1.setBounds(10, 79, 40, 26);
		shortTermPanel1.add(shortTermTemp1);

		shortWeatherCondition1 = new JLabel(weatherData.shortTermWeather[0].getCondition());
		shortWeatherCondition1.setHorizontalAlignment(SwingConstants.CENTER);
		shortWeatherCondition1.setBounds(0, 68, 60, 14);
		shortTermPanel1.add(shortWeatherCondition1);

		JPanel shortTermPanel2 = new JPanel();
		shortTermPanel2.setBackground(new Color(255, 153, 0));
		shortTermPanel2.setBounds(82, 11, 66, 116);
		shortTermFullPanel.add(shortTermPanel2);
		shortTermPanel2.setLayout(null);

		shortTermTime2 = new JLabel("" + weatherData.getNext_24()[shortTermCounter++]);
		shortTermTime2.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTime2.setBounds(0, 11, 66, 14);
		shortTermPanel2.add(shortTermTime2);

		// Adds an image
		shortTermIcon2 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[1].getIcon())));
		shortTermIcon2.setBounds(10, 28, 40, 40);
		shortTermPanel2.add(shortTermIcon2);

		shortWeatherCondition2 = new JLabel(weatherData.shortTermWeather[1].getCondition());
		shortWeatherCondition2.setHorizontalAlignment(SwingConstants.CENTER);
		shortWeatherCondition2.setBounds(0, 68, 66, 14);
		shortTermPanel2.add(shortWeatherCondition2);

		shortTermTemp2 = new JLabel(df.format(weatherData.shortTermWeather[1].getTemperature()) + "\u00B0");
		shortTermTemp2.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTemp2.setFont(new Font("Tahoma", Font.BOLD, 13));
		shortTermTemp2.setBounds(10, 79, 40, 26);
		shortTermPanel2.add(shortTermTemp2);

		JPanel shortTermPanel3 = new JPanel();
		shortTermPanel3.setBackground(new Color(255, 153, 0));
		shortTermPanel3.setBounds(159, 11, 66, 116);
		shortTermFullPanel.add(shortTermPanel3);
		shortTermPanel3.setLayout(null);

		shortTermTime3 = new JLabel("" + weatherData.getNext_24()[shortTermCounter++]);
		shortTermTime3.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTime3.setBounds(0, 11, 66, 14);
		shortTermPanel3.add(shortTermTime3);

		// Adds an image
		shortTermIcon3 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[2].getIcon())));
		shortTermIcon3.setBounds(10, 28, 40, 40);
		shortTermPanel3.add(shortTermIcon3);

		shortWeatherCondition3 = new JLabel(weatherData.shortTermWeather[2].getCondition());
		shortWeatherCondition3.setHorizontalAlignment(SwingConstants.CENTER);
		shortWeatherCondition3.setBounds(0, 68, 66, 14);
		shortTermPanel3.add(shortWeatherCondition3);

		shortTermTemp3 = new JLabel(df.format(weatherData.shortTermWeather[3].getTemperature()) + "\u00B0");
		shortTermTemp3.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTemp3.setFont(new Font("Tahoma", Font.BOLD, 13));
		shortTermTemp3.setBounds(10, 79, 40, 26);
		shortTermPanel3.add(shortTermTemp3);

		JPanel shortTermPanel4 = new JPanel();
		shortTermPanel4.setBackground(new Color(255, 153, 0));
		shortTermPanel4.setBounds(236, 11, 66, 116);
		shortTermFullPanel.add(shortTermPanel4);
		shortTermPanel4.setLayout(null);

		shortTermTime4 = new JLabel("" + weatherData.getNext_24()[shortTermCounter++]);
		shortTermTime4.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTime4.setBounds(0, 11, 66, 14);
		shortTermPanel4.add(shortTermTime4);

		// Adds an image
		shortTermIcon4 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[3].getIcon())));
		shortTermIcon4.setBounds(10, 28, 40, 40);
		shortTermPanel4.add(shortTermIcon4);

		shortWeatherCondition4 = new JLabel(weatherData.shortTermWeather[3].getCondition());
		shortWeatherCondition4.setHorizontalAlignment(SwingConstants.CENTER);
		shortWeatherCondition4.setBounds(0, 68, 66, 14);
		shortTermPanel4.add(shortWeatherCondition4);

		shortTermTemp4 = new JLabel(df.format(weatherData.shortTermWeather[3].getTemperature()) + "\u00B0");
		shortTermTemp4.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTemp4.setFont(new Font("Tahoma", Font.BOLD, 13));
		shortTermTemp4.setBounds(10, 79, 40, 26);
		shortTermPanel4.add(shortTermTemp4);

		JPanel shortTermPanel5 = new JPanel();
		shortTermPanel5.setBackground(new Color(255, 153, 0));
		shortTermPanel5.setBounds(313, 11, 66, 116);
		shortTermFullPanel.add(shortTermPanel5);
		shortTermPanel5.setLayout(null);

		shortTermTime5 = new JLabel("" + weatherData.getNext_24()[shortTermCounter++]);
		shortTermTime5.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTime5.setBounds(0, 11, 66, 14);
		shortTermPanel5.add(shortTermTime5);
		shortTermIcon5 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[4].getIcon())));
		shortTermIcon5.setBounds(10, 28, 40, 40);
		shortTermPanel5.add(shortTermIcon5);

		shortWeatherCondition5 = new JLabel(weatherData.shortTermWeather[4].getCondition());
		shortWeatherCondition5.setHorizontalAlignment(SwingConstants.CENTER);
		shortWeatherCondition5.setBounds(0, 68, 66, 14);
		shortTermPanel5.add(shortWeatherCondition5);

		shortTermTemp5 = new JLabel(df.format(weatherData.shortTermWeather[4].getTemperature()) + "\u00B0");
		shortTermTemp5.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTemp5.setFont(new Font("Tahoma", Font.BOLD, 13));
		shortTermTemp5.setBounds(10, 79, 40, 26);
		shortTermPanel5.add(shortTermTemp5);

		JPanel shortTermPanel6 = new JPanel();
		shortTermPanel6.setBackground(new Color(255, 153, 0));
		shortTermPanel6.setBounds(390, 11, 66, 116);
		shortTermFullPanel.add(shortTermPanel6);
		shortTermPanel6.setLayout(null);

		shortTermTime6 = new JLabel("" + weatherData.getNext_24()[shortTermCounter++]);
		shortTermTime6.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTime6.setBounds(0, 11, 66, 14);
		shortTermPanel6.add(shortTermTime6);

		// Adds an image
		shortTermIcon6 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[5].getIcon())));
		shortTermIcon6.setBounds(10, 28, 40, 40);
		shortTermPanel6.add(shortTermIcon6);

		shortWeatherCondition6 = new JLabel(weatherData.shortTermWeather[5].getCondition());
		shortWeatherCondition6.setHorizontalAlignment(SwingConstants.CENTER);
		shortWeatherCondition6.setBounds(0, 68, 66, 14);
		shortTermPanel6.add(shortWeatherCondition6);

		shortTermTemp6 = new JLabel(df.format(weatherData.shortTermWeather[5].getTemperature()) + "\u00B0");
		shortTermTemp6.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTemp6.setFont(new Font("Tahoma", Font.BOLD, 13));
		shortTermTemp6.setBounds(10, 79, 40, 26);
		shortTermPanel6.add(shortTermTemp6);

		JPanel shortTermPanel7 = new JPanel();
		shortTermPanel7.setBackground(new Color(255, 153, 0));
		shortTermPanel7.setBounds(467, 11, 66, 116);
		shortTermFullPanel.add(shortTermPanel7);
		shortTermPanel7.setLayout(null);

		shortTermTime7 = new JLabel("" + weatherData.getNext_24()[shortTermCounter++]);
		shortTermTime7.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTime7.setBounds(0, 11, 66, 14);
		shortTermPanel7.add(shortTermTime7);

		// Add image
		shortTermIcon7 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[6].getIcon())));
		shortTermIcon7.setBounds(10, 28, 40, 40);
		shortTermPanel7.add(shortTermIcon7);

		shortWeatherCondition7 = new JLabel(weatherData.shortTermWeather[6].getCondition());
		shortWeatherCondition7.setHorizontalAlignment(SwingConstants.CENTER);
		shortWeatherCondition7.setBounds(0, 68, 66, 14);
		shortTermPanel7.add(shortWeatherCondition7);

		shortTermTemp7 = new JLabel(df.format(weatherData.shortTermWeather[6].getTemperature()) + "\u00B0");
		shortTermTemp7.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTemp7.setFont(new Font("Tahoma", Font.BOLD, 13));
		shortTermTemp7.setBounds(10, 79, 40, 26);
		shortTermPanel7.add(shortTermTemp7);

		JPanel shortTermPanel8 = new JPanel();
		shortTermPanel8.setBackground(new Color(255, 153, 0));
		shortTermPanel8.setBounds(544, 11, 66, 116);
		shortTermFullPanel.add(shortTermPanel8);
		shortTermPanel8.setLayout(null);

		shortTermTime8 = new JLabel("" + weatherData.getNext_24()[shortTermCounter++]);
		shortTermTime8.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTime8.setBounds(0, 11, 66, 14);
		shortTermPanel8.add(shortTermTime8);

		// Adds an image
		shortTermIcon8 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[7].getIcon())));
		shortTermIcon8.setBounds(10, 28, 40, 40);
		shortTermPanel8.add(shortTermIcon8);

		shortWeatherCondition8 = new JLabel(weatherData.shortTermWeather[7].getCondition());
		shortWeatherCondition8.setHorizontalAlignment(SwingConstants.CENTER);
		shortWeatherCondition8.setBounds(0, 68, 66, 14);
		shortTermPanel8.add(shortWeatherCondition8);

		shortTermTemp8 = new JLabel(df.format(weatherData.shortTermWeather[7].getTemperature()) + "\u00B0");
		shortTermTemp8.setHorizontalAlignment(SwingConstants.CENTER);
		shortTermTemp8.setFont(new Font("Tahoma", Font.BOLD, 13));
		shortTermTemp8.setBounds(10, 79, 40, 26);
		shortTermPanel8.add(shortTermTemp8);

		/******END OF SHORT TERM WEATHER******/

		//////////////////////////////////////////////

		/*******LONG TERM WEATHER******/

		int longTermDayCounter = 0;
		JPanel longTermFullPanel = new JPanel();
		longTermFullPanel.setBounds(0, 405, 621, 172);
		panel.add(longTermFullPanel);
		longTermFullPanel.setBackground(new Color(255, 69, 0));
		longTermFullPanel.setLayout(null);

		JPanel longTermPanel1 = new JPanel();
		longTermPanel1.setBackground(new Color(255, 153, 0));
		longTermPanel1.setBounds(10, 11, 111, 149);
		longTermFullPanel.add(longTermPanel1);
		longTermPanel1.setLayout(null);

		longTermDay1 = new JLabel(weatherData.getNext_5()[longTermDayCounter++]);
		longTermDay1.setHorizontalAlignment(SwingConstants.CENTER);
		longTermDay1.setBounds(0, 11, 111, 14);
		longTermPanel1.add(longTermDay1);

		// Adds an image
		longTermIcon1 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[0].getIcon())));
		longTermIcon1.setBounds(0, 30, 89, 50);
		longTermPanel1.add(longTermIcon1);

		longWeatherCondition1 = new JLabel(weatherData.longTermWeather[0].getCondition());
		longWeatherCondition1.setHorizontalAlignment(SwingConstants.CENTER);
		longWeatherCondition1.setBounds(0, 84, 89, 14);
		longTermPanel1.add(longWeatherCondition1);

		longTermTemp1 = new JLabel(df.format(weatherData.longTermWeather[0].getTemperature()) + "\u00B0");
		longTermTemp1.setFont(new Font("Tahoma", Font.BOLD, 16));
		longTermTemp1.setHorizontalAlignment(SwingConstants.CENTER);
		longTermTemp1.setBounds(0, 103, 89, 20);
		longTermPanel1.add(longTermTemp1);

		longMaxTemp1 = new JLabel("\u25B2" + df.format(weatherData.longTermWeather[0].getMax()));
		longMaxTemp1.setBounds(10, 123, 48, 14);
		longTermPanel1.add(longMaxTemp1);

		longMinTemp1 = new JLabel("\u2207" + df.format(weatherData.longTermWeather[0].getMin()));
		longMinTemp1.setHorizontalAlignment(SwingConstants.RIGHT);
		longMinTemp1.setBounds(51, 123, 48, 15);
		longTermPanel1.add(longMinTemp1);

		JPanel longTermPanel2 = new JPanel();
		longTermPanel2.setBackground(new Color(255, 153, 0));
		longTermPanel2.setBounds(132, 11, 111, 149);
		longTermFullPanel.add(longTermPanel2);
		longTermPanel2.setLayout(null);

		longTermDay2 = new JLabel(weatherData.getNext_5()[longTermDayCounter++]);
		longTermDay2.setHorizontalAlignment(SwingConstants.CENTER);
		longTermDay2.setBounds(0, 11, 111, 14);
		longTermPanel2.add(longTermDay2);

		// Adds an image
		longTermIcon2 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[1].getIcon())));
		longTermIcon2.setBounds(0, 30, 111, 50);
		longTermPanel2.add(longTermIcon2);

		longWeatherCondition2 = new JLabel(weatherData.longTermWeather[1].getCondition());
		longWeatherCondition2.setHorizontalAlignment(SwingConstants.CENTER);
		longWeatherCondition2.setBounds(0, 84, 111, 14);
		longTermPanel2.add(longWeatherCondition2);

		longTermTemp2 = new JLabel(df.format(weatherData.longTermWeather[1].getTemperature()) + "\u00B0");
		longTermTemp2.setHorizontalAlignment(SwingConstants.CENTER);
		longTermTemp2.setFont(new Font("Tahoma", Font.BOLD, 16));
		longTermTemp2.setBounds(0, 103, 111, 20);
		longTermPanel2.add(longTermTemp2);

		longMaxTemp2 = new JLabel("\u25B2" + df.format(weatherData.longTermWeather[1].getMax()));
		longMaxTemp2.setBounds(10, 123, 48, 14);
		longTermPanel2.add(longMaxTemp2);

		longMinTemp2 = new JLabel("\u2207" + df.format(weatherData.longTermWeather[1].getMin()));
		longMinTemp2.setHorizontalAlignment(SwingConstants.RIGHT);
		longMinTemp2.setBounds(49, 123, 48, 15);
		longTermPanel2.add(longMinTemp2);

		JPanel longTermPanel3 = new JPanel();
		longTermPanel3.setBackground(new Color(255, 153, 0));
		longTermPanel3.setBounds(254, 11, 111, 149);
		longTermFullPanel.add(longTermPanel3);
		longTermPanel3.setLayout(null);

		longTermDay3 = new JLabel(weatherData.getNext_5()[longTermDayCounter++]);
		longTermDay3.setHorizontalAlignment(SwingConstants.CENTER);
		longTermDay3.setBounds(0, 11, 111, 14);
		longTermPanel3.add(longTermDay3);

		// Adds an image
		longTermIcon3 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[2].getIcon())));
		longTermIcon3.setBounds(0, 30, 111, 50);
		longTermPanel3.add(longTermIcon3);

		longWeatherCondition3 = new JLabel(weatherData.longTermWeather[2].getCondition());
		longWeatherCondition3.setHorizontalAlignment(SwingConstants.CENTER);
		longWeatherCondition3.setBounds(0, 84, 111, 14);
		longTermPanel3.add(longWeatherCondition3);

		longTermTemp3 = new JLabel(df.format(weatherData.longTermWeather[2].getTemperature()) + "\u00B0");
		longTermTemp3.setHorizontalAlignment(SwingConstants.CENTER);
		longTermTemp3.setFont(new Font("Tahoma", Font.BOLD, 16));
		longTermTemp3.setBounds(0, 103, 111, 20);
		longTermPanel3.add(longTermTemp3);

		longMaxTemp3 = new JLabel("\u25B2" + df.format(weatherData.longTermWeather[2].getMax()));
		longMaxTemp3.setBounds(10, 123, 48, 14);
		longTermPanel3.add(longMaxTemp3);

		longMinTemp3 = new JLabel("\u2207" + df.format(weatherData.longTermWeather[2].getMin()));
		longMinTemp3.setHorizontalAlignment(SwingConstants.RIGHT);
		longMinTemp3.setBounds(51, 123, 48, 15);
		longTermPanel3.add(longMinTemp3);

		JPanel longTermPanel4 = new JPanel();
		longTermPanel4.setBackground(new Color(255, 153, 0));
		longTermPanel4.setBounds(376, 11, 111, 149);
		longTermFullPanel.add(longTermPanel4);
		longTermPanel4.setLayout(null);

		longTermDay4 = new JLabel(weatherData.getNext_5()[longTermDayCounter++]);
		longTermDay4.setHorizontalAlignment(SwingConstants.CENTER);
		longTermDay4.setBounds(0, 11, 111, 14);
		longTermPanel4.add(longTermDay4);

		// Adds an image
		longTermIcon4 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[3].getIcon())));
		longTermIcon4.setBounds(0, 30, 111, 50);
		longTermPanel4.add(longTermIcon4);

		longWeatherCondition4 = new JLabel(weatherData.longTermWeather[3].getCondition());
		longWeatherCondition4.setHorizontalAlignment(SwingConstants.CENTER);
		longWeatherCondition4.setBounds(0, 84, 111, 14);
		longTermPanel4.add(longWeatherCondition4);

		longTermTemp4 = new JLabel(df.format(weatherData.longTermWeather[3].getTemperature()) + "\u00B0");
		longTermTemp4.setHorizontalAlignment(SwingConstants.CENTER);
		longTermTemp4.setFont(new Font("Tahoma", Font.BOLD, 16));
		longTermTemp4.setBounds(0, 103, 111, 20);
		longTermPanel4.add(longTermTemp4);

		longMaxTemp4 = new JLabel("\u25B2" + df.format(weatherData.longTermWeather[3].getMax()));
		longMaxTemp4.setBounds(10, 123, 48, 14);
		longTermPanel4.add(longMaxTemp4);

		longMinTemp4 = new JLabel("\u2207" + df.format(weatherData.longTermWeather[3].getMin()));
		longMinTemp4.setHorizontalAlignment(SwingConstants.RIGHT);
		longMinTemp4.setBounds(51, 123, 48, 15);
		longTermPanel4.add(longMinTemp4);

		JPanel longTermPanel5 = new JPanel();
		longTermPanel5.setBackground(new Color(255, 153, 0));
		longTermPanel5.setBounds(498, 11, 111, 149);
		longTermFullPanel.add(longTermPanel5);
		longTermPanel5.setLayout(null);

		longTermDay5 = new JLabel(weatherData.getNext_5()[longTermDayCounter++]);
		longTermDay5.setHorizontalAlignment(SwingConstants.CENTER);
		longTermDay5.setBounds(0, 11, 111, 14);
		longTermPanel5.add(longTermDay5);

		// Adds an image
		longTermIcon5 = new JLabel(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[4].getIcon())));
		longTermIcon5.setBounds(0, 30, 111, 50);
		longTermPanel5.add(longTermIcon5);

		longWeatherCondition5 = new JLabel(weatherData.longTermWeather[4].getCondition());
		longWeatherCondition5.setHorizontalAlignment(SwingConstants.CENTER);
		longWeatherCondition5.setBounds(0, 84, 111, 14);
		longTermPanel5.add(longWeatherCondition5);

		longTermTemp5 = new JLabel(df.format(weatherData.longTermWeather[4].getTemperature()) + "\u00B0");
		longTermTemp5.setHorizontalAlignment(SwingConstants.CENTER);
		longTermTemp5.setFont(new Font("Tahoma", Font.BOLD, 16));
		longTermTemp5.setBounds(0, 103, 111, 20);
		longTermPanel5.add(longTermTemp5);

		longMaxTemp5 = new JLabel("\u25B2" + df.format(weatherData.longTermWeather[4].getMax()));
		longMaxTemp5.setBounds(10, 123, 48, 14);
		longTermPanel5.add(longMaxTemp5);

		longMinTemp5 = new JLabel("\u2207" + df.format(weatherData.longTermWeather[4].getMin()));
		longMinTemp5.setHorizontalAlignment(SwingConstants.RIGHT);
		longMinTemp5.setBounds(51, 123, 48, 15);
		longTermPanel5.add(longMinTemp5);

		/******END OF LONG TERM WEATHER******/

		////////////////////////////////////////////////////

		/******MARS WEATHER******//////

		JPanel marsTabbedPanel = new JPanel();
		marsTabbedPanel.setLayout(null);
		tabbedWeatherPane.addTab("Mars", null, marsTabbedPanel, null);
		tabbedWeatherPane.setBackgroundAt(1, new Color(255, 0, 0));

		JPanel marsPanel = new JPanel();
		marsPanel.setLayout(null);
		marsPanel.setBackground(new Color(255, 69, 0));
		marsPanel.setBounds(0, 0, 626, 578);
		marsTabbedPanel.add(marsPanel);

		JLabel marsLocationLabel = new JLabel("Mars, Universe");
		marsLocationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		marsLocationLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		marsLocationLabel.setBounds(10, 11, 400, 24);
		marsPanel.add(marsLocationLabel);

		marsConditionLabel = new JLabel("Conditions: " + weatherData.getWeatherMars().getSkyCondition());
		marsConditionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		marsConditionLabel.setBounds(10, 151, 400, 24);
		marsPanel.add(marsConditionLabel);

		// Adds an image
		marsIconLabel = new JLabel(new ImageIcon(displayCorrectImage(weatherData.getWeatherMars().getSkyCondition())));
		marsIconLabel.setBounds(10, 47, 75, 75);
		marsPanel.add(marsIconLabel);

		marsWeatherConditionsLabel = new JLabel("Weather Conditions");
		marsWeatherConditionsLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		marsWeatherConditionsLabel.setBounds(10, 127, 250, 24);
		marsPanel.add(marsWeatherConditionsLabel);

        marsHumidityCheck = weatherData.getWeatherMars().getHumidity();
        // Checks for null value and replaces with N/A
        if(marsHumidityCheck == null) {
            marsHumidityLabel = new JLabel("Humidity: N/A");
        } else {
            marsHumidityLabel = new JLabel("Humidity: " + marsHumidityCheck);
        }
		marsHumidityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		marsHumidityLabel.setBounds(10, 220, 200, 24);
		marsPanel.add(marsHumidityLabel);

        marsWindSpeedCheck = weatherData.getWeatherMars().getWindSpeed();
        // Checks for null value and replaces with N/A
        if(marsWindSpeedCheck == null) {
            marsWindSpeedLabel = new JLabel("Wind Speed: N/A");
        } else {
            marsWindSpeedLabel = new JLabel("Wind Speed: " + marsWindSpeedCheck);
        }
		marsWindSpeedLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		marsWindSpeedLabel.setBounds(10, 174, 200, 24);
		marsPanel.add(marsWindSpeedLabel);

		marsWindDirectionLabel = new JLabel("Wind Direction: " + weatherData.getWeatherMars().getWindDirection());
		marsWindDirectionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		marsWindDirectionLabel.setBounds(10, 198, 200, 24);
		marsPanel.add(marsWindDirectionLabel);

		marsPressureLabel = new JLabel("Pressure: " + weatherData.getWeatherMars().getAirpressure() + "kPa");
		marsPressureLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		marsPressureLabel.setBounds(10, 244, 200, 24);
		marsPanel.add(marsPressureLabel);

		marsCurrentTempLabel = new JLabel("Average Temperature: ");
		marsCurrentTempLabel.setBounds(330, 22, 200, 50);
		marsPanel.add(marsCurrentTempLabel);

        // Decides what weather to get based on current units
        if(currentUnit.equals("celsius")) {
            marsMinTempCheck = weatherData.getWeatherMars().getTemperatureMin();
            marsMaxTempCheck = weatherData.getWeatherMars().getTemperatureMax();
        } else {
            marsMinTempCheck = weatherData.getWeatherMars().getTemperatureMinFahrenheit();
            marsMaxTempCheck = weatherData.getWeatherMars().getTemperatureMaxFahrenheit();
        }
		marsMinTempLabel = new JLabel("\u2207" + marsMinTempCheck + "\u00B0");
		marsMinTempLabel.setBounds(400, 125, 80, 15);
		marsPanel.add(marsMinTempLabel);

		marsMaxTempLabel = new JLabel("\u25B2" + marsMaxTempCheck + "\u00B0");
		marsMaxTempLabel.setBounds(333, 125, 80, 14);
		marsPanel.add(marsMaxTempLabel);

        marsCurrentTempOutput = new JLabel(((marsMaxTempCheck + marsMinTempCheck) / 2) + "\u00B0");
        marsCurrentTempOutput.setFont(new Font("Tahoma", Font.PLAIN, 56));
        marsCurrentTempOutput.setBounds(330, 46, 250, 68);
        marsPanel.add(marsCurrentTempOutput);

		marsLastUpdatedLabel = new JLabel("Last updated: " + weatherData.getCurrentWeather().getLastUpdatedTime());
		marsLastUpdatedLabel.setBounds(384, 251, 220, 14);
		marsPanel.add(marsLastUpdatedLabel);

		JButton marsRefreshButton = new JButton(new ImageIcon(refreshImage));
		marsRefreshButton.setContentAreaFilled(false);
		marsRefreshButton.setBounds(561, 11, 40, 40);
		marsPanel.add(marsRefreshButton);
        marsRefreshButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						refreshMarsGUI();
					}
				});

		/******END OF MARS WEATHER******/


		/******MENU BAR******/

		JMenuBar menubar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		mnuFile.setMnemonic(KeyEvent.VK_F);
		JMenuItem mniSave = new JMenuItem("Save");
		mniSave.setMnemonic(KeyEvent.VK_S);
		mniSave.setToolTipText("Save");
		mniSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				toSaveLocations();
			}
		});
		mnuFile.add(mniSave);
		JMenuItem mniLoad = new JMenuItem("Load");
        mniLoad.setMnemonic(KeyEvent.VK_L);
		mniLoad.setToolTipText("Load");
		mniLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				toLoadLocations();
			}
		});
		mnuFile.add(mniLoad);
		JMenuItem mniFileExit = new JMenuItem("Exit");
		mniFileExit.setMnemonic(KeyEvent.VK_E);
		mniFileExit.setToolTipText("Exit application");
		mniFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		mnuFile.add(mniFileExit);
		menubar.add(mnuFile);


		// Creates menu item to choose units
		JMenu mnuUnits = new JMenu("Units");
		mnuUnits.setMnemonic(KeyEvent.VK_U);
		JMenuItem mniMetric = new JMenuItem("Celsius");
		mniMetric.setMnemonic(KeyEvent.VK_C);
		mniMetric.setToolTipText("Change temperature to Celsius");
		mniMetric.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				String units = weatherData.getCurrentWeather().getUnits();
				weatherData.changeTemperatureUnits(units, "celsius");
                currentUnit = "celsius";
				changeUnits();
			}
		});
		mnuUnits.add(mniMetric);
		JMenuItem mniImperial = new JMenuItem("Fahrenheit");
		mniImperial.setMnemonic(KeyEvent.VK_F);
		mniImperial.setToolTipText("Change temperature to Fahrenheit");
		mniImperial.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				String units = weatherData.getCurrentWeather().getUnits();
				weatherData.changeTemperatureUnits(units, "fahrenheit");
                currentUnit = "fahrenheit";
                changeUnits();
			}
		});
		mnuUnits.add(mniImperial);
		menubar.add(mnuUnits);
		setJMenuBar(menubar);

		/******END MENU BAR******/

		////////////////////////////////////////////

		/******LOCATIONS******/



		final JScrollPane pane = new JScrollPane(locationList);
		pane.setBounds(10, 25, 180, 505);

		//Switching the current weatherData when JList object is selected
		locationList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				locationList = (JList) e.getSource();
				if (e.getClickCount() == 1) {        //If an object is clicked then:
					if (SwingUtilities.isLeftMouseButton(e)) {
						weatherData = changeWeatherLocation((String) locationList.getSelectedValue());
						refreshGUI();
					} else if (SwingUtilities.isRightMouseButton(e)) {
						final JPopupMenu deleteMenu = new JPopupMenu("Delete");
						JMenuItem deleteButton = new JMenuItem("Delete");
						deleteMenu.add(deleteButton);

						deleteMenu.show(e.getComponent(), e.getX(), e.getY());
						locationList.setSelectedIndex(locationList.getSelectedIndex());
						deleteButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								deleteMenu.setVisible(false);
								removeLocationList((String)locationList.getSelectedValue());
								weatherList.remove(locationList.getSelectedIndex());
							}
						});
					}
				}
			}

		});


		JLabel locationsLabel = new JLabel("Your Locations");
		locationsLabel.setBounds(10, 0, 200, 23);
		locationsLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnRem = new JButton("Remove");
		btnRem.setBounds(10,570,180,23);
        // Action listener to remove location when pressed
		btnRem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (locationNames.size() == 1)
							JOptionPane.showMessageDialog(null, "Last location, can't remove");
						else {
							locationList.setSelectedIndex(locationList.getSelectedIndex());
							removeLocationList((String) locationList.getSelectedValue());
							weatherList.remove(locationList.getSelectedIndex());
						}

					}
				}
		);

		JButton btnAdd = new JButton("Add Location");
		btnAdd.setBounds(10, 540, 180, 23);
        // Action listener to add location when pressed
		btnAdd.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						final JFrame locationAdder = new JFrame("Add Location");
						locationAdder.setSize(325, 120);
						locationAdder.setLocationRelativeTo(LocationPanel);
						locationAdder.setResizable(false);
						locationAdder.setVisible(true);
						locationAdder.getContentPane().setLayout(null);

						//Adding Text
						JLabel cityInputLabel = new JLabel("Input a city: ");
						cityInputLabel.setBounds(4, 5, 150, 23);
						locationAdder.add(cityInputLabel);

						JLabel countryInputLabel = new JLabel("Input a country: ");
						countryInputLabel.setBounds(4, 30, 150, 23);
						locationAdder.add(countryInputLabel);

						//Adding a text field
						final JTextField cityInput = new JTextField();
						cityInput.setBounds(122, 5, 180, 23);
						locationAdder.add(cityInput);

						final JTextField countryInput = new JTextField();
						countryInput.setBounds(122, 30, 180, 23);
						locationAdder.add(countryInput);

						//Adding an accept button
						final JButton btnAccept = new JButton("Accept");
						btnAccept.setBounds(77, 65, 150, 23);
						locationAdder.getRootPane().setDefaultButton(btnAccept);
						locationAdder.add(btnAccept);
						btnAccept.addActionListener(
								new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										userCityInput = cityInput.getText();
										locationAdder.getRootPane().setDefaultButton(btnAccept);
										userCountryInput = countryInput.getText();
										userCountryInput = changeToCountryCode(userCountryInput);
										WeatherData newWeatherData = new WeatherData(userCityInput, userCountryInput);
										try {
											newWeatherData = checkCountryCode(newWeatherData);
										} catch (NullPointerException er) {

											//Adding text to let the user know they entered an invalid location
											duplicateText.setVisible(false);
											cityNotFoundText.setVisible(true);
											cityNotFoundText.setBounds(30, 85, 400, 46);
											locationAdder.add(cityNotFoundText);
											locationAdder.setSize(310, 150);
											//er.printStackTrace();
										}
										if (!(newWeatherData.getCurrentWeather().getCurrentCity() == null)) {

											if (!checkDuplicate(newWeatherData)) {
												weatherList.addElement(newWeatherData.getCurrentWeather().getCurrentCity() + ", " + newWeatherData.getCurrentWeather().getCountryCode());
												addToLocationList(newWeatherData); //Adding the location to the myLocations list
												locationAdder.dispose();    //Close the frame when accept is clicked
											} else { //Creates a notification to the user that the location has already been added
//												//Adding text
												cityNotFoundText.setVisible(false);
												duplicateText.setVisible(true);
												duplicateText.setBounds(30, 90, 400, 23);
												locationAdder.add(duplicateText);
												locationAdder.setSize(310,140);
											}
										}
									}
								});
					}

				});


		LocationPanel.setLayout(null);
		LocationPanel.add(locationsLabel);
		LocationPanel.add(btnAdd);
		LocationPanel.add(btnRem);
		LocationPanel.add(pane);
		contentPane.setLayout(gl_contentPane);

	}


		/******END LOCATIONS******/


	/***********METHODS************/


    /**
     * initializePrimaryVariables method is the first thing that is called to initialize the
	 * variables needed to preset the location
     */

	private void initializePrimaryVariables() {
		locationNames = new java.util.ArrayList<WeatherData>();
		weatherList = new DefaultListModel();
		locationList = new JList(weatherList);

		//prompt the user to input their current city and country to initialize WeatherData and create a default location
		weatherData = new WeatherData(null, null);
		addToLocationList(weatherData);
		weatherList.addElement(weatherData.getCurrentWeather().getCurrentCity() + ", " + weatherData.getCurrentWeather().getCountryCode());
	}

    /**
     * toSaveLocations method serializes the data
     */
	private void toSaveLocations() {
		try {
			File locationFile = new File("locations.dat");
			FileOutputStream fileOut = new FileOutputStream(locationFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(locationNames);
			out.close();
			fileOut.close();

			File unitFile = new File("units.dat");
			FileOutputStream fileOutUnit = new FileOutputStream(unitFile);
			ObjectOutputStream outUnit = new ObjectOutputStream(fileOutUnit);
			outUnit.writeObject(currentUnit);
			outUnit.close();
			fileOut.close();
			JOptionPane.showMessageDialog(null, "Serialized data is saved in: locations.dat\nUnit data is saved in: units.dat");

		}
		catch(IOException i){
			i.printStackTrace();
		}
	}

    /**
     * toLoadLocations method loads previous locations from a text file
     */
	private void toLoadLocations() {
		String fileToLoad = "locations.dat";
		String unitFileToLoad = "units.dat";
		String unitLoad = "";
		ArrayList<WeatherData> wdLoad = new ArrayList<WeatherData>();
		try{
			FileInputStream fileIn = new FileInputStream(fileToLoad);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			wdLoad = (ArrayList<WeatherData>) in.readObject();
			in.close();
			fileIn.close();

			FileInputStream fileInUnit = new FileInputStream(unitFileToLoad);
			ObjectInputStream inUnit = new ObjectInputStream(fileInUnit);
			unitLoad = (String) inUnit.readObject();
			inUnit.close();
			fileInUnit.close();
		}
		catch (IOException i) {
			i.printStackTrace();
		}
		catch (ClassNotFoundException c) {
			JOptionPane.showMessageDialog(null, "Location list not found");
		}
		for (int i = 0; i < wdLoad.size(); i++) {
			String city = wdLoad.get(i).getCurrentWeather().getCurrentCity();
			String country = wdLoad.get(i).getCurrentWeather().getCountryCode();
			WeatherData tmp = new WeatherData(city, country);
			if (!checkDuplicate(tmp)) {
				weatherList.addElement(tmp.getCurrentWeather().getCurrentCity() + ", " + tmp.getCurrentWeather().getCountryCode());
				locationNames.add(tmp);
			}
		}
		currentUnit = unitLoad;
        weatherData.changeTemperatureUnits("kelvin", currentUnit);
        changeUnits();
	}

    /**
     * changeWeatherLocation method changes the weather for the new location
     * @param s and weatherData take in a string with City and Country Code and old weather data
     * @return a new WeatherData object of the new location
     */
	public WeatherData changeWeatherLocation(String s, WeatherData weatherData) {

		for (int i = 0; i < locationNames.size(); i++) {
			String checkCityName = locationNames.get(i).getCurrentWeather().getCurrentCity() + ", " + locationNames.get(i).getCurrentWeather()
					.getCountryCode();
			if (checkCityName.equals(s)) {
				weatherData = locationNames.get(i);
				return weatherData;
			}
		}
		return null;
	}
    /**
     * displayCorrectImage finds the proper image based on the icon ID from the API
     * @param description receives icon ID
     * @return image used for weather
     */
	public BufferedImage displayCorrectImage(String description) {
		if (description.equals("01d")) {
			return icon01d;
		} else if (description.equals("Sunny")) {
			return icon01d;
		} else if (description.equals("Cloudy")) {
			return icon03d;
		} else if (description.equals("02d")) {
			return icon02d;
		} else if (description.equals("03d")) {
			return icon03d;
		} else if (description.equals("04d")) {
			return icon04d;
		} else if (description.equals("09d")) {
			return icon09d;
		} else if (description.equals("10d")) {
			return icon10d;
		} else if (description.equals("11d")) {
			return icon11d;
		} else if (description.equals("13d")) {
			return icon13d;
		} else if (description.equals("50d")) {
			return icon50d;
		} else if (description.equals("01n")) {
			return icon01n;
		} else if (description.equals("02n")) {
			return icon02n;
		} else if (description.equals("03n")) {
			return icon03n;
		} else if (description.equals("04n")) {
			return icon04n;
		} else if (description.equals("09n")) {
			return icon09n;
		} else if (description.equals("10n")) {
			return icon10n;
		} else if (description.equals("11n")) {
			return icon11n;
		} else if (description.equals("13n")) {
			return icon13n;
		} else if (description.equals("50n")) {
			return icon50n;
		}
		return null;
	}

    /**
     * changeToCountryCode changes all spaces into hyphens in a country code
     * @param country take in a country code
     * @return A proper country code with hyphens instead of spaces
     */
	public String changeToCountryCode(String country) {
		country = country.replace(' ', '-');
		return country;
	}

	/**
	 * changeWeatherLocation method changes the weather for the new location
	 * @param location take in a string with City and Country Code
	 * @return a new WeatherData object of the new location
	 */
	public WeatherData changeWeatherLocation(String location) {
		String checkString = "";		//Instantiate checkString

		for (int i=0; i<locationNames.size(); i++) {
			if (locationNames.get(i) != null)
				checkString = locationNames.get(i).getCurrentWeather().getCurrentCity()+", "+locationNames.get(i).getCurrentWeather().getCountryCode();
			if (checkString.equals(location)) {
				weatherData = locationNames.get(i);
				return weatherData;
			}
		}
		JOptionPane.showMessageDialog(null, "Location not found.");
		return null;
	}

    /**
     * Adds new weather data to locationNames Arraylist
     * @param newWeatherData takes in new weather data
     */
	public void addToLocationList(WeatherData newWeatherData) {
			locationNames.add(newWeatherData);
	}


    /**
     * checkCountryCode checks if the current country code refers to the
     * proper country
     * @param wd takes in weather data
     * @return weather data with proper country code
     */
	public WeatherData checkCountryCode(WeatherData wd) {
		if (wd.getCurrentWeather().getCountryCode().equals("United Kingdom"))
			wd.getCurrentWeather().setCountryCode("GB");
		else if (wd.getCurrentWeather().getCountryCode().equals("Canada"))
			wd.getCurrentWeather().setCountryCode("CA");
		else if (wd.getCurrentWeather().getCountryCode().equals("United States of America") || wd.getCurrentWeather().getCountryCode().equals("United States"))
			wd.getCurrentWeather().setCountryCode("US");
		return wd;
	}

	/**
	 * removeLocationList removes the location from the list
	 * @param cityName takes in a cityName
	 * @return a new array with the location removed
	 */
	public java.util.ArrayList<WeatherData> removeLocationList(String cityName) {
		String location_To_Compare="";
		for (int i=0; i<locationNames.size(); i++) {
			location_To_Compare= locationNames.get(i).getCurrentWeather().getCurrentCity()+", "+locationNames.get(i).getCurrentWeather().getCountryCode();
			if ((location_To_Compare).equals(cityName)) {
				locationNames.remove(i);
			}
		}
		return locationNames;

	}



    /**
     * checkDuplicate checks locationNames Arraylist to see if
     * the country already exists
     * @param wd takes in weather data
     * @return true if duplicate, else false
     */
	public boolean checkDuplicate(WeatherData wd) {
		String location_To_Compare="";
		String currentLocation="";
		for (int i=0; i<locationNames.size(); i++) {
			location_To_Compare=locationNames.get(i).getCurrentWeather().getCurrentCity() + locationNames.get(i).getCurrentWeather().getCountryCode();
			currentLocation=wd.getCurrentWeather().getCurrentCity() + wd.getCurrentWeather().getCountryCode();
			if (locationNames.get(i) != null) {
				if ((location_To_Compare).equals(currentLocation)) {
					return true;
				}
			}
		}
		return false;
	}


    public String getUnit() {
        return currentUnit;
    }

    public void setUnit(String currentUnit) {
        this.currentUnit = currentUnit;
    }

    /**
     * refreshGUI method refreshes GUI by updating data and setting all earth labels
     */
	public void refreshGUI() {
		try {
			weatherData.update();

		} catch (IOException e) {
			e.printStackTrace();
		}
		currLocationLabel.setText(weatherData.getCurrentWeather().getCurrentCity() + ", " + weatherData.getCurrentWeather().getCountryCode());
		currSunriseLabel.setText("Sunrise: " + weatherData.getCurrentWeather().getSunrise());
		currSunsetLabel.setText("Sunset: " + weatherData.getCurrentWeather().getSunset());
		currWeatherConditionLabel.setText("Weather Conditions");
		currHumidityLabel.setText("Humidity: " + weatherData.getCurrentWeather().getHumidity() + "%\r\n");
		currWindSpeedLabel.setText("Wind Speed: " + df.format(weatherData.getCurrentWeather().getWindSpeed()) + " km/h\r\n");
		currWindDirection.setText("Wind Direction: " + weatherData.getCurrentWeather().getWindDirectionString());
		currPressureLabel.setText("Pressure: " + df.format(weatherData.getCurrentWeather().getAirPressure()) + " kPa\r\n");
		currTempOutput.setText(df.format(weatherData.getCurrentWeather().getTemperature()) + "\u00B0");
		currLowestTemp.setText("\u2207" + df.format(weatherData.getCurrentWeather().getMinTemp()) + "\u00B0");
		currHighestTemp.setText("\u25B2" + df.format(weatherData.getCurrentWeather().getMaxTemp()) + "\u00B0");
		lastUpdatedLabel.setText("Last updated: " + weatherData.getCurrentWeather().getLastUpdatedTime());
		currWeatherDescriptionLabel.setText("Conditions: " + weatherData.getCurrentWeather().getDescription());
		currWeatherIcon.setIcon(new ImageIcon(displayCorrectImage(weatherData.getCurrentWeather().getIcon())));
		longTermIcon1.setIcon(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[0].getIcon())));
		longWeatherCondition1.setText(weatherData.longTermWeather[0].getCondition());
		longTermTemp1.setText(df.format(weatherData.longTermWeather[0].getTemperature()) + "\u00B0");
		longMaxTemp1.setText("\u25B2" + df.format(weatherData.longTermWeather[0].getMax()));
		longMinTemp1.setText("\u2207" + df.format(weatherData.longTermWeather[0].getMin()));
		longTermIcon2.setIcon(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[1].getIcon())));
		longWeatherCondition2.setText(weatherData.longTermWeather[1].getCondition());
		longTermTemp2.setText(df.format(weatherData.longTermWeather[1].getTemperature()) + "\u00B0");
		longMaxTemp2.setText("\u25B2" + df.format(weatherData.longTermWeather[1].getMax()));
		longMinTemp2.setText("\u2207" + df.format(weatherData.longTermWeather[1].getMin()));
		longTermIcon3.setIcon(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[2].getIcon())));
		longWeatherCondition3.setText(weatherData.longTermWeather[2].getCondition());
		longTermTemp3.setText(df.format(weatherData.longTermWeather[2].getTemperature()) + "\u00B0");
		longMaxTemp3.setText("\u25B2" + df.format(weatherData.longTermWeather[2].getMax()));
		longMinTemp3.setText("\u2207" + df.format(weatherData.longTermWeather[2].getMin()));
		longTermIcon4.setIcon(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[3].getIcon())));
		longWeatherCondition4.setText(weatherData.longTermWeather[3].getCondition());
		longTermTemp4.setText(df.format(weatherData.longTermWeather[3].getTemperature()) + "\u00B0");
		longMaxTemp4.setText("\u25B2" + df.format(weatherData.longTermWeather[3].getMax()));
		longMinTemp4.setText("\u2207" + df.format(weatherData.longTermWeather[3].getMin()));
		longTermIcon5.setIcon(new ImageIcon(displayCorrectImage(weatherData.longTermWeather[4].getIcon())));
		longWeatherCondition5.setText(weatherData.longTermWeather[4].getCondition());
		longTermTemp5.setText(df.format(weatherData.longTermWeather[4].getTemperature()) + "\u00B0");
		longMaxTemp5.setText("\u25B2" + df.format(weatherData.longTermWeather[4].getMax()));
		longMinTemp5.setText("\u2207" + df.format(weatherData.longTermWeather[4].getMin()));
		shortTermIcon1.setIcon(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[0].getIcon())));
		shortTermTemp1.setText(df.format(weatherData.shortTermWeather[0].getTemperature()) + "\u00B0");
		shortWeatherCondition1.setText(weatherData.shortTermWeather[0].getCondition());
		shortTermIcon2.setIcon(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[1].getIcon())));
		shortTermTemp2.setText(df.format(weatherData.shortTermWeather[1].getTemperature()) + "\u00B0");
		shortWeatherCondition2.setText(weatherData.shortTermWeather[1].getCondition());
		shortTermIcon3.setIcon(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[2].getIcon())));
		shortTermTemp3.setText(df.format(weatherData.shortTermWeather[2].getTemperature()) + "\u00B0");
		shortWeatherCondition3.setText(weatherData.shortTermWeather[2].getCondition());
		shortTermIcon4.setIcon(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[3].getIcon())));
		shortTermTemp4.setText(df.format(weatherData.shortTermWeather[3].getTemperature()) + "\u00B0");
		shortWeatherCondition4.setText(weatherData.shortTermWeather[3].getCondition());
		shortTermIcon5.setIcon(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[4].getIcon())));
		shortTermTemp5.setText(df.format(weatherData.shortTermWeather[4].getTemperature()) + "\u00B0");
		shortWeatherCondition5.setText(weatherData.shortTermWeather[4].getCondition());
		shortTermIcon6.setIcon(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[5].getIcon())));
		shortTermTemp6.setText(df.format(weatherData.shortTermWeather[5].getTemperature()) + "\u00B0");
		shortWeatherCondition6.setText(weatherData.shortTermWeather[5].getCondition());
		shortTermIcon7.setIcon(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[6].getIcon())));
		shortTermTemp7.setText(df.format(weatherData.shortTermWeather[6].getTemperature()) + "\u00B0");
		shortWeatherCondition7.setText(weatherData.shortTermWeather[6].getCondition());
		shortTermIcon8.setIcon(new ImageIcon(displayCorrectImage(weatherData.shortTermWeather[7].getIcon())));
		shortTermTemp8.setText(df.format(weatherData.shortTermWeather[7].getTemperature()) + "\u00B0");
		shortWeatherCondition8.setText(weatherData.shortTermWeather[7].getCondition());
	}

    /**
     * refreshMarsGUI method updates mars GUI by getting data and setting all mars labels
     */
    public void refreshMarsGUI() {
        try {
            weatherData.update();

        } catch (IOException e) {
            e.printStackTrace();
        }
        marsConditionLabel.setText("Conditions: " + weatherData.getWeatherMars().getSkyCondition());
        marsIconLabel.setIcon(new ImageIcon(displayCorrectImage(weatherData.getWeatherMars().getSkyCondition())));
        String marsHumidityCheck = weatherData.getWeatherMars().getHumidity();
        // Checks for null value and replaces with N/A
        if(marsHumidityCheck == null) {
            marsHumidityLabel.setText("Humidity: N/A");
        } else {
            marsHumidityLabel.setText("Humidity: " + marsHumidityCheck);
        }
        String marsWindSpeedCheck = weatherData.getWeatherMars().getWindSpeed();
        // Checks for null value and replaces with N/A
        if(marsWindSpeedCheck == null) {
            marsWindSpeedLabel.setText("Wind Speed: N/A");
        } else {
            marsWindSpeedLabel.setText("Wind Speed: " + marsWindSpeedCheck);
        }
        marsWindDirectionLabel.setText("Wind Direction: " + weatherData.getWeatherMars().getWindDirection());
        marsPressureLabel.setText("Pressure: " + weatherData.getWeatherMars().getAirpressure() + "kPa");
        // Checks the current units to decide what data to get
        if(currentUnit.equals("celsius")) {
            marsMinTempCheck = weatherData.getWeatherMars().getTemperatureMin();
            marsMaxTempCheck = weatherData.getWeatherMars().getTemperatureMax();
        } else {
            marsMinTempCheck = weatherData.getWeatherMars().getTemperatureMinFahrenheit();
            marsMaxTempCheck = weatherData.getWeatherMars().getTemperatureMaxFahrenheit();
        }
        marsMinTempLabel.setText("\u2207" + marsMinTempCheck + "\u00B0");
        marsMaxTempLabel.setText("\u25B2" + marsMaxTempCheck + "\u00B0");
        marsCurrentTempOutput.setText(((marsMaxTempCheck + marsMinTempCheck) / 2) + "\u00B0");
        marsLastUpdatedLabel.setText("Last updated: " + weatherData.getCurrentWeather().getLastUpdatedTime());
    }

    /**
     * changeUnits method used to update all temperatures after the values have been changed without calling the update method
     */
    public void changeUnits() {
        currTempOutput.setText(df.format(weatherData.getCurrentWeather().getTemperature()) + "\u00B0");
        currLowestTemp.setText("\u2207" + df.format(weatherData.getCurrentWeather().getMinTemp()) + "\u00B0");
        currHighestTemp.setText("\u25B2" + df.format(weatherData.getCurrentWeather().getMaxTemp()) + "\u00B0");
        longTermTemp1.setText(df.format(weatherData.longTermWeather[0].getTemperature()) + "\u00B0");
        longMaxTemp1.setText("\u25B2" + df.format(weatherData.longTermWeather[0].getMax()));
        longMinTemp1.setText("\u2207" + df.format(weatherData.longTermWeather[0].getMin()));
        longTermTemp2.setText(df.format(weatherData.longTermWeather[1].getTemperature()) + "\u00B0");
        longMaxTemp2.setText("\u25B2" + df.format(weatherData.longTermWeather[1].getMax()));
        longMinTemp2.setText("\u2207" + df.format(weatherData.longTermWeather[1].getMin()));
        longTermTemp3.setText(df.format(weatherData.longTermWeather[2].getTemperature()) + "\u00B0");
        longMaxTemp3.setText("\u25B2" + df.format(weatherData.longTermWeather[2].getMax()));
        longMinTemp3.setText("\u2207" + df.format(weatherData.longTermWeather[2].getMin()));
        longTermTemp4.setText(df.format(weatherData.longTermWeather[3].getTemperature()) + "\u00B0");
        longMaxTemp4.setText("\u25B2" + df.format(weatherData.longTermWeather[3].getMax()));
        longMinTemp4.setText("\u2207" + df.format(weatherData.longTermWeather[3].getMin()));
        longTermTemp5.setText(df.format(weatherData.longTermWeather[4].getTemperature()) + "\u00B0");
        longMaxTemp5.setText("\u25B2" + df.format(weatherData.longTermWeather[4].getMax()));
        longMinTemp5.setText("\u2207" + df.format(weatherData.longTermWeather[4].getMin()));
        shortTermTemp1.setText(df.format(weatherData.shortTermWeather[0].getTemperature()) + "\u00B0");
        shortTermTemp2.setText(df.format(weatherData.shortTermWeather[1].getTemperature()) + "\u00B0");
        shortTermTemp3.setText(df.format(weatherData.shortTermWeather[2].getTemperature()) + "\u00B0");
        shortTermTemp4.setText(df.format(weatherData.shortTermWeather[3].getTemperature()) + "\u00B0");
        shortTermTemp5.setText(df.format(weatherData.shortTermWeather[4].getTemperature()) + "\u00B0");
        shortTermTemp6.setText(df.format(weatherData.shortTermWeather[5].getTemperature()) + "\u00B0");
        shortTermTemp7.setText(df.format(weatherData.shortTermWeather[6].getTemperature()) + "\u00B0");
        shortTermTemp8.setText(df.format(weatherData.shortTermWeather[7].getTemperature()) + "\u00B0");
        marsConditionLabel.setText("Conditions: " + weatherData.getWeatherMars().getSkyCondition());
		marsIconLabel = new JLabel(new ImageIcon(displayCorrectImage(weatherData.getWeatherMars().getSkyCondition())));
        String marsHumidityCheck = weatherData.getWeatherMars().getHumidity();
        // Checks for null value and replaces with N/A
        if(marsHumidityCheck == null) {
            marsHumidityLabel.setText("Humidity: N/A");
        } else {
            marsHumidityLabel.setText("Humidity: " + marsHumidityCheck);
        }
        String marsWindSpeedCheck = weatherData.getWeatherMars().getWindSpeed();
        // Checks for null value and replaces with N/A
        if(marsWindSpeedCheck == null) {
            marsWindSpeedLabel.setText("Wind Speed: N/A");
        } else {
            marsWindSpeedLabel.setText("Wind Speed: " + marsWindSpeedCheck);
        }
		marsWindDirectionLabel.setText("Wind Direction: " + weatherData.getWeatherMars().getWindDirection());
		marsPressureLabel.setText("Pressure:" + weatherData.getWeatherMars().getAirpressure() +  "kPa");
		marsCurrentTempLabel.setText("Average Temperature: ");
        // Checks the current units to decide what data to get
        if(currentUnit.equals("celsius")) {
            marsMinTempCheck = weatherData.getWeatherMars().getTemperatureMin();
            marsMaxTempCheck = weatherData.getWeatherMars().getTemperatureMax();
        } else {
            marsMinTempCheck = weatherData.getWeatherMars().getTemperatureMinFahrenheit();
            marsMaxTempCheck = weatherData.getWeatherMars().getTemperatureMaxFahrenheit();
        }
        marsMinTempLabel.setText("\u2207" + marsMinTempCheck + "\u00B0");
        marsMaxTempLabel.setText("\u25B2" + marsMaxTempCheck + "\u00B0");
        marsCurrentTempOutput.setText(((marsMaxTempCheck + marsMinTempCheck) / 2) + "\u00B0");
		marsLastUpdatedLabel.setText("Last updated: " + weatherData.getCurrentWeather().getLastUpdatedTime());
    }
}
