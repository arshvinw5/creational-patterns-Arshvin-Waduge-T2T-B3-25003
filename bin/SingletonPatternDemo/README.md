# Singleton Pattern Demo

Ensure a class has only one instance and provide a global point of access to it.

1. Creating a Class and Static Instance

`sh private static Logger instance; `

- private : No other class can access or modify instance.
- static : Belongs to the class, not an object. There must be one copy ( object ) -> the whole program

2. Private Constructor

`private Logger() {}`

- You cannot do new Logger() from anywhere else.
- Logger can be create `inside of the logger class`
- To make sure -> only one instance

  3.The Global Access Point

```sh
public static Logger getInstance() {
    if (instance == null) {
      instance = new Logger();
    }
    return instance;
  }
```

- via this method we can access the intance to create an object
- Check: Is instance still null?
- if yes → create the one and only Logger
- If no → just return the existing one
- Return the same object every time

4. The log() Method

```sh
public void log(String message) {
    String timestamp = java.time.LocalDateTime.now().format(formatter);
    System.out.println("[" + timestamp + "] : " + message);
  }
```

- to print the message with timestamp when pass it through params

5. main() Method

````sh
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


--```
````

- logger1, logger2, logger3 are all the same object
- " == " checks reference whether are they the same instance?
- All log messages go through the same Logger

### When it should be used

Mostly use this for Database connection pool or anything what need multiple instance in any program

- real work I used this pattern to build a connection with SQL light for implement offline db in Flutter
