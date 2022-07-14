package com.example.lagerverwaltungssystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArtikelAendern implements Initializable {

    Gegenstand g;
    ListView<String> kistenInhalt;
    Kiste k;
    ArrayList<Gegenstand> gegenstand;

    public ArtikelAendern(Gegenstand g, ListView<String> kistenInhalt, Kiste k, ArrayList<Gegenstand> gegenstand){

        this.g = g;
        this.kistenInhalt = kistenInhalt;
        this.k = k;
        this.gegenstand = gegenstand;

    }

    @FXML
    private Label meldung;

    @FXML
    private TextField neuerArtikelname;

    @FXML
    private TextField neuerPreis;

    @FXML
    private Button submit;

    @FXML
    void submit(ActionEvent event) {

        String name = neuerArtikelname.getText();
        g.setName(name);

        String price = neuerPreis.getText();
        float preis = Float.parseFloat(price);

        g.setPreis(preis);

        ArrayList<String> artikelString = new ArrayList<>();
        for (int i = 0; i < gegenstand.size(); i++) {

            artikelString.add("Artikelname: " + k.artikel.get(i).getName() + "       " + "Preis: " + k.artikel.get(i).getPreis());


        }

        ObservableList<String> listeGegenstand = FXCollections.observableArrayList(artikelString);
        kistenInhalt.setItems(listeGegenstand);

        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        neuerArtikelname.setText(g.getName());

        String altePreis = String.valueOf(g.getPreis());
        neuerPreis.setText(altePreis);

    }
}

