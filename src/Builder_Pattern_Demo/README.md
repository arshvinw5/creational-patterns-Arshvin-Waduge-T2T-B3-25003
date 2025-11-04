# Builder pattern

The Builder Pattern helps create complex objects step by step.

### 1. Creating Private Variable and constructor

```
private String CPU;
  private int RAM;
  private int storage;
  private String graphicsCard;

  // Private constructor to force use of Builder
  private Computer(Builder builder) {
    this.CPU = builder.CPU;
    this.RAM = builder.RAM;
    this.storage = builder.storage;
    this.graphicsCard = builder.graphicsCard;
  }

```

- The reason -> to prevent direct access from the outside ( new Computer() )
- letting it to get the copies values from the builder into the Computer

### 2. Static nested Builder class

```
public static class Builder {
    private String CPU;
    private int RAM;
    private int storage;
    private String graphicsCard;

    // Setter methods for each attribute
    public Builder setCPU(String CPU) {
      this.CPU = CPU;
      return this;
    }

    public Builder setRAM(int RAM) {
      this.RAM = RAM;
      return this;
    }

    public Builder setStorage(int storage) {
      this.storage = storage;
      return this;
    }

    public Builder setGraphicsCard(String graphicsCard) {
      this.graphicsCard = graphicsCard;
      return this;
    }

    // Build method to create Computer instance
    public Computer build() {
      return new Computer(this);
    }
  }

```

- static nested so it doesn't require an instance of Computer to be created.
- Holds values of fields temporary while building

```
 public Builder setRAM(int RAM) {
      this.RAM = RAM;
      return this;
 }

```

- Setter like methods that return " this " to call update builder state and returns the same Builder instance so that can be chained.

### 3. build() method

```
    public Computer build() {
      return new Computer(this);
    }

```

- Final step that constructs the Computer ( new Computer ) using the builder’s values.
- this is a good place to put validation before constructing it

### 4. To display the constructed object

```
@Override
  public String toString() {
    return "Computer : " +
        "CPU='" + CPU + '\'' +
        ", RAM=" + RAM + "GB" +
        ", Storage=" + storage + "GB" +
        ", Graphics Card='" + graphicsCard + '\'';

  }

```

- this is highly optional but useful to inspect the constructed object.

# When it should be used

- Main purpose of using the Builder Pattern when your object has many parameters, optional fields, or you want a clean, readable, unable to change the way to construct it.
- real world -> this is perfect for add optional contact info, address, preferences in user account's settings
