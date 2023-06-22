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
    Adonan adonan = new Adonan();
    ToppingFilling topFill = new ToppingFilling();
    
    abstract int hitungJumlahPcs();
    abstract int sisaBahan();
    abstract void displayCheck();
    abstract int[] getHargaPerKomposisi();
    abstract int getJumlahModalAdonanPerPcs();
    
    public int[] setHargaPerKomposisiAdonan(int[] komposisi){
        int[] berat = adonan.getAllBeratKemasan();
        int[] harga = adonan.getAllHargaBahan();
        int[] hargaKomposisi = new int[komposisi.length];
        for(int i = 0; i < komposisi.length; i ++){
            hargaKomposisi[i] = (komposisi[i] * harga[i])/berat[i];
        }
        return hargaKomposisi;
    }
    
    public int[] hitungHargaPerKomposisiTopFill(String[][] data){
        String[] nama = topFill.getAllNamaKemasan();
        int[] berat = topFill.getAllBeratKemasan();
        int[] harga = topFill.getAllHargaBahan();
        int[] hargaKomposisi = new int[data.length];
        for(int i = 0; i < data.length; i ++){
            for (String nama1 : nama) {
                if (data[i][0] == null ? nama1 == null : data[i][0].equals(nama1)) {
                    int angka = Integer.parseInt(data[i][1]);
                    hargaKomposisi[i] = (angka * harga[i])/berat[i];
                }
            }
        }
        return hargaKomposisi;
    }
}
