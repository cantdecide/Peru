package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

  Color         tarheelBlue = new Color(0.482, 0.686, 0.831, 1);
  private Stage _stage;

  @Override
  public void start(Stage primaryStage) {
    _stage = primaryStage;
    try {
      BorderPane root = new BorderPane();
      Scene scene = new Scene(root, 400, 400);
      scene.getStylesheets()
          .add(getClass().getResource("application.css").toExternalForm());
      _stage.setScene(scene);
      scene.setFill(tarheelBlue);
      // How do we set the title here?
      _stage.setTitle("Learn Quechua!");
      _stage.show();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    launch(args);
  }

  private Scene inItScene() {

    VBox container = new VBox();
    Label appLabel = new Label("Learn Quechua");
    Button begin = new Button("start");

    begin.setOnAction(this::handleStartButtonClicked);
    container.getChildren().addAll(appLabel, begin);

    return new Scene(container);

  }
}
