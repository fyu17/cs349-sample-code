import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Alerts");
        primaryStage.setOnCloseRequest(event -> {
            boolean answer = ConfirmBox.Display("Confirm", "Are you sure you want to exit?");
            if (!answer) {
                event.consume();    // window close event stops here
            }
        });


        ScrollPane scrollpane = new ScrollPane();
        Scene scene = new Scene(scrollpane, 300, 400);
        Text text = new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        text.wrappingWidthProperty().bind(scene.widthProperty());
        scrollpane.setContent(text);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
