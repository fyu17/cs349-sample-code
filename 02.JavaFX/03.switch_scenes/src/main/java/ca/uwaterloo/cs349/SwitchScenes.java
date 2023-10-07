package ca.uwaterloo.cs349;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

// Demonstrates switching between scenes at runtime
// Click on the button to switch scenes, OR press keys 1, 2

public class SwitchScenes extends Application {
    Scene scene1, scene2;
    Button button1, button2;
    enum SCENES {SCENE1, SCENE2};

    @Override
    public void start(Stage stage) {
        stage.setTitle("Switch Scenes");

        // scene one
        button1 = new Button("Go To Scene2");
        StackPane root1 = new StackPane(button1);
        root1.setBackground(new Background(new BackgroundFill(Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));
        scene1 = new Scene(root1, 300, 150);

        // pressing '2' or pressing the button will switch to scene 2
        scene1.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.DIGIT2) {
                setScene(stage, SCENES.SCENE2);
            }
        });
        button1.setOnAction(event -> { setScene(stage, SCENES.SCENE2); });

        // scene two
        button2 = new Button("Go To Scene1");
        StackPane root2 = new StackPane(button2);
        root2.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        scene2 = new Scene(root2, 300, 150);

        // pressing '1' or pressing the button will switch to scene 1
        scene2.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.DIGIT1) {
                setScene(stage, SCENES.SCENE1);
            }
        });
        button2.setOnAction(event -> { setScene(stage, SCENES.SCENE1); });

        // show starting scene
        setScene(stage, SCENES.SCENE1);
        stage.show();
    }

    void setScene(Stage stage, SCENES scene) {
        switch(scene) {
            case SCENE1:
                stage.setTitle("Scene 1");
                stage.setScene(scene1);
                break;
            case SCENE2:
                stage.setTitle("Scene 2");
                stage.setScene(scene2);
                break;
        }
    }
}
