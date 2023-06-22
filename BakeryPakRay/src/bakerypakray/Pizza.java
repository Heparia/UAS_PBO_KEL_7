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
    
    public void setKomposisi(){
        this.setTotalKomposisi(this.komposisiPizza);
    }
    
    public int jumlahPcsPerKomposisi(){
        return this.beratKomposisi/this.beratSatuPcs;
    }
    
    public int sisaKomposisi(){
        return this.beratKomposisi%this.beratSatuPcs;
    }
    
    public int[] getHargaKomposisi(){
        int[] semuaHarga = this.hitungHargaPerKomposisiAdonan(this.komposisiPizza);
        return semuaHarga;
    }
}
