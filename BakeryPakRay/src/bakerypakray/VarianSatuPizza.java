/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

/**
 *
 * @author user
 */
public class VarianSatuPizza extends Pizza{
    private String[][] topping = {{"Keju", "30"}, {"Sosis", "50"}, {"Smoked Beef", "50"}, {"Bawang Bombay", "30"}};
    private String[][] filling = null;
    
    public int[] getSecondValues() {
        int[] values = new int[topping.length];
        for (int i = 0; i < topping.length; i++) {
            values[i] = Integer.parseInt(topping[i][1]);
        }
        return values;
    }
    
    public int[] check(){
        if (topping != null) {
            this.setToppingFilling(topping);
        }
        if (filling != null) {
            this.setToppingFilling(filling);
        }
        return hitungHargaPerKomposisiTopFill(this.getSecondValues());
    }
    
    public void dislpayHargaTopping(){
        int[] semuaHarga = this.check();
        String[] nama = topFill.getAllNamaKemasan();
        for (int i = 0; i < semuaHarga.length; i++){
            System.out.println("Nama:" + nama[i]);
            System.out.println("Harga:" + semuaHarga[i]);
        }
    }
    
    public void displayHargaVarian(){
        System.out.println(this.sisaKomposisi());
        System.out.println(this.totalHargaVarian(this.getHargaKomposisi(), this.check()));
    }
}
