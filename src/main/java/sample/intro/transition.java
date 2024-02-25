package sample.intro;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class transition {
    public static void fadeInTransition(Parent root) {
        FadeTransition fade = new FadeTransition(Duration.millis(1000),root);
        fade.setFromValue(0.7);
        fade.setToValue(1.0);
        fade.play();
    }
    public static void showMessage(ImageView image2,int from,int to,ImageView image,Text text, String string)
    {
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
                text.setText(string+"\n\n\n"+"[Press X]");
            }
        });


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
}
