package main.java.weather;

public class LongTermWeatherValue {
	private String cod; 
	private double message;
	private City city;
	private int cnt;
	private java.util.List<List> list;
	
	public class City{
		private long id;
		private String name, country;
		private Coord coord;
		private int population;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
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
		public int getPopulation() {
			return population;
		}
		public void setPopulation(int population) {
			this.population = population;
		}
	}
	public class List{
		private long dt;
		private Temp temp;
		private double pressure, speed, rain;
		private int humidity, deg, clouds;
		private java.util.List<Weather> weather;
		public long getDt() {
			return dt;
		}
		public void setDt(long dt) {
			this.dt = dt;
		}
		public Temp getTemp() {
			return temp;
		}
		public void setTemp(Temp temp) {
			this.temp = temp;
		}
		public double getPressure() {
			return pressure;
		}
		public void setPressure(double pressure) {
			this.pressure = pressure;
		}
		public double getSpeed() {
			return speed;
		}
		public void setSpeed(double speed) {
			this.speed = speed;
		}
		public double getRain() {
			return rain;
		}
		public void setRain(double rain) {
			this.rain = rain;
		}
		public int getHumidity() {
			return humidity;
		}
		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}
		public int getDeg() {
			return deg;
		}
		public void setDeg(int deg) {
			this.deg = deg;
		}
		public int getClouds() {
			return clouds;
		}
		public void setClouds(int clouds) {
			this.clouds = clouds;
		}
		public java.util.List<Weather> getWeather() {
			return weather;
		}
		public void setWeather(java.util.List<Weather> weather) {
			this.weather = weather;
		} 
	
	}
	public class Coord{

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
	public class Temp{
		private double day, min, max, night, eve, morn;

		public double getDay() {
			return day;
		}

		public void setDay(double day) {
			this.day = day;
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

		public double getNight() {
			return night;
		}

		public void setNight(double night) {
			this.night = night;
		}

		public double getEve() {
			return eve;
		}

		public void setEve(double eve) {
			this.eve = eve;
		}

		public double getMorn() {
			return morn;
		}

		public void setMorn(double morn) {
			this.morn = morn;
		}
	}
	public class Weather{
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
