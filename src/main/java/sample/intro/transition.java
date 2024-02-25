package sample.intro;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class transition {
    public static void fadeInTransition(Parent root) {
        FadeTransition fade = new FadeTransition(Duration.millis(1000),root);
        fade.setFromValue(0.7);
        fade.setToValue(1.0);
        fade.play();
    }
    public static void fadeOutTransition(Parent root) {
        FadeTransition fade = new FadeTransition(Duration.millis(1000),root);
        fade.setFromValue(1.0);
        fade.setToValue(0.7);
        fade.play();
    }

    public static void swim(Node icon)
    {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(icon);
        transition.setDuration(Duration.millis(1000));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setFromX(-10);
        transition.setByX(10);
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
