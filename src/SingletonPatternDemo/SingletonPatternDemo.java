package SingletonPatternDemo;

import java.time.format.DateTimeFormatter;

class Logger {
  // Private static variable to hold the single instance
  private static Logger instance;

  // Date formatter for consistent timestamp format
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  // Private constructor to prevent direct instantiation from outside
  private Logger() {
  }

  // returns the single instance of Logger
  // Method -> to creates the instance if it doesn't exist yet
  // lazy initialization
  public static Logger getInstance() {
    if (instance == null) {
      instance = new Logger();
    }
    return instance;
  }

  // log message with timestamp
  // param -> message to be logged
  public void log(String message) {
    String timestamp = java.time.LocalDateTime.now().format(formatter);
    System.out.println("[" + timestamp + "] : " + message);
  }

}

public class SingletonPatternDemo {
  public static void main(String[] args) {
    // multiple references to Logger
    Logger logg1 = Logger.getInstance();
    Logger logg2 = Logger.getInstance();
    Logger logg3 = Logger.getInstance();

    // to vefication -> they are the same instance
    System.err.println("Log 1 === Log 2: " + (logg1 == logg2));
    System.err.println("Log 2 === Log 3: " + (logg2 == logg3));
    System.err.println("Log 1 === Log 3: " + (logg1 == logg3));

    //// Log messages using different references
    logg1.log("Bunx run dev");
    logg2.log("Error : Db not found");
    logg3.log("Operation completed successfully");

  }

}