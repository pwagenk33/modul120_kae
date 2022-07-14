package com.example.lagerverwaltungssystem;

public class Handy implements Gegenstand {
    float preis;
    String name;

    public Handy(String name, float preis){

        this.name = name;
        this.preis = preis;

    }

    //Handy getter und setter Methoden

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

