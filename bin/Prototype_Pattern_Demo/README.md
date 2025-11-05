# Prototype Pattern?

Prototype Pattern lets you make copies of existing objects instead of creating new ones manually.

Reason for this -> Sometimes, creating an object is expensive or complex, maybe it loads data from a file or database.
So instead of repeating that setup again, you just clone the original.

### 1 Implements Cloneable

```
class Document implements Cloneable {}

private String title;
private StringBuilder content;

public Document(String title, String content) {
    this.title = title;
    this.content = new StringBuilder(content);
 }

```

- Cloneable key words tell that in Java that this class supports cloning.
- Without it, calling super.clone() would throw an exception.
- creating variables and constructor

- "StringBuilder" is a class in Java used to store and change text without creating new String objects every time.

- String = immutable (cannot be changed once created) / StringBuilder = mutable (you can change it directly)

- Every time you modify a String, Java makes a new copy — this is slow if you do it many times.

- We use StringBuilder instead of String because document content might change (add, remove, edit text). If we used a String, each edit would create a new object

- Reason for : new StringBuilder ->Then both the original and the clone would share the same StringBuilder object in memory. So if you edit the content in the clone, it would also change in the original. By creating a new StringBuilder, we make a deep copy, giving each document its own memory space.

### 2 Overrides clone()

```
@Override
  public Document clone() {
    try {
      // shallow copy first
      Document copy = (Document) super.clone();
      // deep copy for mutable fields
      copy.content = new StringBuilder(this.content.toString());
      return copy;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError(); // should not happen
    }
  }

```

- The method header : you’re overriding clone() from Object. // public Document clone() this will return a new Document object (a copy).

- The try / catch : super.clone() can throw CloneNotSupportedException if the class does not implement Cloneable. and Because Document implements Cloneable, this exception should never occur — so the code converts it to an AssertionError (a runtime error) to indicate "this should not happen".

- super.clone() : This creates a copy of the current object
- Copies references for objects (eg: StringBuilder) — both original and copy now reference the same StringBuilder instance.
- then We assign the result to Document because super.clone() returns Object.
- this.content.toString() creates a String snapshot of the original content.
- new StringBuilder(content) makes a brand-new StringBuilder containing the same characters as I mentioned this above
- Assigning it to copy.content means the clone now owns a separate StringBuilder object.
- then return the copy of the object

### 3. Getter and setting for alter the clone object

```

  public String getTitle() {
    return title;
  }

  public StringBuilder getContent() {
    return content;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = new StringBuilder(content);
  }

```

- Getter for title : For get the title
- Getter for Content : FOr get the content and Returns the current StringBuilder object holding the document’s text. and purpose of it as mentioned earlier to not to change the original object
- Setter for title : To set the title field
- Setter for content : Updates the document’s content and Instead of assigning directly, it creates a new StringBuilder with the given string value

### 5. To Display

```
 @Override
  public String toString() {
    return "Document :" +
        "title='" + title + '\'' +
        ", content='" + content + '\'';
  }

```

- To display the original doc or clone doc in println

# When to use it

- Object creation is expensive or complex
- You need many similar objects
- You want to avoid multiple new + constructor setups
