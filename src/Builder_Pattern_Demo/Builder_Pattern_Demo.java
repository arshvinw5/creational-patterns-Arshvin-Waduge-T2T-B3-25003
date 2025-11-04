package Builder_Pattern_Demo;

class Computer {
  // creating private variables
  private final String CPU;
  private final int RAM;
  private final int storage;
  private final String graphicsCard;

  // Private constructor to force use of Builder
  private Computer(Builder builder) {
    this.CPU = builder.CPU;
    this.RAM = builder.RAM;
    this.storage = builder.storage;
    this.graphicsCard = builder.graphicsCard;
  }

  // Static nested Builder class
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

  // To displaying the Computer configuration

  @Override
  public String toString() {
    return "Computer : " +
        "CPU='" + CPU + '\'' +
        ", RAM=" + RAM + "GB" +
        ", Storage=" + storage + "GB" +
        ", Graphics Card='" + graphicsCard + '\'';

  }
}

public class Builder_Pattern_Demo {
  public static void main(String[] args) {
    // Using the Builder to create a Computer instance
    Computer Laptop = new Computer.Builder()
        .setCPU("Intel i9")
        .setRAM(32)
        .setStorage(1000)
        .setGraphicsCard("NVIDIA GTX 4080")
        .build();

    // Displaying the Computer configuration
    System.out.println(Laptop);
  }

}
