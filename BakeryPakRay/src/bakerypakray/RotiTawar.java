/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

/**
 *
 * @author Seli Agustina
 */
public class RotiTawar extends MacamRoti{
    private int[] komposisiRotiTawar = {1000,125, 100, 20, 250, 200, 70, 300};
    private int beratKomposisi = 2065;
    private int beratSatuPcs = 400;

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
    int[] getKomposisi() {
        return this.komposisiRotiTawar;
    }

    @Override
    double[] getHargaPerKomposisi() {
        return super.setHargaPerKomposisiAdonan(this.komposisiRotiTawar);
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

}