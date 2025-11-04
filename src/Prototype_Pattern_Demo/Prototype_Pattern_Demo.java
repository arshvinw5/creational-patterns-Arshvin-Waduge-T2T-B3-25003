package Prototype_Pattern_Demo;

class Document implements Cloneable {
  private String title;
  private StringBuilder content;

  public Document(String title, String content) {
    this.title = title;
    this.content = new StringBuilder(content);
  }

  // Implement clone()
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

  // getters and setters
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

  @Override
  public String toString() {
    return "Document :" +
        "title='" + title + '\'' +
        ", content='" + content + '\'';
  }

}

public class Prototype_Pattern_Demo {
  public static void main(String[] args) {
    Document originalDoc = new Document("Original Title", "This is the original content.");
    System.out.println("Original Document: " + originalDoc);

    // Clone the original document
    Document clonedDoc = originalDoc.clone();
    System.out.println("Cloned Document: " + clonedDoc);

    // Modify the cloned document
    clonedDoc.setTitle("Cloned Title");
    clonedDoc.getContent().append(" This content is modified in the clone.");

    // Display both documents to show the changes
    System.out.println("After modification:");
    System.out.println("Original Document: " + originalDoc);
    System.out.println("Cloned Document: " + clonedDoc);
  }

}
