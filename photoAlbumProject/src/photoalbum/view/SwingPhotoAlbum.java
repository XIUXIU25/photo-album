package photoalbum.view;

import java.util.List;

import photoalbum.model.Oval;
import photoalbum.model.Rectangle;
import photoalbum.model.Snapshot;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The SwingPhotoAlbum class implements the IPhotoAlbumView interface and provides
 * a graphical user interface (GUI) for displaying snapshots of shapes in the photo album.
 * It uses Java Swing components to render shapes and allow user interaction.
 */
public class SwingPhotoAlbum implements IPhotoAlbumView {
  int currentIdx = 0;
  List<Snapshot> snapshots;
  JFrame frame = new JFrame("CS5004 Shapes Photo Album Viewer");
  JLabel snapshotLbl = new JLabel();
  BufferedImage snapshotImg;
  JPanel snapshotPanel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (snapshotImg != null) {
        g.drawImage(snapshotImg, 0, 0, null);
      }
    }
  };

  /**
   * Constructs a SwingPhotoAlbum instance and sets up the GUI components.
   */
  public SwingPhotoAlbum() {
    this.frame.setLayout(new BorderLayout());
    JPanel buttonPanel = new JPanel();

    JButton prevButton = new JButton("<< Prev <<");
    JButton nextButton = new JButton(">> Next >>");
    JButton selectButton = new JButton("^^ Select ^^");
    JButton quitButton = new JButton("xx Quit xx");

    prevButton.addActionListener(e -> handlePrevBtnClicked());
    nextButton.addActionListener(e -> handleNextBtnClicked());
    selectButton.addActionListener(e -> handleSelectBtnClicked());
    quitButton.addActionListener(e -> handleQuitBtnClicked());

    buttonPanel.setBackground(java.awt.Color.ORANGE);
    buttonPanel.add(prevButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(selectButton);
    buttonPanel.add(quitButton);

    this.frame.add(snapshotLbl, BorderLayout.NORTH);
    this.frame.add(snapshotPanel, BorderLayout.CENTER);
    this.frame.add(buttonPanel, BorderLayout.SOUTH);

    this.frame.setSize(800, 600);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * Handles the "Previous" button click event.
   * Displays the previous snapshot if available.
   */
  private void handlePrevBtnClicked() {
    if (currentIdx == 0) {
      JOptionPane.showMessageDialog(this.frame, "First snapshot. No snapshots to "
          + "show before this one.");
    } else {
      renderSnapshot(this.snapshots.get(--currentIdx));
    }
  }

  /**
   * Handles the "Next" button click event.
   * Displays the next snapshot if available.
   */
  private void handleNextBtnClicked() {
    if (currentIdx == this.snapshots.size() - 1) {
      JOptionPane.showMessageDialog(this.frame, "End of the photo album. "
          + "No snapshots to show beyond this one.");
    } else {
      renderSnapshot(this.snapshots.get(++currentIdx));
    }
  }

  /**
   * Handles the "Quit" button click event.
   * Closes the application window and exits the program.
   */
  private void handleQuitBtnClicked() {
    this.frame.setVisible(false);
    this.frame.dispose();
    System.exit(0);
  }

  /**
   * Handles the "Select" button click event.
   * Displays a dialog allowing the user to select a specific snapshot.
   */
  private void handleSelectBtnClicked() {
    JDialog dialog = new JDialog(frame, "Select Snapshot", true);
    dialog.setLayout(new BorderLayout());

    DefaultListModel<String> listModel = new DefaultListModel<>();
    for (Snapshot snapshot : snapshots) {
      listModel.addElement(snapshot.getSnapshotId() + ": " + snapshot.getDescription());
    }
    JList<String> snapshotList = new JList<>(listModel);
    snapshotList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    JScrollPane scrollPane = new JScrollPane(snapshotList);
    dialog.add(scrollPane, BorderLayout.CENTER);

    JButton selectBtn = new JButton("Select");
    selectBtn.addActionListener(e -> {
      int selectedIndex = snapshotList.getSelectedIndex();
      if (selectedIndex != -1) {
        currentIdx = selectedIndex;
        renderSnapshot(snapshots.get(currentIdx));
        dialog.dispose();
      }
    });
    dialog.add(selectBtn, BorderLayout.SOUTH);

    dialog.setSize(300, 400);
    dialog.setLocationRelativeTo(frame);
    dialog.setVisible(true);
  }

  /**
   * Renders the list of snapshots and displays the first snapshot.
   *
   * @param snapshots      the list of snapshots to render
   * @param sizeX          the width of the rendering area
   * @param sizeY          the height of the rendering area
   * @param outputFileName not used in Swing rendering
   */
  public void render(List<Snapshot> snapshots, int sizeX, int sizeY, String outputFileName) {
    this.snapshots = snapshots;
    this.snapshotImg = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);

    if (!this.snapshots.isEmpty()) {
      renderSnapshot(this.snapshots.get(0));
    }

    this.frame.setVisible(true);
  }

  /**
   * Renders a single snapshot by drawing all shapes onto the BufferedImage.
   *
   * @param snapshot the snapshot to render
   */
  @Override
  public void renderSnapshot(Snapshot snapshot) {
    Graphics2D g2d = snapshotImg.createGraphics();
    g2d.setColor(Color.WHITE);
    g2d.fillRect(0, 0, snapshotImg.getWidth(), snapshotImg.getHeight());

    for (photoalbum.model.Shape shape : snapshot.getShapes()) {
      if (shape instanceof Rectangle) {
        renderRectangle((Rectangle) shape);
      } else if (shape instanceof Oval) {
        renderOval((Oval) shape);
      }
    }

    snapshotLbl.setText("<html><b>ID:</b> " + snapshot.getSnapshotId() + "<br><b>Description:</b>"
        + " " + snapshot.getDescription() + "</html>");
    snapshotPanel.repaint();
    g2d.dispose();
  }

  /**
   * Renders a rectangle shape onto the BufferedImage.
   *
   * @param rec the rectangle to render
   */
  @Override
  public void renderRectangle(Rectangle rec) {
    Graphics2D g2d = snapshotImg.createGraphics();
    g2d.setColor(new java.awt.Color((int) (rec.getColor().getRed() * 255),
        (int) (rec.getColor().getGreen() * 255),
        (int) (rec.getColor().getBlue() * 255)));
    g2d.fillRect((int) rec.getX(), (int) rec.getY(), (int) rec.getWidth(), (int) rec.getHeight());
    g2d.dispose();
  }

  /**
   * Renders an oval shape onto the BufferedImage.
   *
   * @param oval the oval to render
   */
  @Override
  public void renderOval(Oval oval) {
    Graphics2D g2d = snapshotImg.createGraphics();
    g2d.setColor(new java.awt.Color((int) (oval.getColor().getRed() * 255),
        (int) (oval.getColor().getGreen() * 255),
        (int) (oval.getColor().getBlue() * 255)));
    g2d.fillOval((int) (oval.getX() - oval.getRadiusX()),
        (int) (oval.getY() - oval.getRadiusY()),
        (int) (oval.getRadiusX() * 2),
        (int) (oval.getRadiusY() * 2));
    g2d.dispose();
  }
}

