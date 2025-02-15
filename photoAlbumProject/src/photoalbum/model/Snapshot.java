package photoalbum.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The Snapshot class represents a record of the current state of shapes in the photo album.
 * It includes a unique snapshot ID, a timestamp, a description, and a list of shapes
 * captured at the moment the snapshot is created.
 */
public class Snapshot {
  private final String snapshotId;
  private final LocalDateTime timestamp;
  private final String description;
  private final List<Shape> shapes;

  /**
   * Constructs a Snapshot with a given description and a list of shapes.
   * The snapshot ID and timestamp are automatically generated based on the current time.
   *
   * @param description a brief description of the snapshot
   * @param shapes      the list of shapes captured in this snapshot
   */
  public Snapshot(String description, List<Shape> shapes) {
    this.snapshotId = LocalDateTime.now().toString();
    this.timestamp = LocalDateTime.now();
    this.description = description;
    this.shapes = List.copyOf(shapes);
  }

  /**
   * Gets the unique ID of the snapshot.
   *
   * @return the snapshot ID
   */
  public String getSnapshotId() {
    return this.snapshotId;
  }

  /**
   * Gets the timestamp when the snapshot was created.
   *
   * @return the timestamp of the snapshot
   */
  public LocalDateTime getTimestamp() {
    return this.timestamp;
  }

  /**
   * Gets the list of shapes in the snapshot.
   *
   * @return an immutable list of shapes
   */
  public List<Shape> getShapes() {
    List<Shape> returnShapes = new ArrayList<>();
    for (Shape shape : this.shapes) {
      returnShapes.add(shape.copy());
    }
    return returnShapes;
  }

  /**
   * Gets the description of the snapshot.
   *
   * @return the description of the snapshot
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Returns a string representation of the snapshot, including its ID, timestamp,
   * description, and details of each shape in the snapshot.
   *
   * @return a string describing the snapshot
   */
  @Override
  public String toString() {
    String output = "Snapshot ID: " + snapshotId
        + "\nTimestamp: " + timestamp
        + "\nDescription: " + description
        + "\nShape Information:";
    for (Shape shape : shapes) {
      output += "\n" + shape.toString();
    }
    return output;
  }
}
