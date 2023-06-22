/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

/**
 *
 * @author Seli Agustina
 */
public class RotiManis extends MacamRoti{
    private int[] komposisiRotiManis = {1000, 150, 150, 20, 300, 250, 80, 400};
    private int beratKomposisi = 2350;
    private int beratSatuPcs = 50;

    @Override
    int hitungJumlahPcs() {
        return this.beratKomposisi/this.beratSatuPcs;
    }

    @Override
    void displayCheck() {
        System.out.println(this.getJumlahModalAdonanPerPcs());
    }

    @Override
    int sisaBahan() {
        return this.beratKomposisi%this.beratSatuPcs;
    }

    @Override
    int[] getHargaPerKomposisi() {
        return this.setHargaPerKomposisiAdonan(this.komposisiRotiManis);
    }

    @Override
    int getJumlahModalAdonanPerPcs() {
        int[] data = this.getHargaPerKomposisi();
        int hasil = 0;
        for(int i = 0; i < data.length; i ++){
            hasil = hasil + data[i];
        }
        return hasil/this.hitungJumlahPcs();
    }
}
