/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

/**
 *
 * @author Seli Agustina
 */
public class VarianDuaRotiManis extends RotiManis implements Varian {
    protected String[][] filling = {{"Selai Red Bean", "10"}};
    protected String[][] topping = {{"Krim Vanilla", "5"}};

    @Override
    public double getHargaTopFill() {
        double[] hargaTopping = super.setHargaPerKomposisiTopFill(topping);
        double[] hargaFilling = super.setHargaPerKomposisiTopFill(filling);
        double[] hasil = new double[hargaTopping.length + hargaFilling.length];
        System.arraycopy(hargaTopping, 0, hasil, 0, hargaTopping.length);
        System.arraycopy(hargaFilling, 0, hasil, hargaTopping.length, hargaFilling.length);
        double harga = 0;
        for(int i = 0; i < hasil.length; i ++){
            harga = harga + hasil[i];
        }
        return harga;
    }

    @Override
    public void displayCheckVarian() {
        System.out.println("Varian 2 Roti Manis seharga Rp "+this.getHargaJualVarian());
    }

    @Override
    public double getModalVarian() {
        return this.getJumlahModalAdonanPerPcs() + this.getHargaTopFill();
    }

    @Override
    public int getHargaJualVarian() {
        int hasil = (int) (((100+this.profit)*this.getModalVarian())/100);
        return hasil;
    }

    @Override
    public String[][] getGabunganTopFill() {
        String[][] hasil = new String[topping.length + filling.length][2];
        System.arraycopy(topping, 0, hasil, 0, topping.length);
        System.arraycopy(filling, 0, hasil, topping.length, filling.length);
        return hasil;
    }
    
}
