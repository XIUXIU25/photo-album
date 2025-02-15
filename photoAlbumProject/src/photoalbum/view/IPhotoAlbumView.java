package photoalbum.view;

import java.io.IOException;
import java.util.List;

import photoalbum.model.Rectangle;
import photoalbum.model.Snapshot;
import photoalbum.model.Oval;

/**
 * The IPhotoAlbumView interface defines the methods for rendering snapshots
 * and shapes in a photo album. It is implemented by concrete view classes
 * to provide different rendering options, such as graphical or web-based views.
 */
public interface IPhotoAlbumView {
  /**
   * Renders a list of snapshots in the view.
   *
   * @param snapshots the list of snapshots to render
   * @param sizeX     the width of the canvas or viewing area
   * @param sizeY     the height of the canvas or viewing area
   * @throws IOException if an error occurs during rendering
   */
  void render(List<Snapshot> snapshots, int sizeX, int sizeY, String outputFIleNames)
      throws IOException;

  /**
   * Renders a single snapshot in the view.
   *
   * @param snapshot the snapshot to render
   */
  void renderSnapshot(Snapshot snapshot);

  /**
   * Renders a rectangle shape in the view.
   *
   * @param rec the rectangle to render
   */
  void renderRectangle(Rectangle rec);

  /**
   * Renders an oval shape in the view.
   *
   * @param oval the oval to render
   */
  void renderOval(Oval oval);
} 

