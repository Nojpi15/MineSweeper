import fri.shapesge.Manazer;
import java.util.Scanner;
public class Hra {
    private Manazer manazer;
    private Grid grid;
    public boolean hraBezi = true;
    private int skore = 0;
 


    public Hra() {
    Scanner citac = new Scanner(System.in);
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
    this.grid = new Grid(sirka, vyska,50, pocetMin);
    this.manazer = new Manazer();
    this.manazer.spravujObjekt(this);

    }
    public void vyberSuradnice(int xGraficke, int yGraficke) {
        if (!hraBezi) {
            System.out.println("Hra už skončila, pre ukončenie hry stlač ESC");
            return;
        }
 
        int x = xGraficke / grid.getVelkostPolicka();
        int y = yGraficke / grid.getVelkostPolicka();
        Pole pole = grid.getPole(x, y);
        if (pole == null) return;
        boolean boloOdhalene = pole.jeUzOdhalene(); //kontrola či sa nekliklo 2x na to iste policko
        boolean jeMina = grid.odhalPole(x, y);
        if (jeMina) {
            hraBezi = false;
            grid.odhalVsetkyMiny();
            System.out.println("KONIEC HRY! Trafil si mínu :(");
            return;
        }
        if (!boloOdhalene) {
            skore++;
            System.out.println("Skóre: " + skore);
        }
    }
    public void zrus() {
       System.exit(0); 
    }
}