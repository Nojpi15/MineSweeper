
/**
 * Trieda {@code Grid} slúži na «doplňte opis»…
 *
 * @author   «meno autora»
 * @version  «verzia alebo dátum»
 */

import java.util.Random; 

public class Grid {
    
    private Pole[][] policka;
    private boolean[][] miny;
    private int sirka;
    private int vyska;
    private int velkostPolicka;

    /**
     * Konštruktory objektov triedy Grid.
     */
    public Grid(int sirka, int vyska, int velkostPolicka, int pocetMin) {
        this.sirka = sirka;
        this.vyska = vyska;
        this.velkostPolicka = velkostPolicka;
        
        this.policka = new Pole[vyska][sirka];  
        this.miny = new boolean[vyska][sirka];
        
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                this.policka[y][x] = new Pole(x, y, velkostPolicka);
                this.miny[y][x] = false;
            }
        }
        generujMiny(pocetMin);
        vypocitajSusedneMiny();
    }
    
    public void generujMiny(int pocetMin) {
        Random r = new Random();
        int umiestneneMin = 0;
        
        while(umiestneneMin < pocetMin){
            int x = r.nextInt(this.sirka);
            int y = r.nextInt(this.vyska);
            if(!this.miny[y][x]) {
                this.miny[y][x] = true;
                this.policka[y][x].nastavMinu();
                umiestneneMin++;
            }
        }
    }
    public void vypocitajSusedneMiny(){
        for(int y = 0; y < this.vyska; y++) {
            for(int x = 0; x < this.sirka; x++){
                if(!this.miny[y][x]) {
                int pocet = this.spocitajSusedneMiny(x,y);
                this.policka[y][x].nastavPocetSusednychMin(pocet);
                }
            }
        }
    }
    private int spocitajSusedneMiny(int x, int y) {
        int pocet = 0; 
        int dy;
        int dx;
        
        for(dy= -1; dy <= 1; dy++){
            for(dx = -1; dx <= 1; dx++){
                if(dx == 0 && dy == 0) {
                    continue;
                }
                int susedX = x + dx;
                int susedY = y + dy;
                if(susedX >= 0 && susedX < this.sirka && susedY >= 0 && susedY < this.vyska){
                    if(this.miny[susedY][susedX]){
                    pocet++;
                    }
                }
            }
        }
        return pocet;
    }
    
    

    public Pole getPole(int x, int y) {
        if (x >= 0 && x < this.sirka && y >= 0 && y < this.vyska) {
            return this.policka[y][x];
        }
        return null;
    }

    public int getSirka() {
        return this.sirka;
    }

    public int getVyska() {
        return this.vyska;
    }

    public int getVelkostPolicka() {
        return this.velkostPolicka;
    }

    public void odhalPole(int x, int y) {
        Pole pole = this.getPole(x, y);
        if (pole != null) {
            pole.odhal();
        }

    }
    
    public void umiestniVlajku(int x, int y) {
        Pole pole = this.getPole(x, y);
        if (pole != null) {
            pole.vlajka();
        }
    }
}

