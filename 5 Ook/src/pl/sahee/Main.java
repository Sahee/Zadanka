package pl.sahee;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Main extends Application {


            private final String startupText = "<html><body onLoad='document.body.focus();'>\n" +
                    "Ook. Ook. Ook! Ook? Ook. Ook? Ook. Ook! Ook? Ook!\n" +
                    "Ook? Ook. Ook! Ook! Ook! Ook? Ook. Ook. Ook! Ook.\n" +
                    "Ook? Ook. Ook! Ook! Ook? Ook! "
                    + "sem.</body></html>";
            @Override
            public void start(Stage stage) {

                stage.setTitle("Ook! Code Editor");
                stage.setWidth(550);
                stage.setHeight(550);
                Scene scn = new Scene(new Group());

                VBox root = new VBox();
                root.setPadding(new Insets(8, 8, 8, 8));
                root.setSpacing(5);
                root.setAlignment(Pos.BOTTOM_LEFT);

                final HTMLEditor htmlEditor = new HTMLEditor();
                htmlEditor.setPrefHeight(355);

                htmlEditor.setHtmlText(startupText);
                htmlEditor.setHtmlText(startupText);
                htmlEditor.setHtmlText(startupText);
                htmlEditor.setHtmlText(startupText);
                htmlEditor.setHtmlText(startupText);
                htmlEditor.setHtmlText(startupText);
                htmlEditor.setHtmlText(startupText);

                ScrollPane scrllPane = new ScrollPane();
                scrllPane.getStyleClass().add("noborder-scroll-pane");
                scrllPane.setStyle("-fx-background-color: white");
                scrllPane.setFitToWidth(true);
                scrllPane.setPrefHeight(20);

                Button checkButton = new Button("Check Syntax");
                root.setAlignment(Pos.BOTTOM_LEFT);
                checkButton.setStyle("-fx-text-fill: #ff0000");
                checkButton.setOnAction(new EventHandler<ActionEvent>() {
                    String Ook = new String(htmlEditor.getHtmlText());
                    @Override public void handle(ActionEvent arg0) {
                        String Ook = new String(htmlEditor.getHtmlText());
                        Ook = Ook.replaceAll("<\\/{0,1}font.*?>","");;
                        Ook = Ook.replaceAll("(?<=^|\\s)Ook[.]{1}(?=\\s|$)","<font color=\"red\">Ook.</font>");
                        Ook = Ook.replaceAll("(?<=^|\\s)Ook[?]{1}(?=\\s|$)","<font color=\"yellow\">Ook?</font>");
                        Ook = Ook.replaceAll("(?<=^|\\s)Ook[!]{1}(?=\\s|$)","<font color=\"blue\">Ook!</font>");
                        htmlEditor.setHtmlText(Ook);

                    }
                });
                htmlEditor.setOnKeyReleased(new EventHandler<KeyEvent>()
                {
                    @Override
                    public void handle(KeyEvent event)
                    {
                        if (eventValidation(event))
                        {
                            String Ook = new String(htmlEditor.getHtmlText());
                            Ook = Ook.replaceAll("<\\/{0,1}font.*?>","");
                            Ook = Ook.replaceAll("(?<=^|\\s|\b)Ook[.]{1}(?=\\s|$|&nbsp;)","<font color=\"red\">Ook.</font>");
                            Ook = Ook.replaceAll("(?<=^|\\s|\b)Ook[?]{1}(?=\\s|$|&nbsp;)","<font color=\"yellow\">Ook?</font>");
                            Ook = Ook.replaceAll("(?<=^|\\s|\b)Ook[!]{1}(?=\\s|$|&nbsp;)","<font color=\"blue\">Ook!</font>");
                            htmlEditor.setHtmlText(Ook);
                        }
                    }


                    private boolean pasteEvent(KeyEvent event)
                    {
                        return event.isShortcutDown() && event.getCode() == KeyCode.V;
                    }

                    private boolean selectAllEvent(KeyEvent event)
                    {
                        return event.isShortcutDown() && event.getCode() == KeyCode.A;
                    }

                    private boolean eventValidation(KeyEvent event)
                    {
                        return !selectAllEvent(event)
                                && characterKeyReleased(event) || ((pasteEvent(event)));
                    }
                    private boolean characterKeyReleased(KeyEvent event)
                    {

                        switch (event.getCode())
                        {
                            case LEFT:
                            case RIGHT:
                            case UP:
                            case DOWN:
                            case ALT:
                            case COMMAND:
                            case CONTROL:
                            case SHIFT:
                            case PAGE_UP:
                            case PAGE_DOWN:
                            case HOME:
                            case END:
                                return false;
                            default:
                                return true;
                        }

                    }
                });

                root.getChildren().addAll(scrllPane, htmlEditor, checkButton);
                scn.setRoot(root);
                stage.setScene(scn);
                stage.show();
            }
        }
