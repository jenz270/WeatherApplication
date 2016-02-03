# Team 20 Weather 

### Description
A weather viewing program that allows a user to view the current weather in their current location.   
Other features included in this app is to allow multiple locations to be selected, a short term forecast and a long term forecast. 

### Synoposis
This application is implemented with java. Earth weather data was obtained from [Open Weather Map API](http://openweathermap.org) and Mars data from [Mars Atmospheric Aggregation System API](http://marsweather.ingenology.com/). The group had also developed this project in the Intellij IDE, used git for version control and also maven for build automation.

A list of the libraries used can be found below:
* java.io.*
* javax.swing.*
* java.awt.*;
* java.awt.event.*;
* java.util.*;
* java.net.*;
* java.text.*;
* java.imageio.*;

### Install
Installation would require the following components and configurations:
* Maven
* Github
* Latest version of Java

After these are all set up, you can follow the next few instructions to get a copy of the application on your computer and test run the program:

1. Clone the repo with the following code
   ` git clone git@github.com:UWO-2212-W2015/team20.git `
2. Change the directory with the `cd` command into the *WeatherProject20* folder that is in the folder where the repo had been clone to
3. Build the maven package with the code `mvn package`
4. Run the program with `java -jar target/Weather-App-1.0-SNAPSHOT-jar-with-dependencies.jar`

### Build
In order to build the software, you would have follow steps 1-3 from the installation instructions. 

Some dependencies that are required:
* json-lib
* commons-io
* org.json

### Usage Example

Here you can find a video as a guide to navigate around the program:
[Usage Guide](https://www.youtube.com/watch?v=TquBZH7Ji_w)

### Documentation

You can find a copy of our code documentations here:
[JavaDoc](https://github.com/UWO-2212-W2015/team20/blob/master/WeatherProject20/doc/index.html)