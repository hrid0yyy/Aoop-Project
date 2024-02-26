package sample.intro;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.ResourceBundle;

public class level1Controller implements Initializable {

//    int count = 0;

    @FXML
    private ImageView tip1, tip2, tip3;

    @FXML
    private ImageView girl;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Text dialougetext = new Text();

    @FXML
    private ImageView scroll;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView luffy;

    @FXML
    private ImageView luffy_box;
    @FXML
    private Text luffy_text;

    @FXML
    private TextField luffy_text_field;

//    private TranslateTransition transitionScroll;
//    private TranslateTransition transitionText;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        girl.setOpacity(0);
        scroll.setOpacity(0);
        transition.helper_luffy_apperance(luffy,luffy_box,luffy_text,luffy_text_field,0);

        transition.addHoverAnimation(tip1);
        transition.addHoverAnimation(tip2);
        transition.addHoverAnimation(tip3);
//        addHoverAnimation(tip1);
//        addHoverAnimation(tip2);
//        addHoverAnimation(tip3);

       dialougetext.setFocusTraversable(true);

        tip1.setOnMouseClicked(event ->{
            transition.showMessage(girl, 400, 400, scroll, dialougetext, "Problem 1\n\n PRESS Y TO ACCEPT");
            dialougetext.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if(keyEvent.getCode() == KeyCode.X)
                    {
                        scroll.setOpacity(0);
                        girl.setOpacity(0);
                        dialougetext.setOpacity(0);

                    }
                    if(keyEvent.getCode() == KeyCode.Y)
                    {
                        try {
                            root = FXMLLoader.load(getClass().getResource("compiler.fxml"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        transition.switchPage(root,scene,stage,rootPane);


                    }
                }
            });

        });
        tip2.setOnMouseClicked(event -> {
            transition.showMessage(girl, 400, 400, scroll, dialougetext, "Problem 2\n\n PRESS Y TO ACCEPT");
            dialougetext.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if(keyEvent.getCode() == KeyCode.X)
                    {
                        scroll.setOpacity(0);
                        girl.setOpacity(0);
                        dialougetext.setOpacity(0);

                    }
                    if(keyEvent.getCode() == KeyCode.Y)
                    {
                        try {
                            root = FXMLLoader.load(getClass().getResource("compiler.fxml"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        transition.switchPage(root,scene,stage,rootPane);


                    }
                }
            });
        });
        tip3.setOnMouseClicked(event -> {
            transition.showMessage(girl, 400, 400, scroll, dialougetext, "Problem 3\n\n PRESS Y TO ACCEPT");
            dialougetext.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if(keyEvent.getCode() == KeyCode.X)
                    {
                        scroll.setOpacity(0);
                        girl.setOpacity(0);
                        dialougetext.setOpacity(0);

                    }
                    if(keyEvent.getCode() == KeyCode.Y)
                    {


                        try {
                            root = FXMLLoader.load(getClass().getResource("compiler.fxml"));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        transition.switchPage(root,scene,stage,rootPane);


                    }
                }
            });

        });


//        dialougetext.setFocusTraversable(true);
//        transition.showMessage(girl,300,300,scroll,dialougetext,"Welcome to Island of Fish Collection Array");
//        dialougetext.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                if(keyEvent.getCode() == KeyCode.X)
//                {
//                    count++;
//                    if(count == 1)
//                    {
//                        transition.showMessage1(girl, scroll, dialougetext, "Here The villagers from different islands want to collect fish and store them efficiently using arrays. Your task is to help the villagers develop a system to collect fish from different islands and perform specific operations using arrays.");
//                    }
//
//                    if(count == 2)
//                    {
//                        transition.showMessage1(girl, scroll,dialougetext,"There are 3 different treasure box present in this island. Find them and know about your challenges");
//                    }
//
//                    if(count == 3)
//                    {
//                        transition.showMessage1(girl, scroll,dialougetext,"Good Luck !!");
//                    }
//
//                    if(count ==4){
//                        moveElementsOutOfScene();
//                    }
//                }
//            }
//        });

    }

    @FXML
    void help_luffy(ActionEvent event) {
        transition.helper_luffy_apperance(luffy,luffy_box,luffy_text,luffy_text_field,1);
        transition.showMessage(luffy,300,300,luffy_box,luffy_text,"Hey wassup");
        luffy_text_field.setFocusTraversable(true);
        luffy_text_field.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.ENTER)
                {
                    transition.helper_luffy(luffy_text_field,luffy_text);
                    luffy_text_field.setOpacity(0);
                    luffy_text_field.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent keyEvent) {
                            if(keyEvent.getCode() == KeyCode.X)
                            {
                                transition.helper_luffy_apperance(luffy,luffy_box,luffy_text,luffy_text_field,0);
                            }
                        }
                    });
                }
            }
        });


    }
//    private void showMessage(String message) {
//        girl.setOpacity(1);
//        scroll.setOpacity(1);


//        transitionScroll = new TranslateTransition(Duration.seconds(1), scroll);
//        transitionScroll.setToX(0);
//        transitionScroll.play();
//
//        dialougetext.setText(message);
//
//        TranslateTransition transitionText = new TranslateTransition(Duration.seconds(1), dialougetext);
//        transitionText.setToX(0);
//        transitionText.play();
//
//        dialougetext.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.X) {
//                moveElementsOutOfScene();
//                dialougetext.setOnKeyPressed(null);
//            }
//        });


//    private void addImageClickEventHandlers() {
//        tip1.setOnMouseClicked(event -> {
//            showMessage("Message for Tip 1");
//            tip1.setImage(new Image("aftertip.png"));
//        });
//
//        tip2.setOnMouseClicked(event -> {
//            showMessage("Message for Tip 2");
//            tip2.setImage(new Image("aftertip.png"));
//        });
//
//        tip3.setOnMouseClicked(event -> {
//            showMessage("Message for Tip 3");
//            tip3.setImage(new Image("aftertip.png"));
//        });
//    }

//    private void addHoverAnimation(ImageView imageView) {
//        imageView.setOnMouseEntered(event -> {
//            ScaleTransition scaleIn = new ScaleTransition(Duration.seconds(0.2), imageView);
//            scaleIn.setToX(1.3);
//            scaleIn.setToY(1.3);
//            scaleIn.play();
//        });
//
//        imageView.setOnMouseExited(event -> {
//            ScaleTransition scaleOut = new ScaleTransition(Duration.seconds(0.2), imageView);
//            scaleOut.setToX(1);
//            scaleOut.setToY(1);
//            scaleOut.play();
//        });
//    }

//    private void moveElementsOutOfScene() {
//
//        TranslateTransition transitionGirlOut = new TranslateTransition(Duration.seconds(1), girl);
//        transitionGirlOut.setToX(-600);
//        transitionGirlOut.play();
//
//        TranslateTransition transitionScrollOut = new TranslateTransition(Duration.seconds(1), scroll);
//        transitionScrollOut.setToX(-600);
//        transitionScrollOut.play();
//
//        TranslateTransition transitionTextOut = new TranslateTransition(Duration.seconds(1), dialougetext);
//        transitionTextOut.setToX(-600);
//        transitionTextOut.play();
//    }


}
