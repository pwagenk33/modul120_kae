package com.example.lagerverwaltungssystem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class hello_view {

    Lager l;


    public hello_view(Lager l){
        this.l = l;
    }


    @FXML
    private Label Fehlermeldung;

    @FXML
    private ImageView kiste;

    @FXML
    private TextField index;

    @FXML
    void clickOnKiste(MouseEvent event) throws IOException {

        int zahl = Integer.valueOf(index.getText());

            if (l.KistenCheck(zahl)) {

                Fehlermeldung.setText(null);


                FXMLLoader fxmlLoader = new FXMLLoader(hello_view.class.getResource("produkt-view.fxml"));
                fxmlLoader.setControllerFactory(hello_view -> new produkt_view(zahl, l));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root, 600, 400);
                Stage stage = new Stage();
                stage.setTitle("KISTE FÜLLEN");
                stage.setScene(scene);
                stage.show();

            } else {


                Fehlermeldung.setText("Diese Kiste hat es schon mit der ID " + zahl);
                Fehlermeldung.setAlignment(Pos.CENTER);
                Fehlermeldung.setTextFill(Color.RED);

            }


    }

}

