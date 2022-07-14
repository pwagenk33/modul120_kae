package com.example.lagerverwaltungssystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class haupt_view {

    Lager l;

    public haupt_view(){
         l = new Lager();
    }

    @FXML
    private Button hinzufügen;

    @FXML
    private Button kistenList;

    @FXML
    void KisteNeu(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(haupt_view.class.getResource("hello-view.fxml"));
        fxmlLoader.setControllerFactory(haupt_view -> new hello_view(l));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Kisten erstellen");
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void kistenListe(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(haupt_view.class.getResource("kisten-view.fxml"));
        fxmlLoader.setControllerFactory(haupt_view -> new kisten_view(l));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Kistenliste");
        stage.setScene(scene);
        stage.show();

    }

}

