/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bakerypakray;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ToppingFilling {
    ArrayList<Object> bahanToppingFilling = new ArrayList<>();
    public void setBahanToppingFilling(){
        bahanToppingFilling.add(new Object[]{"Keju", 250, 31000});
        bahanToppingFilling.add(new Object[]{"Coklat", 500, 29000});
        bahanToppingFilling.add(new Object[]{"Krim Vanilla", 500, 30000});
        bahanToppingFilling.add(new Object[]{"Selai Red Bean", 500, 25000});
        bahanToppingFilling.add(new Object[]{"Sosis", 1000, 80000});
        bahanToppingFilling.add(new Object[]{"Smocked Beef", 1000, 90000});
        bahanToppingFilling.add(new Object[]{"Bawang Bombay", 500, 40000});
        System.out.println("Berhasil menambahkan bahan-bahan topping dan filling");
    }
    
    public ArrayList<Object> getBahanToppingFilling(){
        this.setBahanToppingFilling();
        return this.bahanToppingFilling;
    }
}
