/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;
/**
 *
 * @author user
 */
public abstract class MacamRoti {
    int profit = 40;
    
    Adonan adonan = new Adonan();
    ToppingFilling topFill = new ToppingFilling();
    
    abstract int hitungJumlahPcs();
    abstract int sisaBahan();
    abstract void displayCheck();
    abstract int[] getKomposisi();
    abstract double[] getHargaPerKomposisi();
    abstract double getJumlahModalAdonanPerPcs();
    
    public double[] setHargaPerKomposisiAdonan(int[] komposisi){
        int[] berat = adonan.getAllBeratKemasan();
        int[] harga = adonan.getAllHargaBahan();
        double[] hargaKomposisi = new double[komposisi.length];
        for(int i = 0; i < komposisi.length; i ++){
            hargaKomposisi[i] = (komposisi[i] * harga[i])/berat[i];
        }
        return hargaKomposisi;
    }
    
    public double[] setHargaPerKomposisiTopFill(String[][] data){
        String[] nama = topFill.getAllNamaKemasan();
        int[] berat = topFill.getAllBeratKemasan();
        int[] harga = topFill.getAllHargaBahan();
        double[] hargaKomposisi = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < nama.length; j ++) {
                if (data[i][0] != null && data[i][0].equals(nama[j])) {
                    int angka = Integer.parseInt(data[i][1]);
                    hargaKomposisi[i] = (angka * harga[j]) / berat[j];
                }
            }
        }
        return hargaKomposisi;
    }
}
