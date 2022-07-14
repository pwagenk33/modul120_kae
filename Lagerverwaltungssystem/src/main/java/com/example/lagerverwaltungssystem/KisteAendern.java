package com.example.lagerverwaltungssystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class KisteAendern implements Initializable {

    Kiste k;
    ListView<String> myList;
    ArrayList<Kiste> kisten;

    public KisteAendern(Kiste k, ListView<String> myList, ArrayList<Kiste> kisten){
        this.k = k;
        this.myList = myList;
        this.kisten = kisten;
    }

    @FXML
    private TextField neueID;

    @FXML
    private Button submit;

    @FXML
    void submit(ActionEvent event) {

        String id = neueID.getText();
        int id2 = Integer.parseInt(id);

        k.setId(id2);

        ArrayList<String> kistenString = new ArrayList<>();
        for (int i = 0; i < kisten.size(); i++) {

            kistenString.add("Kiste "  + kisten.get(i).id);

        }

        ObservableList<String> listeKiste = FXCollections.observableArrayList(kistenString);
        myList.setItems(listeKiste);

        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        neueID.setText(String.valueOf(k.getID()));

    }

}
