package exceptions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CustomException extends RuntimeException {
    private final Logger log = LogManager.getLogger(CustomException.class);

   public CustomException(String message, Exception e) {
       super(message, e);
       log.error(message);
    }
}
