package main.java.weather;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShortTermWeatherValue {
	private String cod;
	private double message;
	private City city; 
	private int cnt;
	private java.util.List<List> list;

	public class City
	{
		private long id, population; 
		private String name, country;  
		private Coord coord; 

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getPopulation() {
			return population;
		}

		public void setPopulation(long population) {
			this.population = population;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public Coord getCoord() {
			return coord;
		}

		public void setCoord(Coord coord) {
			this.coord = coord;
		}
	}
	public class Coord
	{
		private double lon, lat;

		public double getLon() {
			return lon;
		}

		public void setLon(double lon) {
			this.lon = lon;
		}

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}

	}
	public class List
	{
		private long dt;
		private Main main;
		private java.util.List<Weather> weather;
		private Clouds clouds;
		private Wind wind;
		private Rain rain;
		private Sys sys;
		private String dt_txt;


		public long getDt() {
			return dt;
		}

		public void setDt(long dt) {
			this.dt = dt;
		}

		public Main getMain() {
			return main;
		}

		public void setMain(Main main) {
			this.main = main;
		}

		public java.util.List<Weather> getWeather() {
			return weather;
		}

		public void setWeather(java.util.List<Weather> weather) {
			this.weather = weather;
		}

		public Clouds getClouds() {
			return clouds;
		}

		public void setClouds(Clouds clouds) {
			this.clouds = clouds;
		}

		public Wind getWind() {
			return wind;
		}

		public void setWind(Wind wind) {
			this.wind = wind;
		}

		public Rain getRain() {
			return rain;
		}

		public void setRain(Rain rain) {
			this.rain = rain;
		}

		public Sys getSys() {
			return sys;
		}

		public void setSys(Sys sys) {
			this.sys = sys;
		}

		public String getDt_txt() {
			return dt_txt;
		}

		public void setDt_txt(String dt_txt) {
			this.dt_txt = dt_txt;
		}
	}
	public class Main
	{
		private double temp, temp_min, temp_max, pressure, 
		sea_level, grnd_level;
		private int humidity, tmp_kf;
		public double getTemp() {
			return temp;
		}
		public void setTemp(double temp) {
			this.temp = temp;
		}
		public double getTemp_min() {
			return temp_min;
		}
		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}
		public double getTemp_max() {
			return temp_max;
		}
		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}
		public double getPressure() {
			return pressure;
		}
		public void setPressure(double pressure) {
			this.pressure = pressure;
		}
		public double getSea_level() {
			return sea_level;
		}
		public void setSea_level(double sea_level) {
			this.sea_level = sea_level;
		}
		public double getGrnd_level() {
			return grnd_level;
		}
		public void setGrnd_level(double grnd_level) {
			this.grnd_level = grnd_level;
		}
		public int getHumidity() {
			return humidity;
		}
		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}
		public int getTmp_kf() {
			return tmp_kf;
		}
		public void setTmp_kf(int tmp_kf) {
			this.tmp_kf = tmp_kf;
		}
	}
	public class Weather
	{
		private int id;
		private String main, description, icon;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMain() {
			return main;
		}
		public void setMain(String main) {
			this.main = main;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
	}
	public class Clouds
	{
		private int all;

		public int getAll() {
			return all;
		}

		public void setAll(int all) {
			this.all = all;
		}
	}
	public class Wind
	{
		private double speed, deg;

		public double getSpeed() {
			return speed;
		}

		public void setSpeed(double speed) {
			this.speed = speed;
		}

		public double getDeg() {
			return deg;
		}

		public void setDeg(double deg) {
			this.deg = deg;
		}

	}

	public class Rain
	{
		@SerializedName("3h")
		private double _3h;

		public double get_3h() {
			return _3h;
		}

		public void set_3h(double _3h) {
			this._3h = _3h;
		}
	}
	public class Sys
	{
		private String pod;

		public String getPod() {
			return pod;
		}

		public void setPod(String pod) {
			this.pod = pod;
		}

	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public double getMessage() {
		return message;
	}
	public void setMessage(double message) {
		this.message = message;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public java.util.List<List> getList() {
		return list;
	}
	public void setList(java.util.List<List> list) {
		this.list = list;
	}
}
