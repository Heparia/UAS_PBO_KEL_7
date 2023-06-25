/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class PerhitunganBahan extends Start{
    String nama = null;
    int varian = 0;
    int jumlah = 0;
    int[] komposisi;
    int banyakPcs;
    String[] namaAdonan = this.adonan.getAllNamaKemasan();
    String[][] topping;
    String[][] filling;
    
    String[][][] dataBahan = new String[adonan.getJumlahBahan() + topFill.getJumlahBahan()][][];
    
    public void setData(String[][][] data){
        this.topping = data[1];
        this.filling = data[0];
    }
    public void setDataOrderan(String[] orderan) {
        this.nama = orderan[0];
        this.varian = Integer.parseInt(orderan[1]);
        this.jumlah = Integer.parseInt(orderan[2]);
    }

    public void setKomposisiBanyakPcs(int[] komposisi, int banyakPcs) {
        this.komposisi = komposisi;
        this.banyakPcs = banyakPcs;
    }

    public String[][] getKomposisiRoti() {
        String[][] data = new String[komposisi.length][2];
        for (int i = 0; i < komposisi.length; i++) {
            data[i][0] = namaAdonan[i];
            data[i][1] = String.valueOf(getBeratBahanAdonan(komposisi[i], banyakPcs));
        }
        return data;
    }

    public double getBeratBahanAdonan(int komposisiBerat, int banyakPcs) {
        return (this.jumlah * komposisiBerat) / (double) banyakPcs;
    }
//  
    public String[][][] getData(){
        return this.dataBahan;
    }
    
    public String[][] bahanTopFill() {
        String[][] topFill = new String[filling.length + topping.length][2];

        for (int i = 0; i < filling.length; i++) {
            for (int j = 0; j < filling[i].length; j++) {
                topFill[i][j] = filling[i][j];
            }
        }

        for (int i = filling.length; i < filling.length + topping.length; i++) {
            for (int j = 0; j < topping[i - filling.length].length; j++) {
                topFill[i][j] = topping[i - filling.length][j];
            }
        }

        for (int i = 0; i < topFill.length; i++) {
            for (int j = i + 1; j < topFill.length; j++) {
                if (topFill[i][0] == null ? topFill[j][0] == null : topFill[i][0].equals(topFill[j][0])) {
                    int combinedValue = Integer.parseInt(topFill[i][1]) + Integer.parseInt(topFill[j][1]);
                    topFill[i][1] = String.valueOf(combinedValue);
                    topFill[j][0] = null;
                    topFill[j][1] = null;
                }
            }
        }
        for(String[] item : topFill){
            if(item == null || item[1] ==null || item[0] == null){
                continue;
            }
            item[1] = Integer.toString(Integer.parseInt(item[1]) * this.jumlah);
        }
        return topFill;
    }
    
        
    public void setData() {        
        this.dataBahan[0] = this.getKomposisiRoti();
        this.dataBahan[1] = this.bahanTopFill();
    }

}
