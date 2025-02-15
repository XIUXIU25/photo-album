package photoalbum.model;

/**
 * The IShape interface defines the structure and behavior of a geometric shape.
 * Shapes implementing this interface have properties such as position, size, and color,
 * and provide methods to manipulate and retrieve these properties.
 */
public interface IShape {

  /**
   * Returns the name of the shape.
   *
   * @return the name of the shape
   */
  String getName();

  /**
   * Returns the X-coordinate of the shape.
   *
   * @return the X-coordinate
   */
  double getX();

  /**
   * Sets the X-coordinate of the shape.
   *
   * @param x the new X-coordinate
   */
  void setX(double x);

  /**
   * Returns the Y-coordinate of the shape.
   *
   * @return the Y-coordinate
   */
  double getY();

  /**
   * Sets the Y-coordinate of the shape.
   *
   * @param y the new Y-coordinate
   */
  void setY(double y);

  /**
   * Returns the width of the shape.
   *
   * @return the width of the shape
   */
  double getWidth();

  /**
   * Sets the width of the shape.
   *
   * @param width the new width
   */
  void setWidth(double width);

  /**
   * Returns the height of the shape.
   *
   * @return the height of the shape
   */
  double getHeight();

  /**
   * Sets the height of the shape.
   *
   * @param height the new height
   */
  void setHeight(double height);

  /**
   * Returns the color of the shape.
   *
   * @return the color of the shape
   */
  Color getColor();

  /**
   * Changes the color of the shape to the specified RGB values.
   *
   * @param r the red component of the new color (0.0 to 1.0)
   * @param g the green component of the new color (0.0 to 1.0)
   * @param b the blue component of the new color (0.0 to 1.0)
   */
  void changeColor(double r, double g, double b);
}

