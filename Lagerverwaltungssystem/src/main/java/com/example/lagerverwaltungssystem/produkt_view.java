package com.example.lagerverwaltungssystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class produkt_view {

    Kiste k;
    String artikel;
    float p;
    Lager l;


    public produkt_view(int zahl, Lager l){

         k = new Kiste(zahl);
         this.l = l;
         l.addKiste(k);

    }

    @FXML
    private ImageView controller;

    @FXML
    private ImageView handy;

    @FXML
    private ImageView laptop;

    @FXML
    private Label antwort1;

    @FXML
    private TextField artikelname;

    @FXML
    private TextField preis;


    @FXML
    void clickOnController(MouseEvent event) {

        p = Float.parseFloat(preis.getText());
        artikel = artikelname.getText();
        k.addArtikel(new Gamingcontroller(artikel,p));
        antwort1.setText("Du hast einen Controller hinzugefügt!");

    }

    @FXML
    void clickOnHandy(MouseEvent event) {

        p = Float.parseFloat(preis.getText());
        artikel = artikelname.getText();
        k.addArtikel(new Handy(artikel,p));
        antwort1.setText("Du hast einen Handy hinzugefügt!");
    }

    @FXML
    void clickOnLaptop(MouseEvent event) {

        p = Float.parseFloat(preis.getText());
        artikel = artikelname.getText();
        k.addArtikel(new Laptop(artikel,p));
        antwort1.setText("Du hast einen Laptop hinzugefügt!");
    }


}
