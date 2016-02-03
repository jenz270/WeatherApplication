package main.java.weather;

/**
 * LongTermForecastData class  will store the long term forecast data
 * @author Team 20
 */

public class LongTermForecastData{

/* Instance Variables */
private String[] forecastTime;
private float[] longTermTemperature;
private float[] longTermSkyIcon;
private float[] longTermMaxTemp;
private float[] longTermMinTemp;

/* Constructor */
public LongTermForecastData() {
	forecastTime = null;
	longTermTemperature = null;
	longTermSkyIcon = null;
	longTermMaxTemp = null;
	longTermMinTemp = null;	
}

/* Methods */

/** 
 * LongTermForecastData method 
 * @return LongTermForecastData
 */
public LongTermForecastData update()
{

	return this;
}

/**
 * changeTemperature method changes the temperature and throws NoDataFoundException
 */
public void changeTemperature(String unit1, String unit2) throws NoDataFoundException
{	
	if(longTermTemperature == null) throw new NoDataFoundException("No data");
	
	for(int i = 0; i < longTermTemperature.length ; i++)
	{
			longTermTemperature[i] = convertTemperature(unit1,unit2,longTermTemperature[i]);
			longTermMaxTemp[i] = convertTemperature(unit1,unit2,longTermMaxTemp[i]);
			longTermMinTemp[i] = convertTemperature(unit1,unit2,longTermMinTemp[i]);
	}
}

/**
 * convertTemperature converts the temperature
 * @return temp returns the converted temperature
 */
private float convertTemperature(String unit1, String unit2, float temp)
{
	if(unit1.equals("kelvin") && unit2.equals("celsius"))
	{
		temp = (float) (temp - 273.15);
		return temp;
	}
	else if(unit1.equals("celsius") && unit2.equals("kelvin")) 
	{
		temp = (float) (temp + 273.15);
		return temp;
	}
	else if(unit1.equals("kelvin") && unit2.equals("fahrenheit")) 
	{
		temp = ((float) ((temp - 273.0)*(9.0/5.0) + 32.0));
		return temp;
	}
	else if(unit1.equals("fahrenheit") && unit2.equals("kelvin"))
	{
		temp =  (float) ((temp - 32.0)*(5.0/9.0) + 273.0);
		return temp;
	}
	else if(unit1.equals("fahrenheit") && unit2.equals("celsius"))
	{
		temp =(float) ((temp-32.0)*(5.0/9.0));
		return temp;
	}
	else
	{
		temp = (float)((9.0/5.0)*temp + 32.0);
		return temp;
	}
}
}
