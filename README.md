Photo Album Project
Overview
    The Photo Album Project is a Java-based application that allows users to manage a collection of shapes (rectangles and ovals),  manipulate their properties (position, size, and color), and take snapshots to preserve their states at any given time. These snapshots can be visualized in either a graphical user interface or a web-based interface.

Features
    Shape Management:
        Add, remove, move, resize, and change the color of shapes.
        Supports rectangles and ovals, with potential for adding more shapes in the future.
    Snapshot Functionality:
        Capture the current state of all shapes with an optional description.
        View snapshots chronologically or select a specific snapshot.
    Rendering Options:
        Graphical View: Interactive viewer using Java Swing.
        Web View: Generates an HTML file with SVG visualizations for snapshots.

Key Components
1.Model
    Color:
        Represents RGB colors.
        Provides methods to retrieve the red, green, and blue components.
    
    IShape Interface:
        Defines operations for managing shape properties like name, position, size, and color.
        Shape (Abstract Class):
            Updates in This Assignment compared previous one: 
                Introduced the copy() abstract method.
                Allows creating independent copies of shapes, ensuring snapshot data integrity.
            Implements IShape and provides common properties and methods for all shapes.
            Subclasses:
                Rectangle: Defines properties and behavior for rectangles.
                Oval: Extends Shape to include radii for ovals.
    Snapshot:
        Captures the current state of all shapes, including a description and timestamp.
        PhotoAlbumModel:
            Core logic for managing shapes and snapshots.
            Includes methods for adding, removing, resizing, moving shapes, and taking snapshots.
            Updates in This Assignment compared previous one:
                Moving Shapes: Added move(String name, double x, double y) to update the position of a shape.
                Resizing Shapes: Added resize(String name, double width, double height) to change the dimensions of a shape.
                Changing color for shapes:Changes the color of a shape by updating its RGB values.

2.Controller
    PhotoAlbumController:
        Parses input files and commands.
        Manages interactions between the model and views.
        Supports two rendering modes: graphical and web.

3.View
    -1.SwingPhotoAlbum:
        Provides a graphical user interface (GUI) using Java Swing.
        Allows users to navigate snapshots interactively.
    -2.WebView:
    Generates an HTML file with SVG-based visualizations for snapshots.
    Input File Format
    
    The input file provides commands for creating and manipulating shapes and snapshots. Supported commands include:
        shape: Creates a new shape. Example:
            shape shapeName rectangle x y width height r g b
            move: Moves a shape to a new position. Example:
                move shapeName newX newY
            resize: Resizes a shape. 
                resize shapeName newWidth newHeight
            color: Changes the color of a shape. Example:
                color shapeName r g b
            snapshot: Captures the current state of all shapes with an optional description. Example:
            remove: Removes a shape. Example:
                remove shapeName

Usage
Command-Line Arguments
    -in <inputFile>: Specifies the input file with commands.
    -out <outputFile>: Specifies the output file for the web view (required for web mode).
    -view <viewType>: Specifies the view type. Supported values:
        graphical: Opens a Swing-based graphical interface.
        web: Generates an HTML file for viewing snapshots.
