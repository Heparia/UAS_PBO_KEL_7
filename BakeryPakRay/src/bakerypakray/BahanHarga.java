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
public interface BahanHarga {
    public abstract void getBeratHargaKemasan(String namaBahan);
    public abstract int getJumlahBahan();
    public abstract int getBeratKemasan();
    public abstract int getHargaBahan();
    public abstract int[] getAllBeratKemasan();
    public abstract int[] getAllHargaBahan();
    public abstract String[] getAllNamaKemasan();
}
