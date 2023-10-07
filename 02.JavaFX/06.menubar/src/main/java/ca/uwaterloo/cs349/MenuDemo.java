package ca.uwaterloo.cs349;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuDemo extends Application {
    @Override
    public void start(Stage stage) {
        // Create menu items
        MenuBar menubar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem fileNew = new MenuItem("New");
        MenuItem fileOpen = new MenuItem("Open");
        MenuItem fileQuit = new MenuItem("Quit");
        fileMenu.getItems().addAll(fileNew, fileOpen, fileQuit);

        Menu editMenu = new Menu("Edit");
        MenuItem editCut = new MenuItem("Cut");
        MenuItem editCopy = new MenuItem("Copy");
        MenuItem editPaste = new MenuItem("Paste");
        editMenu.getItems().addAll(editCut, editCopy, editPaste);

        // Map accelerator keys to menu items
        fileNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        fileOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        fileQuit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        editCut.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        editCopy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        editPaste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));

        // Put menus together
        menubar.getMenus().addAll(fileMenu, editMenu);

        // Setup handlers
        fileNew.setOnAction(actionEvent -> { System.out.println("File-New"); });
        fileOpen.setOnAction(actionEvent -> { System.out.println("File-Open"); });
        fileQuit.setOnAction(actionEvent -> {
            System.out.println("File-Quit");
            System.exit(0);
        });

        editCut.setOnAction(actionEvent -> { System.out.println("Edit-Cut"); });
        editCopy.setOnAction(actionEvent -> { System.out.println("Edit-Copy"); });
        editPaste.setOnAction(actionEvent -> { System.out.println("Edit-Paste"); });

        Label instructions = new Label("This app demonstrates how to setup menus. ");
        VBox root = new VBox(menubar, instructions);
        // root.setPadding(new Insets(10));
        root.setSpacing(10);

        final String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Mac")) {
            menubar.useSystemMenuBarProperty().set(true);
        }

        // Create a root node and add to the scene
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("MenuBar Demo");
        stage.show();
    }
}