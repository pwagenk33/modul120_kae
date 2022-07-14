package com.example.lagerverwaltungssystem;

public class Laptop implements Gegenstand{

    float preis;
    String name;

    public Laptop(String name, float preis){

        this.name = name;
        this.preis = preis;

    }

    //GETTER und SETTER Methoden der Laptops

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
