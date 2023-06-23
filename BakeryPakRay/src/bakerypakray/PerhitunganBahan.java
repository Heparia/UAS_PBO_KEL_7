/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

/**
 *
 * @author user
 */
public class PerhitunganBahan {
    String nama = null;
    int varian = 0;
    int jumlah = 0;
    
    VarianSatuRotiManis v1RM = new VarianSatuRotiManis();
//    VarianDuaRotiManis v2RM = new VarianDuaRotiManis();
//    VarianTigaRotiManis v3RM = new VarianTigaRotiManis();
//    VarianSatuRotiTawar v1RT = new VarianSatuRotiTawar();
//    VarianDuaRotiTawar v2RT = new VarianDuaRotiTawar();
//    VarianSatuPizza v1P = new VarianSatuPizza();
    
    public PerhitunganBahan(String[] orderan){
        this.nama = orderan[0];
        this.varian = Integer.parseInt(orderan[1]);
        this.jumlah = Integer.parseInt(orderan[2]);
    }
    
    public void displayCheck(){
        System.out.println("Perhitungan Bahan");
    }
    public String[][][] getToppingFilling(String nama, int varian){
        String[][][] data = new String[0][0][0];
        String[][] toppings = null;
        String[][] fillings = null;
        switch (nama) {
            case "Roti Manis":
                switch (varian) {
                    case 1:
                        toppings = v1RM.getTopping();
                        fillings = v1RM.getFilling();
                        break;
//                    case 2:
//                        toppings = v2RM.getTopping();
//                        fillings = v2RM.getFilling();
//                        break;
//                    case 3:
//                        toppings = v3RM.getTopping();
//                        fillings = v3RM.getFilling();
//                        break;
                    default:
                        fillings = new String[0][0];
                        toppings = new String[0][0];
                        break;
                }
                break;
//            case "Roti Tawar":
//                switch (varian) {
//                    case 1:
//                        toppings = v1RT.getTopping();
//                        fillings = v1RT.getFilling();
//                        break;
//                    case 2:
//                        toppings = v2RT.getTopping();
//                        fillings = v2RT.getFilling();
//                        break;
//                    default:
//                        fillings = new String[0][0];
//                        toppings = new String[0][0];
//                        break;
//                }
//                break;
//            case "Pizza":
//                switch (varian) {
//                    case 1:
//                        toppings = v1P.getTopping();
//                        fillings = v1P.getFilling();
//                        break;
//                    default:
//                        fillings = new String[0][0];
//                        toppings = new String[0][0];
//                        break;
//                }
//                break;
            default:
                fillings = new String[0][0];
                toppings = new String[0][0];
                break;
        }
        data[0] = fillings;
        data[1] = toppings;
        return data;
    }
    
    public String[][] getFilling(){
        return this.getToppingFilling(this.nama, this.varian)[0];
    }
    
    public String[][] getTopping(){
        return this.getToppingFilling(this.nama, this.varian)[1];
    }

    public String[][] bahanTopFill(){
        String[][] filling = this.getFilling();
        String[][] topping = this.getTopping();
        String[][] topFill = new String[filling.length][filling[0].length];
        for (int i = 0; i < filling.length; i++) {
            for (int j = 0; j < filling[i].length; j++) {
                topFill[i][j] = filling[i][j];
            }
        }
        return topFill;
    }
    
    public int[] getKomposisiRotiManis(){
        return v1RM.getKomposisi();
    }
    
//    public int[] getKomposisiRotiTawar(){
//        return v1RT.getKomposisi();
//    }
//    
//    public int[] getKomposisiPizza(){
//        return v1P.getKomposisi();
//    }
}
