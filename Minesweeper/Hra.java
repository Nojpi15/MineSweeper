
import fri.shapesge.Manazer;
import java.util.Scanner;

public class Hra {

    private Manazer manazer;
    private Grid grid;
 


    
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
        int x = xGraficke / grid.getVelkostPolicka();
        int y = yGraficke / grid.getVelkostPolicka();
        
        grid.odhalPole(x, y);
    
    }
    
    public void zrus() {
       System.exit(0); 
    
    }
}