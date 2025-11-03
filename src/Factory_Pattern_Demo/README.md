# Factory Method Pattern Demo

Factory Method Pattern so the client does NOT use new to create shapes. Instead, a factory decides which shape to create.

### 1. Shape Interface

```
interface Shape {
  void draw();
}

```

- implement draw method to create concrete shape class

### 2. Concrete Shape Classes

- Creating Circle class by implementing shape interface

```
class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Circle");
  }
}

```

- Creating Square class by implementing shape interface

```
class Square implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Square");
  }
}

```

- Creating Square class by implementing shape interface

```
class Rectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Rectangle");
  }
}
```

### 3. The Factory Class

- This is the factory method class then Based on your input type this will create the new object

```
class ShapeFactory {
  public Shape getShape(String shapeType) {
    if (shapeType == null) {
      return null;
    }
    if (shapeType.equalsIgnoreCase("CIRCLE")) {
      return new Circle();
    } else if (shapeType.equalsIgnoreCase("SQUARE")) {
      return new Square();
    } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
      return new Rectangle();
    }
    return null;
  }
}

```

- if condition -> validation for string request
- if the request is "null" then it will throw exception for invalid shape type

### 4. The Client (User of Factory)

```
public class Factory_Patten_Demo {
  public static void main(String[] args) {
    ShapeFactory factory = new ShapeFactory();

    // Get shapes via factory — NO 'new' used here!
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

```

- create new object from the ShapeFactory
- fetch the shapes via params in getShape method
- if condition : check the request is nullable before draw it
- Output : invalid request

## When it should be used

1. GUI Toolkits

2. Database Drivers -> DriverManager.getConnection()Returns correct DB driver

3. Logging Frameworks
