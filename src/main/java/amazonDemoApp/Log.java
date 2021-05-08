package amazonDemoApp;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

public class Log {

	 private static Logger logger= LogManager.getLogger(Log.class);
	 
	 
	 public static void info(String message) {
		 
		 logger.debug(message);
		 
		 }
	 
}

