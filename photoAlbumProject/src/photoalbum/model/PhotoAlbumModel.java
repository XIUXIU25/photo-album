package photoalbum.model;


import java.util.ArrayList;
import java.util.List;

/**
 * The PhotoAlbumModel class represents a photo album that manages shapes and snapshots.
 * It allows adding and removing shapes, creating snapshots, and retrieving information about the
 * album's contents.
 */
public class PhotoAlbumModel {
  private final List<Shape> shapes;
  private final List<Snapshot> snapshots;

  /**
   * Constructs a PhotoAlbumModel with empty shape and snapshot lists.
   */
  public PhotoAlbumModel() {
    this.shapes = new ArrayList<>();
    this.snapshots = new ArrayList<>();
  }

  /**
   * Adds a new shape to the photo album.
   *
   * @param shape the shape to add
   * @throws IllegalArgumentException if the shape already exists in the album
   */
  public void addShape(Shape shape) {
    if (shapes.contains(shape)) {
      throw new IllegalArgumentException("Shape already exists, please add another one");
    }
    shapes.add(shape.copy());
  }

  /**
   * Moves a shape to a new position by updating its x and y coordinates.
   *
   * @param name the name of the shape to move
   * @param x    the new x-coordinate for the shape
   * @param y    the new y-coordinate for the shape
   */
  public void move(String name, double x, double y) {
    for (Shape shape : this.shapes) {
      if (shape.getName().equals(name)) {
        shape.setX(x);
        shape.setY(y);
        break;
      }
    }
  }

  /**
   * Resizes a shape by updating its width and height.
   *
   * @param name the name of the shape to resize
   * @param x    the new width of the shape
   * @param y    the new height of the shape
   */
  public void resize(String name, double x, double y) {
    for (Shape shape : this.shapes) {
      if (shape.getName().equals(name)) {
        shape.setWidth(x);
        shape.setHeight(y);
        break;
      }
    }
  }

  /**
   * Changes the color of a shape by updating its RGB values.
   *
   * @param name  the name of the shape to change color
   * @param color the new color for the shape
   */
  public void changeColor(String name, Color color) {
    for (Shape shape : this.shapes) {
      if (shape.getName().equals(name)) {
        shape.changeColor(color.getRed(), color.getGreen(), color.getBlue());
        break;
      }
    }
  }

  /**
   * Removes a shape from the album based on its name.
   *
   * @param name the name of the shape to remove
   */
  public void remove(String name) {
    shapes.removeIf(shape -> shape.getName().equals(name));
  }

  /**
   * Creates a new snapshot of the current shapes in the album.
   *
   * @param description a description of the snapshot
   */
  public void AddSnapshot(String description) {
    List<Shape> s = new ArrayList<>();
    for (Shape shape : shapes) {
      s.add(shape.copy());
    }
    snapshots.add(new Snapshot(description, s));
  }

  /**
   * Retrieves the list of snapshots in the album.
   *
   * @return the list of snapshots
   */
  public List<Snapshot> getSnapshots() {
    List<Snapshot> s = new ArrayList<>();
    for (int i = 0; i < this.snapshots.size(); i++) {
      s.add(new Snapshot(this.snapshots.get(i).getDescription(),
          this.snapshots.get(i).getShapes()));
    }
    return s;
  }

  /**
   * Returns a list of copies of all shapes currently managed by the model.
   * This method ensures that the original shapes remain unmodified by providing
   * copies of the shapes, maintaining data integrity and encapsulation.
   *
   * @return a list of copied Shape objects
   */
  public List<Shape> getShapes() {
    List<Shape> sps = new ArrayList<>();
    for (Shape shape : this.shapes) {
      sps.add(shape.copy());
    }
    return sps;
  }

  /**
   * Retrieves a string representation of all shapes currently in the album.
   *
   * @return a string representation of all shapes
   */
  public String getShapesString() {
    String result = "";
    for (Shape shape : shapes) {
      result += shape + "\n";
    }
    return result;
  }
}
