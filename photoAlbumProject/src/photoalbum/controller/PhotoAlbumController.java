package photoalbum.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import photoalbum.model.*;
import photoalbum.view.*;

/**
 * The PhotoAlbumController class manages the interaction between the model and the view.
 * It processes input arguments, reads input files, and handles rendering of snapshots
 * through the specified view type (graphical or web).
 */
public class PhotoAlbumController {
  private final PhotoAlbumModel model;
  private IPhotoAlbumView view;
  private String inputFile;
  private String outputFile;
  private String version;
  private int sizeX = 1000;
  private int sizeY = 1000;

  /**
   * Constructs a PhotoAlbumController with an empty PhotoAlbumModel.
   */
  public PhotoAlbumController() {
    this.model = new PhotoAlbumModel();
  }

  /**
   * Reads and processes the command-line arguments to initialize input/output files,
   * view type, and canvas size.
   *
   * @param args the command-line arguments provided to the program
   * @throws IllegalArgumentException if required arguments are missing or invalid
   */
  public void read(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-in")) {
        inputFile = args[++i];
      } else if (args[i].equalsIgnoreCase("-out")) {
        outputFile = args[++i];
      } else if (args[i].equalsIgnoreCase("-v") || args[i].equalsIgnoreCase("-view")) {
        version = args[i + 1];
      }
    }
    try {
      this.sizeX = Integer.parseInt(args[args.length - 2]);
    } catch (Exception e) {

    }
    try {
      this.sizeY = Integer.parseInt(args[args.length - 1]);
    } catch (Exception e) {

    }

    if (inputFile.isEmpty() || version.isEmpty() || (version == "web" && outputFile.isEmpty())) {
      throw new IllegalArgumentException("Something went wrong with your args");
    }
    if (version.equalsIgnoreCase("web")) {
      if (this.outputFile == null) {
        throw new IllegalArgumentException("No output name is found");
      }
      this.view = new WebView();
    } else if (version.equalsIgnoreCase("graphical")) {
      this.view = new SwingPhotoAlbum();
    } else {
      throw new IllegalArgumentException("version doesn't support.");
    }
  }

  /**
   * Reads the input file to create and modify shapes, take snapshots, and perform
   * other operations as specified by the input commands.
   *
   * @throws FileNotFoundException    if the input file cannot be found
   * @throws IllegalArgumentException if the file contains invalid commands
   */
  public void readInputFile() throws FileNotFoundException {
    File file = new File(inputFile);
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()) {
      String line = sc.nextLine().trim();
      String[] splitted = line.split("\\s+");
      if (splitted[0].equalsIgnoreCase("#") || line.isEmpty()) continue;
      if (splitted[0].equalsIgnoreCase("shape")) {
        Color color = new Color(Double.parseDouble(splitted[7]) / 255,
            Double.parseDouble(splitted[8]) / 255, Double.parseDouble(splitted[9]) / 255);
        Double X = Double.parseDouble(splitted[3]);
        Double Y = Double.parseDouble(splitted[4]);
        Double XX = Double.parseDouble(splitted[5]);
        Double YY = Double.parseDouble(splitted[6]);
        if (splitted[2].equalsIgnoreCase("rectangle")) {
          this.model.addShape(new Rectangle(splitted[1], X, Y, XX, YY, color));
        } else if (splitted[2].equalsIgnoreCase("oval")) {
          this.model.addShape(new Oval(splitted[1], X, Y, XX, YY, color));
        }
      } else if (splitted[0].equalsIgnoreCase("snapshot")) {
        if (line.length() == 8) this.model.AddSnapshot("");
        else this.model.AddSnapshot(line.substring(9));
      } else if (splitted[0].equalsIgnoreCase("move")) {
        int x = Integer.parseInt(splitted[2]);
        int y = Integer.parseInt(splitted[3]);
        this.model.move(splitted[1], x, y);
      } else if (splitted[0].equalsIgnoreCase("color")) {
        Color color = new Color(Double.parseDouble(splitted[2]) / 255,
            Double.parseDouble(splitted[3]) / 255, Double.parseDouble(splitted[4]) / 255);
        this.model.changeColor(splitted[1], color);
      } else if (splitted[0].equalsIgnoreCase("resize")) {
        int x = Integer.parseInt(splitted[2]);
        int y = Integer.parseInt(splitted[3]);
        this.model.resize(splitted[1], x, y);
      } else if (splitted[0].equalsIgnoreCase("remove")) {
        this.model.remove(splitted[1]);
      } else {
        sc.close();
        throw new IllegalArgumentException("Error reading input file");
      }

    }
    sc.close();
  }

  /**
   * Renders the snapshots using the specified view type (graphical or web).
   *
   * @throws IOException if an error occurs during rendering
   */
  public void render() throws IOException {
    this.view.render(this.model.getSnapshots(), this.sizeX, this.sizeY, this.outputFile);
  }

}
