/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */

public class Start { 
     
    String[][] dataAdonanTerUpdate = new String[8][2];
    String[][] dataTopFillTerUpdate = new String[7][2];
    
    ArrayList<String[][][]> data = new ArrayList<>();
    
    public void start(ArrayList<String[][][]> inputData) {
        this.data = inputData;
    }

    private void mergeData() {
        for (String[][][] awal : data){
            for (String[][][] akhir : data){
                if(awal == null || akhir == null){
                    continue;
                }System.out.println("c");
                for(int i = 0; i < awal[0].length; i ++){
                    if(awal[0][i][0] == akhir[0][i][0] && awal[0][i][1] != akhir[0][i][1]){
                        String nama = awal[0][i][0];
                        double first = Double.parseDouble(awal[0][i][1]);
                        double last = Double.parseDouble(akhir[0][i][1]);
                        String hasil = Double.toString(first+last);
                        System.out.println(nama);
                        System.out.println(hasil);
                    }
                }
            }
        }
    }

    public void finish() {
        this.mergeData();
//        for (String[][][] dataa : data) {
//            System.out.println("\n");
//            for (String[][] dataa2 : dataa) {
//                if (dataa2 == null) {
//                    continue;
//                }
//                for (String[] dataa3 : dataa2) {
//                    if (dataa3[0] == null || dataa3[1] == null) {
//                        continue;
//                    }
//                    System.out.println(dataa3[0]);
//                    System.out.println(dataa3[1]);
//                    }
//                }
//            }
        }
    }

