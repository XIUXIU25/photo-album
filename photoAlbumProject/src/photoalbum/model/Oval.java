package photoalbum.model;

/**
 * The Oval class represents an oval shape in the photo album.
 * It is a subclass of Shape and includes specific properties for an oval,
 * such as the radii along the X and Y axes.
 */
public class Oval extends Shape {
  private double radiusX;
  private double radiusY;

  /**
   * Constructs an Oval object with the specified parameters.
   *
   * @param name    the name of the oval
   * @param X       the X-coordinate of the center
   * @param Y       the Y-coordinate of the center
   * @param radiusX the radius along the X-axis
   * @param radiusY the radius along the Y-axis
   * @param color   the color of the oval
   */
  public Oval(String name, double X, double Y, double radiusX, double radiusY, Color color) {
    super(name, X, Y, radiusX, radiusY, color);
    this.radiusX = radiusX;
    this.radiusY = radiusY;
  }

  /**
   * Returns the radius of the oval along the X-axis.
   *
   * @return the radius along the X-axis
   */
  public double getRadiusX() {
    return radiusX;
  }

  /**
   * Sets the radius of the oval along the X-axis.
   *
   * @param radiusX the new radius along the X-axis
   */
  public void setRadiusX(double radiusX) {
    this.radiusX = radiusX;
  }

  /**
   * Returns the radius of the oval along the Y-axis.
   *
   * @return the radius along the Y-axis
   */
  public double getRadiusY() {
    return radiusY;
  }

  /**
   * Sets the radius of the oval along the Y-axis.
   *
   * @param radiusY the new radius along the Y-axis
   */
  public void setRadiusY(double radiusY) {
    this.radiusY = radiusY;
  }

  /**
   * Returns a string representation of the oval, including its name, type, center coordinates,
   * radii, and color.
   *
   * @return a string representation of the oval
   */
  @Override
  public String toString() {
    return "Name: " + getName()
        + "\nType: oval"
        + "\nCenter: (" + getX() + "," + getY() + "), X radius: " + radiusX
        + ", Y radius: " + radiusY + ", Color: (" + this.color.getRed() + ","
        + this.color.getGreen() + "," + this.color.getBlue() + ")" + "\n";
  }

  /**
   * Creates and returns a copy of the shape.
   *
   * @return a new Shape object that is an exact copy of the current shape
   */
  public Shape copy() {
    return new Oval(this.name, this.X, this.Y, this.radiusX, this.radiusY, this.getColor());
  }
}
