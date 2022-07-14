package com.example.lagerverwaltungssystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class kistenInfo implements Initializable {

    Lager l;
    Kiste k;
    ArrayList<Gegenstand> gegenstand;

    public kistenInfo(Lager l,Kiste k){
        this.l = l;
        this.k = k;
        gegenstand = k.artikel;
    }

    @FXML
    private ListView<String> kistenInfo;

    @FXML
    private Label Antwort;


    @FXML
    private ToggleButton artikelUpdate;

    @FXML
    private ToggleButton artikelDelete;

    //DELETE ARTIKEL

    @FXML
    void artikelDelete(MouseEvent event) {

        if(artikelDelete.isSelected()) {

            artikelDelete.setStyle("-fx-background-color: red");


            kistenInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override

                public void handle(MouseEvent mouseEvent) {
                    int x = kistenInfo.getSelectionModel().getSelectedIndex();
                    try {
                        k.removeArtikel(gegenstand.remove(x));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    ArrayList<String> kistenString = new ArrayList<>();
                    for (int i = 0; i < gegenstand.size(); i++) {


                        kistenString.add("Artikelname: " + k.artikel.get(i).getName() + "       " + "Preis: " + k.artikel.get(i).getPreis());

                    }

                    ObservableList<String> listeKisten = FXCollections.observableArrayList(kistenString);
                    kistenInfo.setItems(listeKisten);
                    Antwort.setText("Der Gegenstand wurde erfolgreich gelöscht!");
                    Antwort.setAlignment(Pos.CENTER);
                    Antwort.setTextFill(Color.GREEN);
                }

            });


        }
        else{
            artikelDelete.setStyle("-fx-background-color: #DF3A01");
            kistenInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    Gegenstand gegenstande = gegenstand.get(kistenInfo.getSelectionModel().getSelectedIndex());
                    FXMLLoader fxmlLoader = new FXMLLoader(kistenInfo.class.getResource("artikel-aendern.fxml"));
                    fxmlLoader.setControllerFactory(MakeReservationController -> new ArtikelAendern(gegenstande, kistenInfo, k, gegenstand));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root, 640, 640);
                    Stage stage = new Stage();
                    stage.setTitle("Artikel ändern");
                    stage.setScene(scene);
                    stage.show();
                }
            });
        }

    }

    //UPDATEN VON ARTIKEL

    @FXML
    void artikelUpdate(MouseEvent event) {

        if (artikelUpdate.isSelected()) {

            artikelUpdate.setStyle("-fx-background-color: yellow");

            kistenInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    Gegenstand artikel = gegenstand.get(kistenInfo.getSelectionModel().getSelectedIndex());

                    FXMLLoader fxmlLoader = new FXMLLoader(kistenInfo.class.getResource("artikel-aendern.fxml"));
                    fxmlLoader.setControllerFactory(MakeReservationController -> new ArtikelAendern(artikel, kistenInfo, k, gegenstand));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root, 640, 640);
                    Stage stage = new Stage();
                    stage.setTitle("Artikel ändern ");
                    stage.setScene(scene);
                    stage.show();
                    Antwort.setText("Ihr Gegenstand wurde erfolgreich geupdated!");
                    Antwort.setAlignment(Pos.CENTER);
                    Antwort.setTextFill(Color.GREEN);

                }
            });

        }
        else{
            artikelUpdate.setStyle("-fx-background-color: lightyellow");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<String> artikelString = new ArrayList<>();
        for (int i = 0; i < gegenstand.size(); i++) {

            artikelString.add("Artikelname: " + k.artikel.get(i).getName() + "       " + "Preis: " + k.artikel.get(i).getPreis());


        }

        ObservableList<String> listeGegenstand = FXCollections.observableArrayList(artikelString);
        kistenInfo.setItems(listeGegenstand);


    }
}

