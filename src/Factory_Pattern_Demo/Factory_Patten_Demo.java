package Factory_Pattern_Demo;

//interface to define shape
interface Shape {
  void draw();
}

// Concrete Classes

class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Circle");
  }
}

class Square implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Square");
  }
}

class Rectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Rectangle");
  }
}

// Factory class to generate object of concrete class based on params

class ShapeFactory {
  public Shape getShape(String shapeType) {
    if (shapeType == null) {
      return null;
    }
    if (shapeType.equalsIgnoreCase("circle")) {
      return new Circle();
    } else if (shapeType.equalsIgnoreCase("square")) {
      return new Square();
    } else if (shapeType.equalsIgnoreCase("rectangle")) {
      return new Rectangle();
    }

    // to throw a exception for invalid shape type
    return null;
  }

}

public class Factory_Patten_Demo {
  public static void main(String[] args) {
    ShapeFactory factory = new ShapeFactory();

    // Get shapes via factory
    Shape circleShape = factory.getShape("circle");
    Shape rectangleShape = factory.getShape("rectangle");
    Shape squareShape = factory.getShape("square");

    // for validation of shapes
    if (circleShape != null)
      circleShape.draw();
    if (rectangleShape != null)
      rectangleShape.draw();
    if (squareShape != null)
      squareShape.draw();

    // if it is an invalid shape
    Shape invalid = factory.getShape("triangle");
    if (invalid == null) {
      System.out.println("Unknown shape requested.");
    }
  }
}