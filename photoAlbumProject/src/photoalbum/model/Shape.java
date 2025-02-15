package photoalbum.model;


import java.util.Objects;

/**
 * The Shape class represents a generic shape in the photo album.
 * It implements the IShape interface and provides properties and behaviors
 * common to all shapes, such as position, dimensions, and color.
 */
public abstract class Shape implements IShape {
  protected String name;
  protected double X;
  protected double Y;
  protected double width;
  protected double height;
  protected Color color;

  /**
   * Constructs a Shape object with the specified parameters.
   *
   * @param name   the name of the shape
   * @param X      the X-coordinate of the shape
   * @param Y      the Y-coordinate of the shape
   * @param width  the width of the shape
   * @param height the height of the shape
   * @param color  the color of the shape
   */
  public Shape(String name, double X, double Y, double width, double height,
               Color color) {
    this.name = name;
    this.X = X;
    this.Y = Y;
    this.width = width;
    this.height = height;
    this.color = color;
  }

  /**
   * Gets the name of the shape.
   *
   * @return the name of the shape
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Gets the X-coordinate of the shape.
   *
   * @return the X-coordinate of the shape
   */
  @Override
  public double getX() {
    return this.X;
  }

  /**
   * Sets the X-coordinate of the shape.
   *
   * @param x the new X-coordinate
   */
  @Override
  public void setX(double x) {
    this.X = x;
  }

  /**
   * Gets the Y-coordinate of the shape.
   *
   * @return the Y-coordinate of the shape
   */
  @Override
  public double getY() {
    return this.Y;
  }

  /**
   * Sets the Y-coordinate of the shape.
   *
   * @param y the new Y-coordinate
   */
  @Override
  public void setY(double y) {
    this.Y = y;
  }

  /**
   * Gets the width of the shape.
   *
   * @return the width of the shape
   */
  @Override
  public double getWidth() {
    return this.width;
  }

  /**
   * Sets the width of the shape.
   *
   * @param width the new width of the shape
   */
  @Override
  public void setWidth(double width) {
    this.width = width;
  }

  /**
   * Gets the height of the shape.
   *
   * @return the height of the shape
   */
  @Override
  public double getHeight() {
    return this.height;
  }

  /**
   * Sets the height of the shape.
   *
   * @param height the new height of the shape
   */
  @Override
  public void setHeight(double height) {
    this.height = height;
  }

  /**
   * Gets the color of the shape.
   *
   * @return the color of the shape
   */
  @Override
  public Color getColor() {
    return new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
  }

  /**
   * Changes the color of the shape.
   *
   * @param r the red component of the new color
   * @param g the green component of the new color
   * @param b the blue component of the new color
   */
  @Override
  public void changeColor(double r, double g, double b) {
    this.color = new Color(r, g, b);
  }

  /**
   * Checks if this shape is equal to another object based on its name.
   *
   * @param obj the object to compare to
   * @return true if the object is a shape with the same name, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Shape shape = (Shape) obj;
    return name.equals(shape.name);
  }

  /**
   * Returns the hash code of the shape, based on its properties.
   *
   * @return the hash code of the shape
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, width, height, color);
  }

  /**
   * Creates and returns a copy of the shape.
   *
   * @return a new Shape object that is an exact copy of the current shape
   */
  public abstract Shape copy();

}
