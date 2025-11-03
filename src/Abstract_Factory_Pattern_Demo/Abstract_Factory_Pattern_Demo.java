package Abstract_Factory_Pattern_Demo;

interface Button {
  void paint();
}

interface Checkbox {
  void check();
}

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

// Abstract Factory Interface && this is the main part of the pattern
interface UIFactory {
  Button createButton();

  Checkbox createCheckbox();
}

// Concrete Sub Factories
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
