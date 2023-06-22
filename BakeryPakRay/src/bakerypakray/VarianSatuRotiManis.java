/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

/**
 *
 * @author user
 */
public class VarianSatuRotiManis extends RotiManis implements Varian{
    private String[][] filling = {{"Keju", "5"}, {"Coklat", "5"}};
    private String[][] topping = {{"Coklat", "5"}};

    @Override
    public int getHargaTopFill() {
        int[] hargaTopping = this.hitungHargaPerKomposisiTopFill(topping);
        int[] hargaFilling = this.hitungHargaPerKomposisiTopFill(filling);
        int[] hasil = new int[hargaTopping.length + hargaFilling.length];
        System.arraycopy(hargaTopping, 0, hasil, 0, hargaTopping.length);
        System.arraycopy(hargaFilling, 0, hasil, hargaTopping.length, hargaFilling.length);
        int harga = 0;
        for(int i = 0; i < hasil.length; i ++){
            harga = harga + hasil[i];
        }
        return harga;
    }

    @Override
    public void displayCheckVarian() {
        System.out.println(this.getHargaTopFill());
    }
}
