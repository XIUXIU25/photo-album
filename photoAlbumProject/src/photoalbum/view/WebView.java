package photoalbum.view;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import photoalbum.model.Oval;
import photoalbum.model.Rectangle;
import photoalbum.model.Shape;
import photoalbum.model.Snapshot;

/**
 * The WebView class implements the IPhotoAlbumView interface and provides functionality
 * to render snapshots of shapes in an HTML file using SVG (Scalable Vector Graphics).
 */
public class WebView implements IPhotoAlbumView {
  private final StringBuilder strBuilder = new StringBuilder("<!DOCTYPE html><html><head><title" +
      ">Shapes " +
      "Photo Album</title></head><body>");
  private int sizeX;
  private int sizeY;

  /**
   * Renders a list of snapshots into an HTML file with an SVG canvas for each snapshot.
   *
   * @param snapshots      the list of snapshots to render
   * @param sizeX          the width of the SVG canvas
   * @param sizeY          the height of the SVG canvas
   * @param outputFileName the name of the output HTML file
   * @throws IOException if an error occurs while writing the HTML file
   */
  public void render(List<Snapshot> snapshots, int sizeX, int sizeY, String outputFileName)
      throws IOException {
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    for (Snapshot snapshot : snapshots) {
      renderSnapshot(snapshot);
    }
    strBuilder.append("</body></html>");
    File file = new File(outputFileName);
    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new FileWriter(file));
      writer.append(this.strBuilder);
    } catch (Exception e) {
      throw new IOException("Cannot write to:" + outputFileName);
    } finally {
      if (writer != null) writer.close();
    }

  }

  /**
   * Renders a single snapshot as an SVG canvas within an HTML file.
   *
   * @param snapshot the snapshot to render
   */
  public void renderSnapshot(Snapshot snapshot) {
    String line = "<div><h1>%s</h1><p>Description: %s</p><svg width=\"%d\" height=\"%d\">";
    line = String.format(line, snapshot.getSnapshotId(), snapshot.getDescription(), this.sizeX,
        this.sizeY);
    strBuilder.append(line);
    for (Shape shape : snapshot.getShapes()) {
      if (shape instanceof Rectangle) {
        renderRectangle((Rectangle) (shape));
      } else {
        renderOval((Oval) shape);
      }
    }
    strBuilder.append("</svg></div><hr/>");
  }

  /**
   * Renders a rectangle as an SVG <rect> element.
   *
   * @param rec the rectangle to render
   */
  public void renderRectangle(Rectangle rec) {
    String line = "<rect x=\"%f\" y=\"%f\" width=\"%f\" height=\"%f\" fill=\"rgb(%d,%d,%d)\" />";
    line = String.format(line, rec.getX(), rec.getY(), rec.getWidth(), rec.getHeight(),
        (int) (rec.getColor().getRed() * 255), (int) (rec.getColor().getGreen() * 255),
        (int) (rec.getColor().getBlue() * 255));
    strBuilder.append(line);
  }

  /**
   * Renders an oval as an SVG <ellipse> element.
   *
   * @param oval the oval to render
   */
  public void renderOval(Oval oval) {
    String line = "<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" fill=\"rgb(%d,%d,%d)\" />";
    line = String.format(line, oval.getX(), oval.getY(), oval.getWidth(), oval.getHeight(),
        (int) (oval.getColor().getRed() * 255), (int) (oval.getColor().getGreen() * 255),
        (int) (oval.getColor().getBlue() * 255));
    strBuilder.append(line);
  }
}

