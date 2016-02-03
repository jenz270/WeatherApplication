package main.java.weather;

/**
 * NoDataFoundException is an exception class
 * @author Team 20
 */

public class NoDataFoundException extends Exception {
	
	   public NoDataFoundException(String message)
	   {
	      super ("No Data Found " + message);
	   }
}
