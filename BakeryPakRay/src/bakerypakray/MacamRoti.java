/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author user
 */
public class MacamRoti {
    Adonan adonan = new Adonan();
    ToppingFilling topFill = new ToppingFilling();
     
    ArrayList<String[][]> toppingFilling = new ArrayList<>();
    
    public int[] hitungHargaPerKomposisiAdonan(int[] komposisi){
        int[] berat = adonan.getAllBeratKemasan();
        int[] harga = adonan.getAllHargaBahan();
        int[] hargaKomposisi = new int[komposisi.length];
        for(int i = 0; i < komposisi.length; i ++){
            hargaKomposisi[i] = (komposisi[i] * harga[i])/berat[i];
        }
        return hargaKomposisi;
    }
    
    public int[] hitungHargaPerKomposisiTopFill(int[] komposisi){
        int[] berat = topFill.getAllBeratKemasan();
        int[] harga = topFill.getAllHargaBahan();
        int[] hargaKomposisi = new int[komposisi.length];
        for(int i = 0; i < komposisi.length; i ++){
            hargaKomposisi[i] = (komposisi[i] * harga[i])/berat[i];
        }
        return hargaKomposisi;
    }
    
    public int totalHargaVarian(int[] adonan, int[] topFil){
        int hasil = 0;
        for(int i = 0; i < adonan.length; i ++){
            hasil = hasil + adonan[i];
        }
        for(int i = 0; i < topFil.length; i ++){
            hasil = hasil + topFil[i];
        }
        return hasil;
    }
    
    public void setToppingFilling(String[][] topFil){
        toppingFilling.add(topFil);
    }
    
    public void displayToppingFilling(){
        for (String[][] topFil : toppingFilling) {
            for (String[] row : topFil) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}
