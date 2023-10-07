import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("Select File");
        Label label = new Label();
        button.setOnMouseClicked(e -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choose a file");
            File file = chooser.showOpenDialog(primaryStage);
            if (file != null) {
                label.setText(label.getText() + "\n" + file.getName() + " selected");
            }
        });

        VBox root = new VBox();
        root.setAlignment(Pos.TOP_LEFT);
        root.setPadding(new Insets(10.0));
        root.setSpacing(10.0);
        root.getChildren().addAll(button, label);

        Scene scene = new Scene(root, 320, 240);
        primaryStage.setTitle("FileChooser Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
