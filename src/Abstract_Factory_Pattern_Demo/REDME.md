# Abstract Factory Pattern

Family of related products – one factory interface

### 1.Package & Interfaces

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

### 2.Light Theme Family and Dark Theme Family
