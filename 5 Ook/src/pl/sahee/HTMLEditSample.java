package pl.sahee;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 * Created by Michal on 2017-06-01.
 */
public class HTMLEditSample extends Application {

    private final String startupText = "<html><body onLoad='document.body.focus();'>\n" +
            "Ook. Ook. Ook! Ook? Ook. Ook? Ook. Ook! Ook? Ook!\n" +
            "Ook? Ook. Ook! Ook! Ook! Ook? Ook. Ook. Ook! Ook.\n" +
            "Ook? Ook. Ook! Ook! Ook? Ook! "
            + "sem.</body></html>";
	@Override
    public void start(Stage stage){
        stage.setTitle("HTMLEdit Sample");
        stage.setWidth(500);
        stage.setHeight(400);
        final HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);
        htmlEditor.setHtmlText(startupText);
        Scene sc = new Scene(htmlEditor);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

