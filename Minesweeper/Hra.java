import fri.shapesge.Manazer;
import java.util.Scanner;

public class Hra {

    private Manazer manazer;
    private Grid grid;

    public Hra() {
        this.start();
        
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
    }

    public void start() {
        Scanner citac = new Scanner(System.in);
        System.out.println("Zadajte názov obtiažnosti: lahka, stredna, tazka, vlastna");
        String nazov = citac.nextLine();
        
        if (nazov.toLowerCase().equals("lahka")) {
            this.grid = new Grid(5, 5, 50, 10);
        } else if (nazov.toLowerCase().equals("stredna")) {
            this.grid = new Grid(10, 10, 50, 25);
        } else if (nazov.toLowerCase().equals("tazka")) {
            this.grid = new Grid(20, 20, 50, 50);
        } else if (nazov.toLowerCase().equals("vlastna")) {

            System.out.println("Zadajte šírku gridu:");
            int sirka = citac.nextInt();

            System.out.println("Zadajte výšku gridu:");
            int vyska = citac.nextInt();

            System.out.println("Zadajte počet umiestnených mín:");
            int pocetMin = citac.nextInt();

            int maxMiny = sirka * vyska;
            if (pocetMin <= 0 || pocetMin >= maxMiny) {
                System.out.println("Zadaný počet mín je neplatný, skúste znovu!");
                System.out.println("Zadajte počet umiestnených mín:");
            }

            this.grid = new Grid(sirka, vyska, 50, pocetMin);
        } else {
            System.out.println("Zadali ste neplatný názov");
            this.start();
        }
    }
    
    public void vyberSuradnice(int xGraficke, int yGraficke) {
        int x = xGraficke / this.grid.getVelkostPolicka();
        int y = yGraficke / this.grid.getVelkostPolicka();

        grid.odhalPole(x, y);
    }

    public void vyberVlajku(int xGraficke, int yGraficke) {
        int x = xGraficke / this.grid.getVelkostPolicka();
        int y = yGraficke / this.grid.getVelkostPolicka();

        grid.umiestniVlajku(x, y);
    }

    public void zrus() {
        System.exit(0); 
    }
}