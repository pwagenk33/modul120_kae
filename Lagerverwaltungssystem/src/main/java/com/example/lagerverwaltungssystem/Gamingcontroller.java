package com.example.lagerverwaltungssystem;

public class Gamingcontroller implements Gegenstand{

    float preis;
    String name;

    public Gamingcontroller(String name, float preis){

        this.name = name;
        this.preis = preis;

    }

    //Getter und setter für Gamingcontroller

    public float getPreis(){
        return preis;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPreis(float preis){
        this.preis = preis;
    }

}

