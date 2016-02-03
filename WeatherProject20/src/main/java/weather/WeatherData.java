package main.java.weather;
/**
 * About WeatherData: WeatherData accesses the OpenWeatherMap API server based on the link it provides. The basic construct
 * of the URL is already defined and the changes needed to access the different cities/countries can be manipulated based
 * on the reference value from WeatherFrame (or user directed). By retrieval of the first city, the coordinates are saved
 * into the CurrentWeather class defined within this class and are then used to access the short term and long term weather data.
 *
 * How-to: Please refer to the Main method to see how to get the data for each attribute.
 */

import com.google.gson.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.IOException;

/**
 * WeatherData class contains the weather data 
 * @author Team 20
 */


public class WeatherData implements Serializable{

    private static final long serialVersionUID = 1L;

    public CurrentWeather currentWeather = new CurrentWeather(); // Initialized to keep current units
    public transient ShortTermWeather[] shortTermWeather;       //holds short term weather forecast attributes
    public transient LongTermWeather[] longTermWeather;         //holds long term weather forecast attributes
    public transient MarsWeather mw;                            //holds the mars weather forecast attributes
    private transient WeatherValue wv;                          //used to serialize current weather
    private transient ShortTermWeatherValue st;                 //used to serialize short term weather
    private transient LongTermWeatherValue lt;                  //used to serialize long term weather
    public transient MarsWeatherValue marsWeather;              //used to serialize mars weather
    private transient Boolean unitFlag = false;                 //to flag the boolean variable for units

    public String[] next_24; //store the next 24 hours here
    public String[] next_5; //store the next 5 days here

    private boolean firstFlag; //for the initial setting of the city/country

    /*
    Current Weather is a class that stores all the attributes that is to be represented in the local weather view
     */
    public class CurrentWeather implements Serializable {
        /* Instance Variables */
        private double windSpeed;
        private double windDirectionDegrees;
        private String windDirectionString;
        private double airPressure;
        private double humidity;
        private double temperature;
        private double minTemp;
        private double maxTemp;
        private String lastUpdatedTime;
        private String currentCity;
        private String countryCode;
        private String sunrise;
        private String sunset;
        private String description;
        private String icon;
        private String unit;

        /**
         * changeWind is a simple method to change from degrees format (given by the fetch) to a string
         */
        private void changeWind() {
            final double ANGLE_CHANGE_DEGREE = 22.5;
            String[] cardinalWind = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};

            int wind = (int) ((currentWeather.windDirectionDegrees + 11.25) / ANGLE_CHANGE_DEGREE);
            currentWeather.windDirectionString = cardinalWind[wind % 16];
        }

        /**
         * changePressure is a simple method to change from hPA to kPA
         */
        private void changePressure() {
            currentWeather.airPressure /= 10;
        }

        /**
         * changeSun changes the sunrise and sunset
         */
        private void changeSun() {
            // TODO: sometimes got a NumberException
            String sunriseDate = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date((Long.parseLong(currentWeather.getSunrise()) * 1000)));
            String sunsetDate = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date((Long.parseLong(currentWeather.getSunset()) * 1000)));
            int length = sunriseDate.length();
            sunriseDate = sunriseDate.substring(length - 9, length - 3).toString();
            sunsetDate = sunsetDate.substring(length - 9, length - 3).toString();
            StringBuilder sbSunrise = new StringBuilder(sunriseDate);
            StringBuilder sbSunset = new StringBuilder(sunsetDate);
            currentWeather.sunrise = sbSunrise.toString();
            currentWeather.sunset = sbSunset.toString();
        }

        /***********************************************************************************************
         *
         * ***********************************GETTERS AND SETTERS****************************************
         *
         ************************************************************************************************/


        public double getWindSpeed() {
            return windSpeed;
        }

        public double getWindDirectionDegrees() {
            return windDirectionDegrees;
        }

        public String getWindDirectionString() {
            return windDirectionString;
        }

        public double getAirPressure() {
            return airPressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getTemperature() {
            return temperature;
        }

        public double getMinTemp() {
            return minTemp;
        }

        public double getMaxTemp() {
            return maxTemp;
        }

        public String getLastUpdatedTime() {
            return lastUpdatedTime;
        }

        public String getCurrentCity() {
            return currentCity;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public String getSunset() {
            return sunset;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public void setWindDirectionDegrees(double windDirectionDegrees) {
            this.windDirectionDegrees = windDirectionDegrees;
        }

        public void setWindDirectionString(String windDirectionString) {
            this.windDirectionString = windDirectionString;
        }

        public void setAirPressure(double airPressure) {
            this.airPressure = airPressure;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public void setMinTemp(double minTemp) {
            this.minTemp = minTemp;
        }

        public void setMaxTemp(double maxTemp) {
            this.maxTemp = maxTemp;
        }

        public void setLastUpdatedTime(String lastUpdatedTime) {
            this.lastUpdatedTime = lastUpdatedTime;
        }

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }

        public void setUnits(String unit) {
            this.unit = unit;
        }

        public String getUnits() {
            return unit;
        }
    }

    /*
    Short term Weather is a class that stores all the attributes that is to be represented in the short term weather view
     */
    public class ShortTermWeather {
        private double temperature;
        private String condition;
        private String icon;
        private String unit;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }
    }

    /*
    Long term Weather is a class that stores all the attributes that is to be represented in the short term weather view
     */
    public class LongTermWeather {
        private double temperature, min, max;
        private String condition;
        private String icon;
        private String unit;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }
    }

    /*
    Mars is a class that stores all the attributes that is to be represented in the short term weather view
     */
    public class MarsWeatherValue {
        public float temperatureMax;
        public float temperatureMin;
        public float temperatureMaxFahrenheit;
        public float temperatureMinFahrenheit;
        public float airpressure;
        public String humidity;
        public String windSpeed;
        public String windDirection;
        public String skyCondition;

        public String getWindSpeed() {
            return windSpeed;
        }

        public float getTemperatureMax() {
            return temperatureMax;
        }

        public float getAirpressure() {
            return airpressure;
        }

        public String getHumidity() {
            return humidity;
        }

        public float getTemperatureMin() {
            return temperatureMin;
        }

        public void setTemperatureMin(float temperatureMin) {
            this.temperatureMin = temperatureMin;
        }

        public String getWindDirection() {
            return windDirection;
        }

        public String getSkyCondition() {
            return skyCondition;
        }

        public float getTemperatureMaxFahrenheit() {
            return temperatureMaxFahrenheit;
        }

        public float getTemperatureMinFahrenheit() {
            return temperatureMinFahrenheit;
        }

        public void setTemperatureMax(float max_temp) {
            this.temperatureMax = max_temp;
        }

        public void setAirpressure(float airpressure) {
            this.airpressure = airpressure;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public void setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
        }

        public void setWindDirection(String windDirection) {
            this.windDirection = windDirection;
        }

        public void setSkyCondition(String skyCondition) {
            this.skyCondition = skyCondition;
        }

        public void setTemperatureMaxFahrenheit(float temperatureMaxFahrenheit){
            this.temperatureMaxFahrenheit = temperatureMaxFahrenheit;
        }

        public void setTemperatureMinFahrenheit(float temperatureMinFahrenheit){
            this.temperatureMinFahrenheit = temperatureMinFahrenheit;
        }
    }


    /*
     * Constructor for WeatherData class.
     * Initializes the instance variables with the first fetch-data from the source
     */
    public WeatherData(String city, String countryCode) {
        if (city == null && countryCode == null)
            getWeatherEmpty();
        else
            getWeather(city, countryCode);
    }



	/* Methods */

    /**
     * update method will return a list of WeatherData elements that updates the data by fetching it from the source
     * @return WeatherData
     */
    public WeatherData update() throws IOException {
        this.getWeather(currentWeather.currentCity, currentWeather.countryCode);
        return this;
    }

    /**
     * getWeatherEmpty method is a helper class to initially predetermine the current location of the user and set up the program
     * program will not continue until the user has entered a proper city and country
     */
    private void getWeatherEmpty() {
        firstFlag=true;
        JOptionPane newPane = new JOptionPane();

        String location = newPane.showInputDialog("<html>Please enter your current location information below:<br>" +
                "<div align='center'><font size ='3' color='gray'>Format: City, Country <br> Remember to add a space between \",\" and the country name.</font></div></html></font></div></html>");
        String locationArray[] = new String[2];
        try {
            if (location != null) {
                locationArray = location.split(", ", 2);
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.exit(0);
        }
        newPane.setBounds((int) newPane.getBounds().getX(), (int) newPane.getBounds().getY() + 20, 500, 500);

        String defaultCity=null;
        String defaultCountry=null;

        try {
            defaultCity = locationArray[0];
            defaultCountry = locationArray[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Incorrect input. Please follow the format and try again");
            getWeatherEmpty();
        }

        getWeather(defaultCity, defaultCountry);
        firstFlag=false;

//        String defaultCity = JOptionPane.showInputDialog("Please enter your current city below: ");
//        String defaultCountry = JOptionPane.showInputDialog("Please enter your current country below: ");
//        getWeather(defaultCity, defaultCountry);

    }
    /**
     * getWeather opens up the OpenWeatherMap API and retrieves given information that we wish to acquire
     * @param city the city inputed by the user, countryCode the country code as a string
     */
    private void getWeather(String city, String countryCode) {
        String urlCurrent = "";
        if (countryCode != null) {
            urlCurrent = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + countryCode;
        }
        else {
            urlCurrent = " api.openweathermap.org/data/2.5/weather?q=London,ca";
        }

        try {
            String jsonData = readUrl(urlCurrent);
            Gson gsonCurrent = new Gson();
            wv = gsonCurrent.fromJson(jsonData, WeatherValue.class);

            //before instantiating the variables of current weather data, first we must check if this is a proper list of data
            if (wv.getCod().equals("404")) {
                if (firstFlag)
                    JOptionPane.showMessageDialog(null, "The city was not found, please try again.");
                    getWeatherEmpty();
                return;
            }
            else
                firstFlag=false;
                retrieveCurrentWeather();

            //Get coordinates for current location for use in short term and long term forecasting
            double lat, lon;
            lat = wv.getCoord().getLat();
            lon = wv.getCoord().getLon();


            //build the url for short term api using the lon/lat coordinates from initial current
            String urlShortTerm = "http://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon;
            jsonData = readUrl(urlShortTerm);
            Gson gsonShortTerm = new Gson();
            st = gsonShortTerm.fromJson(jsonData, ShortTermWeatherValue.class);
            jsonData = readUrl(urlShortTerm);
            retrieveShortTermWeather();

            //build the url for mars weather api from lastest rover report
            String urlMarsWeather = "http://marsweather.ingenology.com/v1/latest/.json";
            jsonData = readUrl(urlMarsWeather);
            Gson gsonMars = new Gson();
            mw = gsonMars.fromJson(jsonData, MarsWeather.class);
            MarsWeatherRetrieveData();

            //build the url for long term api using the lon/lat coordinates from initial current
            String urlLongTerm = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=" + lat + "&lon=" + lon + "&cnt=5&mode=json";
            jsonData = readUrl(urlLongTerm);
            Gson gsonLongTerm = new Gson();
            lt = gsonLongTerm.fromJson(jsonData, LongTermWeatherValue.class);

            retrieveLongTermWeather();

            // Sets default units
            if (!unitFlag) {
                currentWeather.setUnits("celsius");
                unitFlag = true;
            }

            // Changes units to match when refreshed
            if(currentWeather.getUnits().equals("fahrenheit")) {
                changeTemperatureUnits("kelvin", "fahrenheit");

            } else {
                changeTemperatureUnits("kelvin", "celsius");
            }

            currentWeather.changeWind();
            currentWeather.changePressure();
            currentWeather.changeSun();

            shortTerm3HourIntervalGenerator();
            longTermDayIntervalGenerator();

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            if (firstFlag)
                getWeatherEmpty();
        }
    }

    /**
     * Helper method to read the URL as a String and make a request to the server to read the contents of the page
     * @param urlString is the String that links to the json file
     * @return String
     */
    private static String readUrl(String urlString) throws IOException{
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    /**
     * changeTemperature method changes the temperature
     * @param currentUnit is the unit to be changed from, newUnit is the unit to change into
     */
    public void changeTemperatureUnits(String currentUnit, String newUnit) {
        Unit temp_1 = new Unit(currentWeather.temperature, currentUnit);
        Unit unit_Min = new Unit(currentWeather.minTemp, currentUnit);
        Unit unit_Max = new Unit(currentWeather.maxTemp, currentUnit);
        temp_1.changeUnits(newUnit);
        unit_Min.changeUnits(newUnit);
        unit_Max.changeUnits(newUnit);
        currentWeather.temperature = temp_1.temperature;
        currentWeather.minTemp = unit_Min.temperature;
        currentWeather.maxTemp = unit_Max.temperature;
        currentWeather.setUnits(newUnit); // Marks current weather units for changing

        Unit tempShortTerm = null;
        for (int i = 0; i < shortTermWeather.length; i++) {
            tempShortTerm = new Unit(shortTermWeather[i].temperature, currentUnit);
            tempShortTerm.changeUnits(newUnit);
            shortTermWeather[i].setTemperature(tempShortTerm.temperature);
        }

        Unit tempLongTerm = null;
        Unit tempLongTermMax = null;
        Unit tempLongTermMin = null;
        for (int i = 0; i < longTermWeather.length; i++) {
            tempLongTerm = new Unit(longTermWeather[i].temperature, currentUnit);
            tempLongTermMax = new Unit(longTermWeather[i].getMax(), currentUnit);
            tempLongTermMin = new Unit(longTermWeather[i].getMin(), currentUnit);
            tempLongTerm.changeUnits(newUnit);
            tempLongTermMax.changeUnits(newUnit);
            tempLongTermMin.changeUnits(newUnit);
            longTermWeather[i].setTemperature(tempLongTerm.temperature);
            longTermWeather[i].setMax(tempLongTermMax.temperature);
            longTermWeather[i].setMin(tempLongTermMin.temperature);
        }
    }

    /**
     * getTime retrieves the current time and then parsed into just the hour and minute
     * @return String return the timeString
     */
    private String getTime() {
        currentWeather.lastUpdatedTime = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
        String timeString = "";
        char[] timeArray = currentWeather.lastUpdatedTime.toCharArray();
        String hour = "" + timeArray[0] + timeArray[1];
        String minute = "" + timeArray[2] + timeArray[2];
        timeString = hour + ":" + minute;
        return timeString;
    }

    /**
     * finds the next 24 hours in 3 hour intervals
     */
    private void shortTerm3HourIntervalGenerator() {
        int hourMark = Integer.parseInt(new SimpleDateFormat("HH").format((Calendar.getInstance().getTime())));
        int[] storeHours = new int[8];
        next_24 = new String[8];
        boolean am = false;


        hourMark += 3; //to get the next interval instead of the current
        if (hourMark >=24)
            hourMark -= 24;
        int i = 0;
        while (i < 8) {
            if (hourMark >= 24) {
                hourMark -= 24;
                storeHours[i] = hourMark;
            } else
                storeHours[i] = hourMark;
            hourMark += 3;
            i++;
        }

        for (int j = 0; j < storeHours.length; j++) {

            if (storeHours[j] >= 12)
                am = false;
            else
                am = true;
            if (storeHours[j] > 12) {
                storeHours[j] -= 12;
            }
            if (storeHours[j] == 0) {
                storeHours[j] = 12;
                am = true;
            }
            if (am)
                next_24[j] = storeHours[j] + "am";
            else
                next_24[j] = storeHours[j] + "pm";
        }
    }

    /**
     * generates the next 5 days in the array next_5 from today
     */
    private void longTermDayIntervalGenerator()
    {
        //to hold the days that are to be represented
        String[] listOfDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        String currentDay = new SimpleDateFormat("EEEE").format(new Date());
        next_5 = new String[5];
        int i=0;
        int currentIndex=0;
        while(i < listOfDays.length)
        {
            if (currentDay.equals(listOfDays[i]))
                currentIndex = i;
            i++;

        }
        if (currentIndex >= 6)
            currentIndex = 0;
        else
            currentIndex++;
        i = 0;
        while(i < 5)
        {
            next_5[i] = listOfDays[currentIndex++];
            if (currentIndex > 6)
                currentIndex = 0;
            i++;
        }
    }

    /**
     * tests the retrieval of weatherdata and serves as a template for others to see how the variables are handled
     */
    /*
    public static void main(String[] args) {
        WeatherData wd = new WeatherData("Toronto", "CA");
        DecimalFormat df = new DecimalFormat("#");
        System.out.println("Current city: " + wd.getCurrentWeather().currentCity);
        System.out.println("Current temp: " + df.format(wd.getCurrentWeather().temperature));
        for (int i = 0; i < 8; i++) {
            System.out.println("Short Term temp hour[" + i * 3 + "]: " + df.format(wd.shortTermWeather[i].getTemperature()));
        }
        for (int j = 0; j < 5; j++) {
            System.out.println("Long term temp day[" + j + "]: " + df.format(wd.longTermWeather[j].getTemperature()));
        }
        System.out.println("Mars Weather: " + wd.getWeatherMars().getTemperatureMax());
        System.out.println("Mars Weather: " + wd.getWeatherMars().getTemperatureMin());
        System.out.println("Mars Weather: " + wd.getWeatherMars().getAirpressure());
        System.out.println("Mars Weather: " + wd.getWeatherMars().getSkyCondition());
    }*/

    /**
     * retrieves the information to be displayed in the current forecast
     */
    private void retrieveCurrentWeather() {
        currentWeather.setTemperature(wv.getMain().getTemp());
        currentWeather.setMaxTemp(wv.getMain().getTemp_max());
        currentWeather.setMinTemp(wv.getMain().getTemp_min());
        currentWeather.setHumidity(wv.getMain().getHumidity());
        currentWeather.setAirPressure(wv.getMain().getPressure());
        currentWeather.setWindSpeed(wv.getWind().getSpeed());
        currentWeather.setWindDirectionDegrees(wv.getWind().getDeg());
        currentWeather.setCurrentCity(wv.getName());
        currentWeather.setCountryCode(wv.getSys().getCountry());
        currentWeather.setSunrise(wv.getSys().getSunrise());
        currentWeather.setSunset(wv.getSys().getSunset());
        currentWeather.setLastUpdatedTime(getTime());
        currentWeather.setDescription(wv.getWeather().get(0).getDescription());
        currentWeather.setIcon(wv.getWeather().get(0).getIcon());
    }

    /**
     * retrieves the information to be displayed in the short term forecast
     */
    private void retrieveShortTermWeather() {
        int numOf3HourIntervals = 24 / 3;
        shortTermWeather = new ShortTermWeather[numOf3HourIntervals];
        for (int j = 0; j < numOf3HourIntervals; j++) {
            shortTermWeather[j] = new ShortTermWeather();
        }
        for (int i = 0; i < numOf3HourIntervals; i++) {
            shortTermWeather[i].setTemperature(st.getList().get(i).getMain().getTemp());
            shortTermWeather[i].setCondition(st.getList().get(i).getWeather().get(0).getMain());
            shortTermWeather[i].setIcon(st.getList().get(i).getWeather().get(0).getIcon());
        }

    }

    /**
     * retrieves the information to be displayed in the long term forecast
     */
    private void retrieveLongTermWeather() {
        int numOfDays = 5;
        longTermWeather = new LongTermWeather[numOfDays];
        for (int j = 0; j < numOfDays; j++) {
            longTermWeather[j] = new LongTermWeather();
        }
        for (int i = 0; i < numOfDays; i++) {
            longTermWeather[i].setTemperature(lt.getList().get(i).getTemp().getDay());
            longTermWeather[i].setCondition(lt.getList().get(i).getWeather().get(0).getMain());
            longTermWeather[i].setMin(lt.getList().get(i).getTemp().getMin());
            longTermWeather[i].setMax(lt.getList().get(i).getTemp().getMax());
            longTermWeather[i].setIcon(lt.getList().get(i).getWeather().get(0).getIcon());
        }
    }

    /**
     * retrieves the information to be displayed in the Mars forecast
     */
    public void MarsWeatherRetrieveData() {
        marsWeather = new MarsWeatherValue();
        marsWeather.setAirpressure(mw.getReport().getPressure());
        marsWeather.setHumidity(mw.getReport().getAbs_humidity());
        marsWeather.setSkyCondition(mw.getReport().getAtmo_opacity());
        marsWeather.setTemperatureMax(mw.getReport().max_temp);
        marsWeather.setTemperatureMin(mw.getReport().min_temp);
        marsWeather.setWindDirection(mw.getReport().getWind_direction());
        marsWeather.setWindSpeed(mw.getReport().getWind());
        marsWeather.setTemperatureMaxFahrenheit(mw.getReport().max_temp_fahrenheit);
        marsWeather.setTemperatureMinFahrenheit(mw.getReport().min_temp_fahrenheit);
    }

    /**************************************************************************************************
     *
     * Getters and Setters
     *
     *************************************************************************************************/
    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public ShortTermWeather[] getShortTermWeather() {
        return shortTermWeather;
    }

    public void setShortTermWeather(ShortTermWeather[] shortTermWeather) {
        this.shortTermWeather = shortTermWeather;
    }

    public LongTermWeather[] getLongTermWeather() {
        return longTermWeather;
    }

    public void setLongTermWeather(LongTermWeather[] longTermWeather) {
        this.longTermWeather = longTermWeather;
    }

    public MarsWeatherValue getWeatherMars() {
        return marsWeather;
    }

    public void setWeatherMars(MarsWeatherValue weatherMars) {
        this.marsWeather = weatherMars;
    }

    public MarsWeather getMw() {
        return mw;
    }

    public void setMw(MarsWeather mw) {
        this.mw = mw;
    }
    public String[] getNext_24() {
        return next_24;
    }

    public void setNext_24(String[] next_24) {
        this.next_24 = next_24;
    }

    public String[] getNext_5() {
        return next_5;
    }

    public void setNext_5(String[] next_5) {
        this.next_5 = next_5;
    }


}

