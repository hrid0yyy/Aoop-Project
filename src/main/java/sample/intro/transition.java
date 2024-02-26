package sample.intro;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class transition {


    public static void fadeInTransition(Parent root) {
        FadeTransition fade = new FadeTransition(Duration.millis(1000),root);
        fade.setFromValue(0.7);
        fade.setToValue(1.0);
        fade.play();
    }
    public static void showMessage(ImageView image2, int from, int to, ImageView image, Text text, String string)
    {
        image.setOpacity(1);
        image2.setOpacity(1);
        text.setOpacity(1);

        text.setText("");

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(image2);
        transition.setDuration(Duration.millis(1000));
        transition.setFromX(from);
        transition.setByX(-to);
        transition.play();

        FadeTransition fade = new FadeTransition(Duration.millis(1000),image);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.play();
        fade.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText(string+"\n\n\n"+"[Press X ]");


            }
        });
    }
  public static void switchPage(Parent root,Scene scene,Stage stage,Parent rootPane)
  {
//      root = null;
//      try {
//          root= FXMLLoader.load(getClass().getResource(fxmlfile));
//      } catch (IOException e) {
//
//          throw new RuntimeException(e);
//      }

      scene = new Scene(root);
      stage = new Stage();
      stage.setScene(scene);
      stage.initStyle(StageStyle.UNDECORATED);

      rootPane.getScene().getWindow().hide();
      stage.show();
  }

    public static void showMessage1(ImageView girl, ImageView scroll, Text text, String message) {
        text.setText("");

        TranslateTransition scrollTransition = new TranslateTransition(Duration.seconds(1), scroll);
        scrollTransition.setToX(0);
        scrollTransition.play();

        FadeTransition scrollFadeIn = new FadeTransition(Duration.seconds(1), scroll);
        scrollFadeIn.setFromValue(0.0);
        scrollFadeIn.setToValue(1.0);

        FadeTransition textFadeIn = new FadeTransition(Duration.seconds(1), text);
        textFadeIn.setFromValue(0.0);
        textFadeIn.setToValue(1.0);

        scrollFadeIn.setOnFinished(event -> textFadeIn.play());

        scrollFadeIn.play();

        textFadeIn.setOnFinished(event -> text.setText(message + "\n\n\n[Press X]"));
        girl.setLayoutX(100);
    }

    public static void fadeOutTransition(Parent root) {
        FadeTransition fade = new FadeTransition(Duration.millis(1000),root);
        fade.setFromValue(1.0);
        fade.setToValue(0.7);
        fade.play();
    }
    public static void fadeInFadeOut(Node icon)
    {
        FadeTransition fade = new FadeTransition(Duration.millis(1000),icon);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();
    }
    public static void helper_luffy(TextField textField,Text text)
    {
        String qus = textField.getText();


        text.setText(qus+"\n\nPress X to hide Luffy");

    }
    public static void helper_luffy_apperance(ImageView luffy, ImageView luffybox, Text text, TextField textField,double value)
    {
        luffy.setOpacity(value);
        luffybox.setOpacity(value);
        text.setOpacity(value);
        textField.setOpacity(value);
    }

    public  static void backNforward(Node icon, int from, int to)
    {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(icon);
        transition.setDuration(Duration.millis(6000));
        transition.setFromX(-from);
        transition.setByX(to);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.play();
    }

    public static void swim(Node icon,int from,int to)
    {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(icon);
        transition.setDuration(Duration.millis(1000));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setFromX(-from);
        transition.setByX(to);
        transition.setAutoReverse(true);
        transition.play();
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(icon);
        rotate.setDuration(Duration.millis(500));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setFromAngle(10);
        rotate.setByAngle(-10);
        rotate.setAutoReverse(true);
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.play();
    }

    public static void handleShipClick(double scaleX,double scaleY, AnchorPane root, String fxmlFilePath) {

        ScaleTransition scaleIn = new ScaleTransition(Duration.seconds(1), root);
        scaleIn.setToX(scaleX);
        scaleIn.setToY(scaleY);

        scaleIn.setOnFinished(actionEvent -> {
            try {
                FXMLLoader loader = new FXMLLoader(transition.class.getResource(fxmlFilePath));
                Parent newRoot = loader.load();
                Stage stage = (Stage) root.getScene().getWindow();
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        scaleIn.play();
    }

    public static void addHoverAnimation(ImageView imageView) {
        imageView.setOnMouseEntered(event -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.2), imageView);
            scaleTransition.setToX(1.3);
            scaleTransition.setToY(1.3);
            scaleTransition.play();
        });

        imageView.setOnMouseExited(event -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.2), imageView);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
    }

}
