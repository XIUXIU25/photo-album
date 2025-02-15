package photoalbum.model;

import java.util.Objects;

/**
 * The Color class represents a color using RGB values.
 * Each color is defined by its red, green, and blue components,
 * where each component is a double value between 0.0 and 1.0.
 */
public class Color {
  private final double red;
  private final double green;
  private final double blue;

  /**
   * Constructs a Color object with the specified red, green, and blue values.
   *
   * @param red   the red component of the color (0.0 to 1.0)
   * @param green the green component of the color (0.0 to 1.0)
   * @param blue  the blue component of the color (0.0 to 1.0)
   */
  public Color(double red, double green, double blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }


  /**
   * Returns the red component of the color.
   *
   * @return the red component (0.0 to 1.0)
   */
  public double getRed() {
    return this.red;
  }

  /**
   * Returns the green component of the color.
   *
   * @return the green component (0.0 to 1.0)
   */
  public double getGreen() {
    return this.green;
  }

  /**
   * Returns the blue component of the color.
   *
   * @return the blue component (0.0 to 1.0)
   */
  public double getBlue() {
    return this.blue;
  }

  /**
   * Compares this Color object with another object for equality.
   * Two Color objects are considered equal if they have the same red,
   * green, and blue values.
   *
   * @param obj the object to compare with
   * @return true if the colors are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this == obj) {
      return true;
    }
    if (obj.getClass() == this.getClass()) {
      Color other = (Color) obj;
      return this.red == other.getRed() && this.green == other.getGreen()
          && this.blue == other.getBlue();
    }
    return false;
  }

  /**
   * Returns a hash code value for this Color object.
   * The hash code is computed based on the red, green, and blue components.
   *
   * @return a hash code value for this Color object
   */
  @Override
  public int hashCode() {
    return Objects.hash(red, green, blue);
  }
}
