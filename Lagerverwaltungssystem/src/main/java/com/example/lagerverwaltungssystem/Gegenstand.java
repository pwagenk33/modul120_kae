package com.example.lagerverwaltungssystem;

public interface Gegenstand {

    //Gegenstandsinterface

    public String name = null;
    public String preis = null;
    public float getPreis();
    public String getName();
    public void setName(String name);
    public void setPreis(float preis);
}
