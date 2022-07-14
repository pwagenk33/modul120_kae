package com.example.lagerverwaltungssystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kiste implements Gegenstand{

    public ArrayList<Gegenstand> artikel;
    public int id;
    public float preis;

    public Kiste(int id){
        artikel = new ArrayList<Gegenstand>();
        this.id = id;
        this.preis = 0;
    }


    //Artikel zu einer Kiste adden

    public void addArtikel(Gegenstand g){
        artikel.add(g);
    }

    public void artikelNameAendern(Gegenstand g,String s){

        if(artikel.contains(g.getName())){
            System.out.println("Dieser Name ist schon vorhanden!");
        }
        else{
            g.setName(s);
        }

    }

    public void setId(int id){

        this.id = id;

    }

    //den Preis des Artikels aendern

    public void artikelPreisAendern(Gegenstand g,float p){
        g.setPreis(p);
    }

    //Artikel von der Kiste entfernen

    public void removeArtikel(Gegenstand g) throws Exception{

        if (!artikel.contains(g)){
            throw new Exception("Artikel existiert nicht");
        }
        else {
            artikel.remove(g);
        }
    }

    //Kistenprint gespeichert als Hashmap

    public void printKistenInhalt(){
        HashMap<String,Integer> countObejct = new HashMap<String,Integer>();
        for (Gegenstand g: artikel ) {

            String name = g.getClass().getName();
            Integer count = countObejct.get(name);
            if(count == null){

                countObejct.put(name, 1);
            }else{

                countObejct.put(name, count + 1);
            }


        }

        for(Map.Entry<String, Integer> reportRow : countObejct.entrySet()){

            System.out.println(reportRow.getValue()+"x" + " " + reportRow.getKey().substring(12));
        }


    }

    //Preis von allen Artikel bekommen

    public float getPreis() {
        for(int i = 0; i < artikel.size();i++){
            preis = preis + artikel.get(i).getPreis();
        }

        return preis;
    }

    public void setName(String name){

    }

    public void setPreis(float preis){

    }

    public String getName(){
        return null ;
    }

    public int getID(){
        return id;
    }




}

