/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */

public class Start { 
    Adonan adonan = new Adonan();
    ToppingFilling topFill = new ToppingFilling();
    
    ArrayList<String[][][]> data = new ArrayList<>();
    ArrayList<String[][]> finalData = new ArrayList<>();
    ArrayList<String[]> dataDisplay = new ArrayList<>();

    public void start(ArrayList<String[][][]> input) {
        this.data = input;
    }
    
    public void mergeData(ArrayList<String[][][]> inputData) {
        for (String[][][] dataa : inputData) {
            for (String[][] dataSet : dataa) {
                if (dataSet == null || dataSet[0] == null || dataSet[1] == null) {
                        continue;
                    }
                for (String[] item : dataSet) {
                    if (item == null || item[0] == null || item[1] == null) {
                        continue;
                    }
                    String nama = item[0];
                    double jumlah = 0.0;

                    try {
                        jumlah = Double.parseDouble(item[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing quantity for " + nama);
                        continue;
                    }

                    boolean found = false;
                    for (String[][] mergedItem : finalData) {
                        if (mergedItem[0][0].equals(nama)) {
                            double total = Double.parseDouble(mergedItem[0][1]) + jumlah;
                            mergedItem[0][1] = Double.toString(total);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        finalData.add(new String[][]{{nama, Double.toString(jumlah)}});
                    }
                }
            }
        }
    }
    
    public void hitungBanyakKemasan() {
        ArrayList<String[]> hasil = new ArrayList<>();
        String[] namaAdonan = adonan.getAllNamaKemasan();
        int[] beratAdonan = adonan.getAllBeratKemasan();
        String[] namaTopFill = topFill.getAllNamaKemasan();
        int[] beratTopFill = topFill.getAllBeratKemasan();
        
        for (String[][] item : this.finalData) {
            for (int a = 0; a < namaAdonan.length; a++) {
                if (item[0][0] != null && item[0][0].equals(namaAdonan[a])) {
                    int value = (int) Double.parseDouble(item[0][1]) / beratAdonan[a];
                    if ((int) Double.parseDouble(item[0][1]) % beratAdonan[a] > 0) {
                        value = value + 1;
                    }
                    hasil.add(new String[] {namaAdonan[a], item[0][1], Integer.toString(value*beratAdonan[a]), Integer.toString(value)});
                }
            }
            for (int a = 0; a < namaTopFill.length; a++) {
                if (item[0][0] != null && item[0][0].equals(namaTopFill[a])) {
                    int value = (int) Double.parseDouble(item[0][1]) / beratTopFill[a];
                    if ((int) Double.parseDouble(item[0][1]) % beratTopFill[a] > 0) {
                        value = value + 1;
                    }
                    hasil.add(new String[] {namaTopFill[a], item[0][1], Integer.toString(value*beratTopFill[a]), Integer.toString(value)});
                }
            }
        }
        this.dataDisplay.clear();
        this.dataDisplay.addAll(hasil);
    }

    
    public void finish() {
        mergeData(data);
        this.hitungBanyakKemasan();
        System.out.println("===========");
        System.out.println("Bahan-Bahan");
        System.out.println("===========");
        for (String[] item : this.dataDisplay) {
            System.out.println("Nama: "+item[0]);
            System.out.println("Total berat dibutuhkan: " +item[1] + " gram");
            System.out.println("Total berat kemasan: " +item[2] + " gram");
            System.out.println("Jumlah kemasan: " +item[3]);
            System.out.println("");
        }
    }
}

