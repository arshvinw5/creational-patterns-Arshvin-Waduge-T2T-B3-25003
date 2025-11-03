# Abstract Factory Pattern

Family of related products – one factory interface

### 1. Package & Interfaces

```
interface Button {
  void paint();
}

interface Checkbox {
  void check();
}

```

- Creating interface for abstract products to define what UI elements can do
- contracts for any button must paint() and any checkbox must check()

### 2. Light Theme Family and Dark Theme Family

```
// light theme family
class LightButton implements Button {
  public void paint() {
    System.out.println("Light Button painted");
  }
}

class LightCheckbox implements Checkbox {
  public void check() {
    System.out.println("Light Checkbox checked");
  }
}

// dark theme family
class DarkButton implements Button {
  public void paint() {
    System.out.println("Dark Button painted");
  }
}

class DarkCheckbox implements Checkbox {
  public void check() {
    System.out.println("Dark Checkbox checked");
  }
}

```

- These are concrete products in the Light family and Dark family

### 3. Abstract Factory Interface – The Core

```
interface UIFactory {
  Button createButton();

  Checkbox createCheckbox();
}

```

- This is the heart of Abstract Factory
- This factory create multiple related objects
- All ui elements change via this
- this will create two different sub concrete factories

### 4. Concrete Factories

```
class LightThemeFactory implements UIFactory {
  public Button createButton() {
    return new LightButton();
  }

  public Checkbox createCheckbox() {
    return new LightCheckbox();
  }
}

class DarkThemeFactory implements UIFactory {
  public Button createButton() {
    return new DarkButton();
  }

  public Checkbox createCheckbox() {
    return new DarkCheckbox();
  }

}

```

- Each factory returns its own family

### 5. Factory of Factories

```
class ThemeFactoryProvider {
  public static UIFactory getFactory(String theme) {
    if (theme.equalsIgnoreCase("light")) {
      return new LightThemeFactory();
    } else if (theme.equalsIgnoreCase("dark")) {
      return new DarkThemeFactory();
    }
    return null;
  }
}

```

- this class will help us to toggle the theme according to client choose
- this a static method and gets full dark or light ui factory

### 6. Client Code

```
public class Abstract_Factory_Pattern_Demo {
  public static void main(String[] args) {

    String darkTheme = "dark";
    String lightTheme = "light";

    // this must be done by user preference

    UIFactory darkThemeFactory = ThemeFactoryProvider.getFactory(darkTheme);
    UIFactory lightThemeFactory = ThemeFactoryProvider.getFactory(lightTheme);

    Button darkButton = darkThemeFactory.createButton();
    Checkbox darkCheckbox = darkThemeFactory.createCheckbox();
    darkButton.paint();
    darkCheckbox.check();

    Button lightButton = lightThemeFactory.createButton();
    Checkbox lightCheckbox = lightThemeFactory.createCheckbox();
    lightButton.paint();
    lightCheckbox.check();

  };

}

```

- this is client code and object creation for toggle the theme according to client's choose

## When it should be used

- You have multiple families of related objects
- payment system
- to implement ui for fast food chains or super markets
- main reason -> Object creation requires coordination
