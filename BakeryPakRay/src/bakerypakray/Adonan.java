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
public class Adonan implements BahanHarga{
    int[] bahan = new int[2];
    int[] allBeratKemasan = new int[this.getJumlahBahan()];
    
    ArrayList<Object> bahanAdonan = new ArrayList<>();
    public void setBahanAdonan(){
        bahanAdonan.add(new Object[]{"Tepung Terigu", 1000, 40000});
        bahanAdonan.add(new Object[]{"Gula Pasir", 1000, 25000});
        bahanAdonan.add(new Object[]{"Butter", 500, 23000});
        bahanAdonan.add(new Object[]{"Ragi", 11, 5000});
        bahanAdonan.add(new Object[]{"Susu Bubuk", 1000, 39000});
        bahanAdonan.add(new Object[]{"Susu Cair", 1000, 24000});
        bahanAdonan.add(new Object[]{"Telur", 1000, 23000});
        bahanAdonan.add(new Object[]{"Es Batu", 1000, 2000});
        System.out.println("Berhasil menambahkan bahan-bahan adonan");
    }
    
    public ArrayList<Object> getBahanAdonan(){
        this.setBahanAdonan();
        return this.bahanAdonan;
    }

    @Override
    public int getJumlahBahan() {
        this.setBahanAdonan();
        return this.bahanAdonan.size();
    }

    @Override
    public void getBeratHargaKemasan(String namaBahan) {
        for (int i = 0; i < this.getBahanAdonan().size(); i++) {
            Object[] objArray = (Object[]) this.getBahanAdonan().get(i);
            String nama = (String) objArray[0];
            if (nama.equals(namaBahan)) {
                bahan[0] = (int) objArray[1];
                bahan[1] = (int) objArray[2];
                break;
            }
        }
    }
    
    @Override
    public int getBeratKemasan(){
        return bahan[0];
    };
    
    @Override
    public int getHargaBahan() {
        return bahan[1];
    }


    @Override
    public int[] getAllHargaBahan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    @Override
    public int[] getAllBeratKemasan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}