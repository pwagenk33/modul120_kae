package com.example.lagerverwaltungssystem;

import java.util.ArrayList;

public class Lager {
    public ArrayList<Kiste> kisten;
    public float preis;

    public Lager(){

        kisten = new ArrayList<Kiste>();
    }

    //Hinzufügen einer Kiste

    public boolean addKiste(Kiste dk){
        boolean ok = true;

        //Wenn die Kiste selbe ID haben sollte, wird sie nicht erstellt

        for(int i = 0; i < kisten.size();i++){
            if(kisten.get(i).id == dk.id){
                ok = false;
                break;
            }

        }
        if(ok) {
            kisten.add(dk);
        }

        return ok;

    }

    //Aendern der Kiste

    public void aendernKiste(Kiste k, int neueID){

        if(!kisten.contains(k.id)){
            k.id = neueID;
        }
        else{
            System.out.println("Diese ID ist schon vergeben!");
        }

    }

    public void removeKiste(Kiste k) throws Exception{

        if (!kisten.contains(k)){
            throw new Exception("Kiste existiert nicht");
        }
        else {
            kisten.remove(k);
        }
    }

    //Print aller Kisten bei uns im Lager (wird gehaendelt im GUI)

    public void printAlleKisten(){
        for (Kiste k: kisten) {
            System.out.println("In Kiste Nummer " + k.getID() + " befindet sich: ");
            k.printKistenInhalt();
            System.out.println(" ");
        }
    }

    //Gesamtpreis aller Kisten
    public void gesamtVermoegen(){

        for(Kiste k : kisten){
            preis = preis + k.getPreis();
        }

        System.out.println(preis);
    }

    public boolean KistenCheck(int number){
        boolean ok = true;
        for(int i = 0; i < kisten.size();i++){
            if(kisten.get(i).id == number){
                ok = false;
            }
        }
          return ok;
    }
}

