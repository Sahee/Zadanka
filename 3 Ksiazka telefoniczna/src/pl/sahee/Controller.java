package pl.sahee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private TextField nameText;
    @FXML
    private TextField phoneText;
    @FXML
    private TableView<Contact> tab;
    @FXML
    private Label warnLabel;
    @FXML
    private TableColumn nameTab;
    @FXML
    private TableColumn phoneTab;
    private ObservableList<Contact> data;
    private int selIndex;

    public Controller() {
    }

    @FXML
    public void initialize() {
        this.data = FXCollections.observableArrayList();
        this.LoadContact();
        this.nameTab.setCellValueFactory(new PropertyValueFactory("name"));
        this.phoneTab.setCellValueFactory(new PropertyValueFactory("number"));
        this.tab.setItems(this.data);
    }

    @FXML
    private void AddClick(ActionEvent event) {
        if(this.Validate()) {
            Contact temp = new Contact(this.nameText.getText(), this.phoneText.getText());
            this.data.add(temp);
            this.nameText.setText("");
            this.phoneText.setText("");
            this.warnLabel.setText("");
        }

        this.SaveContact();
    }

    @FXML
    private void ModifyClick(ActionEvent event) {
        if(this.Validate()) {
            Contact temp = new Contact(this.nameText.getText(), this.phoneText.getText());
            this.data.set(this.selIndex, temp);
            this.warnLabel.setText("");
        }

        this.SaveContact();
    }

    @FXML
    private void DeleteClick(ActionEvent event) {
        this.data.remove(this.tab.getSelectionModel().getSelectedItem());
        this.tab.getSelectionModel().selectLast();
        this.SaveContact();
    }

    @FXML
    private void TableSelect(MouseEvent event) {
        if(this.tab.getSelectionModel().getSelectedIndex() != -1) {
            this.selIndex = this.tab.getSelectionModel().getSelectedIndex();
            this.Update();
        }

    }

    private boolean Validate() {
        if(!this.nameText.getText().isEmpty() && !this.phoneText.getText().isEmpty()) {
            if(this.nameText.getText().length() > 30) {
                this.warnLabel.setText("Name is too long");
                return false;
            } else if(this.phoneText.getText().length() != 8) {
                this.warnLabel.setText("The phone number length need to be 8 chars length");
                return false;
            } else if(this.phoneText.getText().charAt(3) != 45) {
                this.warnLabel.setText("Wrong phone number format, correct XXX-XXXX");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private void Update() {
        this.nameText.setText(((Contact)this.data.get(this.selIndex)).getName());
        this.phoneText.setText(((Contact)this.data.get(this.selIndex)).getNumber());
    }

    private void LoadContact() {
        try {
            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("contacts.bin"));
            Throwable var1 = null;

            try {
                while(true) {
                    this.data.add((Contact)inStream.readObject());
                }
            } catch (Throwable var12) {
                var1 = var12;
                throw var12;
            } finally {
                if(inStream != null) {
                    if(var1 != null) {
                        try {
                            inStream.close();
                        } catch (Throwable var11) {
                            var1.addSuppressed(var11);
                        }
                    } else {
                        inStream.close();
                    }
                }

            }
        } catch (IOException var14) {
            ;
        } catch (ClassNotFoundException var15) {
            var15.printStackTrace();
        }

    }

    private void SaveContact() {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("contacts.bin"));
            Throwable var1 = null;

            try {
                Iterator var3 = this.data.iterator();

                while(var3.hasNext()) {
                    Contact contact = (Contact)var3.next();
                    outStream.writeObject(contact);
                }

                outStream.close();
            } catch (Throwable var13) {
                var1 = var13;
                throw var13;
            } finally {
                if(outStream != null) {
                    if(var1 != null) {
                        try {
                            outStream.close();
                        } catch (Throwable var12) {
                            var1.addSuppressed(var12);
                        }
                    } else {
                        outStream.close();
                    }
                }

            }
        } catch (IOException var15) {
            var15.printStackTrace();
        }

    }
}
