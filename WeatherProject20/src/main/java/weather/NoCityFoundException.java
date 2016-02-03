package main.java.weather;

/**
 * NoCityFoundException is an exception class
 * @author Team 20
 */

public class NoCityFoundException extends Exception {

	   public NoCityFoundException (String message)
	   {
	      super ("No City Found " + message);
	   }

}
