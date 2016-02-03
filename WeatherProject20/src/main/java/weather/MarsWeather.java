package main.java.weather;

public class MarsWeather {
 public Report report;

 
public Report getReport() {
	return report;
}

public void setReport(Report report) {
	this.report = report;
}

public class Report{
	 public String terristrial_date;
	 public String sol;
	 public double ls;
	 public float min_temp;
	 public float min_temp_fahrenheit;
	 public float max_temp;
	 public float max_temp_fahrenheit;
	 public float pressure;
	 public String pressure_string;
	 public String abs_humidity;
	 public String wind;
	 public String wind_direction;
	 public String atmo_opacity;
	 public String season;
	 public String sunrise;
	 public String sunset;
	public String getTerristrial_date() {
		return terristrial_date;
	}
	public String getSol() {
		return sol;
	}
	public double getLs() {
		return ls;
	}
	public float getMin_temp() {
		return min_temp;
	}
	public float getMin_temp_fahrenheit() {
		return min_temp_fahrenheit;
	}
	public float getMax_temp() {
		return max_temp;
	}
	public float getMax_temp_fahrenheit() {
		return max_temp_fahrenheit;
	}
	public float getPressure() {
		return pressure;
	}
	public String getPressure_string() {
		return pressure_string;
	}
	public String getAbs_humidity() {
		return abs_humidity;
	}
	public String getWind() {
		return wind;
	}
	public String getWind_direction() {
		return wind_direction;
	}
	public String getAtmo_opacity() {
		return atmo_opacity;
	}
	public String getSeason() {
		return season;
	}
	public String getSunrise() {
		return sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setTerristrial_date(String terristrial_date) {
		this.terristrial_date = terristrial_date;
	}
	public void setSol(String sol) {
		this.sol = sol;
	}
	public void setLs(double ls) {
		this.ls = ls;
	}
	public void setMin_temp(float min_temp) {
		this.min_temp = min_temp;
	}
	public void setMin_temp_fahrenheit(float min_temp_fahrenheit) {
		this.min_temp_fahrenheit = min_temp_fahrenheit;
	}
	public void setMax_temp(float max_temp) {
		this.max_temp = max_temp;
	}
	public void setMax_temp_fahrenheit(float max_temp_fahrenheit) {
		this.max_temp_fahrenheit = max_temp_fahrenheit;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public void setPressure_string(String pressure_string) {
		this.pressure_string = pressure_string;
	}
	public void setAbs_humidity(String abs_humidity) {
		this.abs_humidity = abs_humidity;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public void setWind_direction(String wind_direction) {
		this.wind_direction = wind_direction;
	}
	public void setAtmo_opacity(String atmo_opacity) {
		this.atmo_opacity = atmo_opacity;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
 }
}
