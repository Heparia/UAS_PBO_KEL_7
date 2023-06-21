/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bakerypakray;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class BakeryPakRay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama:\n1. Roti Manis\n2. Roti Tawar\n3. Pizza\nPilihanmu: ");
        int nama = input.nextInt();
        System.out.print("Varian: ");
        int varian = input.nextInt();
        System.out.print("Jumlah: ");
        int jumlah = input.nextInt();
//        Pizza a = new Pizza();
        VarianSatuPizza b = new VarianSatuPizza();
        b.displayHargaVarian();
//        MacamRoti b = new MacamRoti();
//        b.displayToppingFilling();
    }
    
}
