/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

/**
 *
 * @author user
 */
public class Pizza extends MacamRoti{
    private int[] komposisiPizza = {1000, 100, 100, 20, 200, 180, 50, 300};
    private int beratKomposisi = 1950;
    private int beratSatuPcs = 190;

    @Override 
    int hitungJumlahPcs() {
        return this.beratKomposisi/this.beratSatuPcs;
    }

    @Override
    int sisaBahan() {
        return this.beratKomposisi%this.beratSatuPcs;
    }

    @Override
    void displayCheck() {
        System.out.println(this.getJumlahModalAdonanPerPcs());
    }  

    @Override
    double[] getHargaPerKomposisi() {
       return super.setHargaPerKomposisiAdonan(this.komposisiPizza);
    }

    @Override
    double getJumlahModalAdonanPerPcs() {
        double[] data = this.getHargaPerKomposisi();
        double hasil = 0;
        for(int i = 0; i < data.length; i ++){
            hasil = hasil + data[i];
        }
        return hasil/this.hitungJumlahPcs();
    }

    @Override
    int[] getKomposisi() {
        return this.komposisiPizza;
    }
}