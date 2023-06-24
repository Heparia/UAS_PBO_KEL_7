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
        ArrayList<String[][]> hasil = new ArrayList<>();
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
                    hasil.add(new String[][] {{namaAdonan[a], Integer.toString(value)}});
                }
            }
            for (int a = 0; a < namaTopFill.length; a++) {
                if (item[0][0] != null && item[0][0].equals(namaTopFill[a])) {
                    int value = (int) Double.parseDouble(item[0][1]) / beratTopFill[a];
                    if ((int) Double.parseDouble(item[0][1]) % beratTopFill[a] > 0) {
                        value = value + 1;
                    }
                    hasil.add(new String[][] {{namaTopFill[a], Integer.toString(value)}});
                }
            }
        }
        this.finalData.clear();
        this.finalData.addAll(hasil);
    }

    
    public void finish() {
        mergeData(data);
        System.out.println("============");
        System.out.println("Berat Bahan");
        System.out.println("============");
        for (String[][] item : finalData) {
            System.out.println("Nama: "+item[0][0]);
            System.out.println("Berat: " +item[0][1] +" gram");
        }
        this.hitungBanyakKemasan();
        System.out.println("==============");
        System.out.println("Jumlah Kemasan");
        System.out.println("==============");
        for (String[][] item : finalData) {
            System.out.println("Nama: "+item[0][0]);
            System.out.println("Jumlah: " +item[0][1]);
        }
    }
}

