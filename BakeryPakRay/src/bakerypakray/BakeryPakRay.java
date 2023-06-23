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
        String[][] orderan = {{"Roti Manis", "1", "50"}, {"Roti Manis", "2", "100"}, {"Roti Manis", "3", "70"}, {"Roti Tawar", "1"," 20"}, {"Roti Tawar", "2", "15"}, {"Pizza", "1", "10"}};
        
        PerhitunganBahan a = new PerhitunganBahan();
        a.bahanTopFill();      
        
        VarianSatuRotiManis b = new VarianSatuRotiManis();
        b.displayCheckVarian();
        
        VarianDuaRotiManis c = new VarianDuaRotiManis();
        c.displayCheckVarian();
        
        VarianTigaRotiManis d = new VarianTigaRotiManis();
        d.displayCheckVarian();
        
        VarianSatuRotiTawar e = new VarianSatuRotiTawar();
        e.displayCheckVarian();
        
        VarianDuaRotiTawar f = new VarianDuaRotiTawar();
        f.displayCheckVarian();
            
    }
    
}
