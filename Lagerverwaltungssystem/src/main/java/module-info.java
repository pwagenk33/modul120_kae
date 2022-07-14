module com.example.lagerverwaltungssystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lagerverwaltungssystem to javafx.fxml;
    exports com.example.lagerverwaltungssystem;
}