/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bakerypakray;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class BakeryPakRay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] orderan = {{"Roti Manis", "1", "50"}, {"Roti Manis", "2", "100"}, {"Roti Manis", "3", "70"}, {"Roti Tawar", "1", "20"}, {"Roti Tawar", "2", "15"}, {"Pizza", "1", "10"}};

        ArrayList<String[][][]> dataBahan = new ArrayList<>();
        Start finish = new Start();

        VarianSatuRotiManis v1RM = new VarianSatuRotiManis();
        VarianDuaRotiManis v2RM = new VarianDuaRotiManis();
        VarianTigaRotiManis v3RM = new VarianTigaRotiManis();
        VarianSatuRotiTawar v1RT = new VarianSatuRotiTawar();
        VarianDuaRotiTawar v2RT = new VarianDuaRotiTawar();
        VarianSatuPizza v1P = new VarianSatuPizza();
        
        System.out.println("================");
        System.out.println("Harga Per varian");
        System.out.println("================");
        
        for (String[] o : orderan) {
            PerhitunganBahan start = new PerhitunganBahan();
            start.setDataOrderan(o);
            String[][][] data = new String[finish.adonan.getJumlahBahan() + finish.topFill.getJumlahBahan()][][];
            String[][] toppings = null;
            String[][] fillings = null;
            int[] komposisi;
            int banyakPcs;
            switch (o[0]) {
                case "Roti Manis":
                    komposisi = v1RM.getKomposisi();
                    banyakPcs = v1RM.hitungJumlahPcs();
                    switch (Integer.parseInt(o[1])) {
                        case 1:
                            v1RM.displayCheckVarian();
                            toppings = v1RM.getTopping();
                            fillings = v1RM.getFilling();
                            break;
                        case 2:
                            v2RM.displayCheckVarian();
                            toppings = v2RM.getTopping();
                            fillings = v2RM.getFilling();
                            break;
                        case 3:
                            v3RM.displayCheckVarian();
                            toppings = v3RM.getTopping();
                            fillings = v3RM.getFilling();
                            break;
                        default:
                            fillings = new String[0][0];
                            toppings = new String[0][0];
                            break;
                    }
                    break;
                case "Roti Tawar":
                    komposisi = v1RT.getKomposisi();
                    banyakPcs = v1RT.hitungJumlahPcs();
                    switch (Integer.parseInt(o[1])) {
                        case 1:
                            v1RT.displayCheckVarian();
                            toppings = v1RT.getTopping();
                            fillings = v1RT.getFilling();
                            break;
                        case 2:
                            v2RT.displayCheckVarian();
                            toppings = v2RT.getTopping();
                            fillings = v2RT.getFilling();
                            break;
                        default:
                            fillings = new String[0][0];
                            toppings = new String[0][0];
                            break;
                    }
                    break;
                case "Pizza":
                    komposisi = v1P.getKomposisi();
                    banyakPcs = v1P.hitungJumlahPcs();
                    switch (Integer.parseInt(o[1])) {
                        case 1:
                            v1P.displayCheckVarian();
                            toppings = v1P.getTopping();
                            fillings = v1P.getFilling();
                            break;
                        default:
                            fillings = new String[0][0];
                            toppings = new String[0][0];
                            break;
                    }
                    break;
                default:
                    komposisi = null;
                    banyakPcs = 0;
                    fillings = new String[0][0];
                    toppings = new String[0][0];
                    break;
            }
            start.setKomposisiBanyakPcs(komposisi, banyakPcs);
            data[0] = fillings;
            data[1] = toppings;
            start.setData(data);
            start.setData();
            dataBahan.add(start.getData());
            finish.start(dataBahan);
        }
        System.out.println("");
        finish.finish();
    }
    
}
