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
public final class Adonan implements BahanHarga{
    int[] bahan = new int[2];
    
    ArrayList<Object> bahanAdonan = new ArrayList<>();

    public Adonan() {
        setBahanAdonan();
    }

    private void setBahanAdonan() {
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

    @Override
    public int getJumlahBahan() {
        return bahanAdonan.size();
    }

    @Override
    public void getBeratHargaKemasan(String namaBahan) {
        int[] bahan = new int[2];
        for (int i = 0; i < bahanAdonan.size(); i++) {
            Object[] objArray = (Object[]) bahanAdonan.get(i);
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
        for (int i = 0; i < bahanAdonan.size(); i++) {
            Object[] objArray = (Object[]) bahanAdonan.get(i);
            int harga = (int) objArray[2];
            allHargaKemasan[i] = harga;
        }
        return allHargaKemasan;
    }

    @Override
    public int[] getAllBeratKemasan() {
        int[] allBeratKemasan = new int[getJumlahBahan()];
        for (int i = 0; i < bahanAdonan.size(); i++) {
            Object[] objArray = (Object[]) bahanAdonan.get(i);
            int berat = (int) objArray[1];
            allBeratKemasan[i] = berat;
        }
        return allBeratKemasan;
    }

    @Override
    public String[] getAllNamaKemasan() {
        String[] allNamaKemasan = new String[getJumlahBahan()];
        for (int i = 0; i < bahanAdonan.size(); i++) {
            Object[] objArray = (Object[]) bahanAdonan.get(i);
            String nama = (String) objArray[0];
            allNamaKemasan[i] = nama;
        }
        return allNamaKemasan;
    }
}