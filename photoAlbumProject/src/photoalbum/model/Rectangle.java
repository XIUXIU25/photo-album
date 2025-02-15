package photoalbum.model;

/**
 * The Rectangle class represents a rectangle shape in the photo album.
 * It is a subclass of Shape and includes properties specific to rectangles,
 * such as width and height.
 */
public class Rectangle extends Shape {

  /**
   * Constructs a Rectangle object with the specified parameters.
   *
   * @param name   the name of the rectangle
   * @param X      the X-coordinate of the minimum corner
   * @param Y      the Y-coordinate of the minimum corner
   * @param width  the width of the rectangle
   * @param height the height of the rectangle
   * @param color  the color of the rectangle
   */
  public Rectangle(String name, double X, double Y, double width, double height, Color color) {
    super(name, X, Y, width, height, color);
  }

  /**
   * Returns a string representation of the rectangle, including its name, type, position,
   * dimensions, and color.
   *
   * @return a string representation of the rectangle
   */
  @Override
  public String toString() {
    return "Name: " + getName()
        + "\nType: rectangle"
        + "\nMin corner: (" + getX() + "," + getY() + "),  Width: " + width
        + ", Height: " + height + ", Color: (" + this.color.getRed() + "," + this.color.getGreen()
        + "," + this.color.getBlue() + ")" + "\n";
  }

  /**
   * Creates and returns a copy of the shape.
   *
   * @return a new Shape object that is an exact copy of the current shape
   */
  public Shape copy() {
    return new Rectangle(this.name, this.X, this.Y, this.getWidth(), this.getHeight(),
        this.getColor());
  }
}
