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
    VarianSatuRotiManis v1RM = new VarianSatuRotiManis();
//    VarianDuaRotiManis v2RM = new VarianDuaRotiManis();
//    VarianTigaRotiManis v3RM = new VarianTigaRotiManis();
//    VarianSatuRotiTawar v1RT = new VarianSatuRotiTawar();
//    VarianDuaRotiTawar v2RT = new VarianDuaRotiTawar();
//    VarianSatuPizza v1P = new VarianSatuPizza();
    
    public void bahanTopFill(){
        String[][] topFill = v1RM.getGabunganTopFill();
        String[][] hasil = new String[topFill.length][2];
        for (int i = 0; i < topFill.length; i ++) {
            for (int j = 0; j < topFill.length; j ++) {
                if (topFill[i][0].contains(topFill[j][0])) {
                    hasil[i][0] = topFill[i][0];
                    hasil[i][1] = Integer.toString(Integer.parseInt(topFill[j][1]) + Integer.parseInt(topFill[i][1]));
                } else{
                    hasil[i] = topFill[i];
                }
            }
        }
        for(String[] h : hasil){
            System.out.println(h[1]);
        }
    }
}
