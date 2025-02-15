package photoalbum;

import java.io.FileNotFoundException;
import java.io.IOException;

import photoalbum.controller.PhotoAlbumController;


/**
 * The Main class serves as the entry point for the Photo Album application.
 * It initializes the controller, processes the input arguments, and handles
 * the rendering of snapshots based on the specified view type.
 */
public class Main {

  /**
   * The main method that starts the Photo Album application.
   *
   * @param args command-line arguments provided to the program
   * @throws FileNotFoundException if the input file is not found
   * @throws IOException           if there is an error during rendering
   */
  public static void main(String[] args) throws FileNotFoundException, IOException {
    PhotoAlbumController photoAlbum = new PhotoAlbumController();
    photoAlbum.read(args); 
    photoAlbum.readInputFile(); 
    photoAlbum.render();
  }

}
