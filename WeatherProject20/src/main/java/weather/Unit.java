package main.java.weather;


/**
 * Unit Class stores the units for the temperature
 * @author Team 20
 */

public class Unit {
	
	/* Instance Variables */
	private static final String KELVIN_UNIT = "kelvin";
	private static final String CELSIUS_UNIT = "celsius";
	private static final String FAHRENHEIT_UNIT = "fahrenheit";
	private static final double KELVIN_CONSTANT = 273.15;
	private String from_Unit;
	private String to_Unit;
	String current_unit;
	double temperature;
	
	/* Constructor */
	public Unit()
	{
		this.temperature = 0.0;
		this.current_unit = "";
	}
	public Unit(double temp, String unit)
	{
		this.temperature = temp;
		this.current_unit = unit; 
	}
	
    /* Methods */
	
	/**
	 * changeUnits changes the unit of the input string
	 * @param unit_to_change_to unit the unit to change
	 */
	public void changeUnits(String unit_to_change_to)
	{
		this.from_Unit = current_unit;
		this.to_Unit = unit_to_change_to;
		convertTemperature();
	}
	/**
	 * convertTemperature converts the temperature from Celsius, Kelvin or Fahrenheit to its corresponding temperature
	 * @return temp the temperature that has been converted
	 */
	private void convertTemperature()
	{
		if(kelvinToCelsius())
			temperature=K_to_C();
		else if(celsiusToKelvin()) 
			temperature=C_to_K();
		else if(kelvinToFahrenheit()) 
		{
			temperature=K_to_C();
			temperature=C_to_F();
		}
		else if(fahrenheitToKelvin())
		{
			temperature=F_to_C();
			temperature=C_to_K();
		}
		else if(fahrenheitToCelsius())
			temperature=F_to_C();
		else if(celsiusToFahrenheit()) //celsiusToFahrenheit 
			temperature=C_to_F();	
	}
	
	/**
	 * kelvinToCelsius converts the temperature from kelvinToCelsius
	 * @return boolean true if the units are correct, false if unit is not celcius or kelvin
	 */
	private boolean kelvinToCelsius()
	{
		if(from_Unit.equals(KELVIN_UNIT) && to_Unit.equals(CELSIUS_UNIT))
			return true;
		else
			return false;
	}
	
	/**
	 * K_to_C convert temperature from kelvin to celsius
	 * @return double return the new temperature
	 */
	private double K_to_C()
	{
		temperature = temperature - KELVIN_CONSTANT;
		return temperature;
	}
	
	/**
	 * celciusToKelvin private method to check if celsius or kelvin
	 * @return boolean return true if the unit is celsius or kelvin and not anything else
	 */
	private boolean celsiusToKelvin()
	{
		if(from_Unit.equals(CELSIUS_UNIT) && to_Unit.equals(KELVIN_UNIT)) 
			return true;
		else
			return false;
	}
	
	/**
	 * C_to_k convert the temperature from celcius to kelvin
	 * @return the new temperature that is converted
	 */
	private double C_to_K()
	{
		temperature = temperature + KELVIN_CONSTANT;
		return temperature;
	}
	
	/**
	 * kelvinToFahrenheit converts from kelvin to fahrenheit
	 * @return boolean if the units are kelvin or fahrenheit, else return false
	 */
	private boolean kelvinToFahrenheit()
	{
		if(from_Unit.equals(KELVIN_UNIT) && to_Unit.equals(FAHRENHEIT_UNIT)) 
			return true;
		else
			return false;
	}
	
	/** 
	 * fahrenheitToKelvin convert from fahrenheitToKelvin
	 * @return return true if is fahrenheit or kelvin, else return false
	 */
	private boolean fahrenheitToKelvin()
	{
		if(from_Unit.equals(FAHRENHEIT_UNIT) && to_Unit.equals(KELVIN_UNIT))
			return true;
		else
			return false;
	}
	
	/**
	 * fahrenheitToCelsius check if the units from and to is fahrenheit and celcius
	 * @return boolean true if the units are fahrenheit and celcius, false if something else
	 */
	private boolean fahrenheitToCelsius()
	{
		if(from_Unit.equals(FAHRENHEIT_UNIT) && to_Unit.equals(CELSIUS_UNIT))
			return true;
		else
			return false;
	}
	
	/**
	 * F_to_C converts from fahrenheit to celcius
	 * @return double the new temperature converted
	 */
	private double F_to_C()
	{
		temperature = (temperature - 32.0)/(9.0/5.0);
		return temperature;
	}
	
	/**
	 * celsiusToFahrenheit converts from celsius to Fahrenheit
	 * @return boolean true if the units are celsius and fahrenheit, false otherwise
	 */
	private boolean celsiusToFahrenheit()
	{
		if(from_Unit.equals(CELSIUS_UNIT) && to_Unit.equals(FAHRENHEIT_UNIT))
			return true;
		else
			return false;
	}
	
	/**
	 * C_to_F converts from celsius to fahrenheit
	 * @return double the temperature converted from celsius to fahrenheit
	 */
	private double C_to_F()
	{
		temperature = temperature * (9.0/5.0) + 32.0;
		return temperature;
	}
	
}
