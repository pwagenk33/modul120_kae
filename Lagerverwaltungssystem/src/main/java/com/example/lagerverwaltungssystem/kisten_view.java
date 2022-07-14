package com.example.lagerverwaltungssystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class kisten_view implements Initializable {

    ObservableList liste = FXCollections.observableArrayList();
    Lager l;
    ArrayList<Kiste> kisten;

    public kisten_view(Lager l){

        this.l = l;
        kisten = l.kisten;

    }

    @FXML
    private ToggleButton kisteAendern;


    @FXML
    private ListView<String> myList;

    @FXML
    private ToggleButton toggleRemove;


    //VORHANDENE KISTE UPDATEN

    @FXML
    void kisteAendern(MouseEvent event) {

        if (kisteAendern.isSelected()) {

            kisteAendern.setStyle("-fx-background-color: yellow");

            myList.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    Kiste kiste = kisten.get(myList.getSelectionModel().getSelectedIndex());

                    FXMLLoader fxmlLoader = new FXMLLoader(kisten_view.class.getResource("kisten-aendern.fxml"));
                    fxmlLoader.setControllerFactory(MakeReservationController -> new KisteAendern(kiste,myList,kisten));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root, 640, 640);
                    Stage stage = new Stage();
                    stage.setTitle("Kiste ändern");
                    stage.setScene(scene);
                    stage.show();

                }
            });
        }

        else{


            kisteAendern.setStyle("-fx-background-color: lightyellow; -fx-font-weight: bold;");

            myList.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    Kiste kiste = kisten.get(myList.getSelectionModel().getSelectedIndex());
                    FXMLLoader fxmlLoader = new FXMLLoader(kisten_view.class.getResource("kisten-info.fxml"));
                    fxmlLoader.setControllerFactory(kisten_view -> new kistenInfo(l, kiste));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root, 600, 400);
                    Stage stage = new Stage();
                    stage.setTitle("Infos");
                    stage.setScene(scene);
                    stage.show();
                }
            });
        }
    }


    //VORHANDENE KISTEN LÖSCHEN

    @FXML
    void removeChesto(MouseEvent event) {


        if(toggleRemove.isSelected()) {

            toggleRemove.setStyle("-fx-background-color: red");

            myList.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    int x = myList.getSelectionModel().getSelectedIndex();
                    try {
                        l.removeKiste(kisten.get(x));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    ArrayList<String> kistenString = new ArrayList<>();
                    for (int i = 0; i < kisten.size(); i++) {

                        kistenString.add("Kiste " + l.kisten.get(i).id);


                    }

                    ObservableList<String> listeKisten = FXCollections.observableArrayList(kistenString);
                    myList.setItems(listeKisten);

                }

            });

        }else{
            toggleRemove.setStyle("-fx-background-color: #DF3A01; -fx-font-weight: bold;");

            myList.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    Kiste kiste = kisten.get(myList.getSelectionModel().getSelectedIndex());
                    FXMLLoader fxmlLoader = new FXMLLoader(kisten_view.class.getResource("kisten-info.fxml"));
                    fxmlLoader.setControllerFactory(kisten_view -> new kistenInfo(l,kiste));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root, 600, 400);
                    Stage stage = new Stage();
                    stage.setTitle("Infos");
                    stage.setScene(scene);
                    stage.show();
                }
            });


        }



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<String> kistenString = new ArrayList<>();
        for (int i = 0; i < kisten.size(); i++) {

            kistenString.add("Kiste "  + l.kisten.get(i).id);


        }

        ObservableList<String> listeKisten = FXCollections.observableArrayList(kistenString);
        myList.setItems(listeKisten);

        myList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Kiste kiste = kisten.get(myList.getSelectionModel().getSelectedIndex());
                FXMLLoader fxmlLoader = new FXMLLoader(kisten_view.class.getResource("kisten-info.fxml"));
                fxmlLoader.setControllerFactory(kisten_view -> new kistenInfo(l,kiste));
                Parent root = null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 600, 400);
                Stage stage = new Stage();
                stage.setTitle("Infos");
                stage.setScene(scene);
                stage.show();
            }
        });

    }
}
