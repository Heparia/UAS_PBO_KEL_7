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
public final class ToppingFilling implements BahanHarga{
    int[] bahan = new int[2];
    
    public ToppingFilling() {
        setBahanToppingFilling();
    }
    
    ArrayList<Object> bahanToppingFilling = new ArrayList<>();
    private void setBahanToppingFilling(){
        bahanToppingFilling.add(new Object[]{"Keju", 250, 31000});
        bahanToppingFilling.add(new Object[]{"Coklat", 500, 29000});
        bahanToppingFilling.add(new Object[]{"Krim Vanilla", 500, 30000});
        bahanToppingFilling.add(new Object[]{"Selai Red Bean", 500, 25000});
        bahanToppingFilling.add(new Object[]{"Sosis", 1000, 80000});
        bahanToppingFilling.add(new Object[]{"Smocked Beef", 1000, 90000});
        bahanToppingFilling.add(new Object[]{"Bawang Bombay", 500, 40000});
    }

    @Override
    public void getBeratHargaKemasan(String namaBahan) {
        int[] bahan = new int[2];
        for (int i = 0; i < bahanToppingFilling.size(); i++) {
            Object[] objArray = (Object[]) bahanToppingFilling.get(i);
            String nama = (String) objArray[0];
            if (nama.equals(namaBahan)) {
                bahan[0] = (int) objArray[1];
                bahan[1] = (int) objArray[2];
                break;
            }
        }
        this.bahan = bahan;
    }

    @Override
    public int getJumlahBahan() {
        return this.bahanToppingFilling.size();
    }

    @Override
    public int getBeratKemasan() {
        return bahan[0];
    }

    @Override
    public int getHargaBahan() {
        return bahan[1];
    }

    @Override
    public int[] getAllHargaBahan() {
        int[] allHargaKemasan = new int[getJumlahBahan()];
        for (int i = 0; i < bahanToppingFilling.size(); i++) {
            Object[] objArray = (Object[]) bahanToppingFilling.get(i);
            int harga = (int) objArray[2];
            allHargaKemasan[i] = harga;
        }
        return allHargaKemasan;
    }

    @Override
    public int[] getAllBeratKemasan() {
        int[] allBeratKemasan = new int[getJumlahBahan()];
        for (int i = 0; i < bahanToppingFilling.size(); i++) {
            Object[] objArray = (Object[]) bahanToppingFilling.get(i);
            int berat = (int) objArray[1];
            allBeratKemasan[i] = berat;
        }
        return allBeratKemasan;
    }

    @Override
    public String[] getAllNamaKemasan() {
       String[] allNamaKemasan = new String[getJumlahBahan()];
        for (int i = 0; i < bahanToppingFilling.size(); i++) {
            Object[] objArray = (Object[]) bahanToppingFilling.get(i);
            String nama = (String) objArray[0];
            allNamaKemasan[i] = nama;
        }
        return allNamaKemasan;
    }
}
