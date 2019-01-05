package com.example.firni.zado;

public class Kerdesek {

    public String kKerdesek[] = {
            "Mennyi a deltoid belső szögeinek összege?",
            "Hány watt 1 lóerő?",
            "Mi a miópia?",
            "Mi a fényerősség mértékegysége?",
            "Milyen aki makrancos?",
    };

    private String kValaszok[][] = {
            {"360 fok", "180 fok","240 fok","300 fok"},
            {"621", "735","987","825"},
            { "Távollátás","Szemtengelyferdülés","Rövidlátás","Szemviszketés"},
            { "Amper","Kandela","Mól","Nincs mértékegysége"},
            {"Céltudatos","Félénk","Akaratos","Tökéletes"},


    };
    private String kHelyesValasz [] = {
            "360 fok",
            "735",
            "Rövidlátás",
            "Kandela",
            "Akaratos",

    };

    public String getKerdes(int a) {
        String kerdes = kKerdesek[a];
        return kerdes;
    }
    public String getValasz1(int a){
        String Valasz = kValaszok[a][0];
        return Valasz;
    }
    public String getValasz2(int a){
        String Valasz = kValaszok[a][1];
        return Valasz;
    }
    public String getValasz3(int a){
        String Valasz = kValaszok[a][2];
        return Valasz;
    }
    public String getValasz4(int a){
        String Valasz = kValaszok[a][3];
        return Valasz;
    }
    public String getHelyesValasz (int a) {
        String valasz = kHelyesValasz[a];
        return valasz;
    }


}
