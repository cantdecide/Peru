package applicationOriginal;

import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Runner extends Application {
  /// checking again
  private Stage               _stage;
  private Button              _button;
  private Label               _label;
  private Game                _game;
  private Scene               _scene;

  private Queue<MediaPlayer>  _soundQueue = new LinkedList<MediaPlayer>();

  private final static double PADDING     = 16.0;

  public static void main(String[] args) {
    Application.launch();
  }

  public void start(Stage stage) {
    _stage = stage;
    _stage.setTitle("Learn Quechua!");
    // how do i make the label always show?
    // _scene = this.initScene();

    _stage.show();
    this.newGame();
  }

  // private void handleRestart(ActionEvent event) {
  // this.newGame();
  // }

  private void newGame() {
    _stage.setScene(this.inItScene());

  }

  private Scene inItScene() {

    VBox container = new VBox(Runner.PADDING);
    container.setPadding(new Insets(Runner.PADDING));
    Label appLabel = new Label("Learn Quechua");
    Button begin = new Button("start");

    begin.setOnAction(this::handleStartButtonClicked);
    container.getChildren().addAll(appLabel, begin);

    return new Scene(container);

  }

  private void handleStartButtonClicked(ActionEvent event) {
    _stage.hide();
    Stage firstStage = new Stage();

    VBox container = new VBox(Runner.PADDING);
    container.setPadding(new Insets(Runner.PADDING));

    Label prompt = new Label("How do you say 'Do you need help?' in Quechua?");

    Button answer = new Button("answer");
    answer.setOnAction(this::handleAnswer1);

    container.getChildren().addAll(prompt, answer);
    Scene scene = new Scene(container);
    firstStage.setScene(scene);
    _stage = firstStage;
    _stage.show();
  }

  private void handleAnswer1(ActionEvent event) {
    _stage.hide();
    Stage firstStage = new Stage();
    VBox container = new VBox(Runner.PADDING);
    container.setPadding(new Insets(Runner.PADDING));
    Label prompt = new Label("Munanki anapanayta?");
    container.getChildren().add(prompt);
    Button pronunciation = new Button("How do you pronounce this?");
    pronunciation.setOnAction(this::handleTesting);
    container.getChildren().add(pronunciation);
    Button nextWord = new Button("Next Word");
    container.getChildren().add(nextWord);
    Scene scene = new Scene(container);
    firstStage.setScene(scene);
    _stage = firstStage;
    _stage.show();
  }

  private void handleTesting(ActionEvent e) {
    this.playSound("Testing.m4a");
  }

  private void handleTesting2(ActionEvent e) {
    this.playSound("Testing Number 2");
  }

  private void playSound(String filename) {
    URL resource = this.getClass().getResource("sounds/" + filename);
    Media media = new Media(resource.toString());
    MediaPlayer player = new MediaPlayer(media);
    player.setOnEndOfMedia(this::soundEnded);
    _soundQueue.add(player);
    this.playNextSound();
  }

  private void playNextSound() {
    if (_soundQueue.isEmpty() == false) {
      _soundQueue.peek().play();
    }
  }

  private void soundEnded() {
    _soundQueue.poll();
    this.playNextSound();
  }
}
// How do I make it so they can answer it?
// Do I need to set the order that the words come in?
