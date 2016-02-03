package main.java.weather;

/**
 * ShortTermForecastData is a class containing the data for short term forecast
 * @author Team 20
 */

public class ShortTermForecastData{

/* Instance Variables */
private String[] forecastTimeList;
private float[] shortTermTemperature;
private int[] shortTermSkyConditionID;

/* Constructor */
public ShortTermForecastData(){
	forecastTimeList = null;
	shortTermTemperature = null;
	shortTermSkyConditionID = null;
}

/* Methods */

/**
 * ShortTermForecastData 
 * @return ShortTermForecastData
 */
public ShortTermForecastData update()
{
	return this;
}

/**
 * changeTemperature method changes the temperature
 * @param unit1 first unit, unit2 second unit
 */
public void changeTemperature(String unit1, String unit2) throws NoDataFoundException
{	
	if(shortTermTemperature == null) throw new NoDataFoundException("No data");
	
	for(int i = 0; i < shortTermTemperature.length ; i++)
	{
			shortTermTemperature[i] = convertTemperature(unit1,unit2,shortTermTemperature[i]);
	}
}

/**
 * convertTemperature
 * @param unit1 first unit, unit2 second unit, temp temperature to be converted
 * @return temperature that is converted
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
