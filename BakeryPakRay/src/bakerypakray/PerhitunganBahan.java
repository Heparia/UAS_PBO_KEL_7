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
    VarianDuaRotiManis v2RM = new VarianDuaRotiManis();
    VarianTigaRotiManis v3RM = new VarianTigaRotiManis();
    VarianSatuRotiTawar v1RT = new VarianSatuRotiTawar();
    VarianDuaRotiTawar v2RT = new VarianDuaRotiTawar();
    VarianSatuPizza v1P = new VarianSatuPizza();
    
    String[][][] dataBahan = new String[v1RM.adonan.getJumlahBahan() + v1RM.topFill.getJumlahBahan()][][];
    
    public PerhitunganBahan(String[] orderan){
        this.nama = orderan[0];
        this.varian = Integer.parseInt(orderan[1]);
        this.jumlah = Integer.parseInt(orderan[2]);
    }
    
    public void displayCheck(){
//        for(int i = 0; i < this.dataBahan[0].length; i ++){
//            System.out.println("Nama: "+this.dataBahan[0][i][0]);
//            System.out.println("Berat: "+this.dataBahan[0][i][1]);
//        }
//        for(int i = 0; i < this.dataBahan[1].length; i ++){
//            System.out.println("Nama: "+this.dataBahan[1][i][0]);
//            System.out.println("Berat: "+this.dataBahan[1][i][1]);
//        }
    }
    
    public String[][][] getDataBahan(){
        String[][][] data = new String[v1RM.adonan.getJumlahBahan() + v1RM.topFill.getJumlahBahan()][][];
        String[][] toppings = null;
        String[][] fillings = null;
        switch (nama) {
            case "Roti Manis":
                data[3] = this.getKomposisiRotiManis();
                switch (varian) {
                    case 1:
                        toppings = v1RM.getTopping();
                        fillings = v1RM.getFilling();
                        break;
                    case 2:
                        toppings = v2RM.getTopping();
                        fillings = v2RM.getFilling();
                        break;
                    case 3:
                        toppings = v3RM.getTopping();
                        fillings = v3RM.getFilling();
                        break;
                    default:
                        fillings = new String[0][0];
                        toppings = new String[0][0];
                        break;
                }
                break;
            case "Roti Tawar":
                data[3] = this.getKomposisiRotiTawar();
                switch (varian) {
                    case 1:
                        toppings = v1RT.getTopping();
                        fillings = v1RT.getFilling();
                        break;
                    case 2:
                        toppings = v2RT.getTopping();
                        fillings = v2RT.getFilling();
                        break;
                    default:
                        fillings = new String[0][0];
                        toppings = new String[0][0];
                        break;
                }
                break;
            case "Pizza":
                data[3] = this.getKomposisiPizza();
                switch (varian) {
                    case 1:
                        toppings = v1P.getTopping();
                        fillings = v1P.getFilling();
                        break;
                    default:
                        fillings = new String[0][0];
                        toppings = new String[0][0];
                        break;
                }
                break;
            default:
                data[3] = new String[0][0];
                fillings = new String[0][0];
                toppings = new String[0][0];
                break;
        }
        data[0] = fillings;
        data[1] = toppings;
        return data;
    }
    
    public String[][] getFilling(){
        return this.getDataBahan()[0];
    }
    
    public String[][] getTopping(){
        return this.getDataBahan()[1];
    }

    public String[][] bahanTopFill() {
        String[][] filling = this.getFilling();
        String[][] topping = this.getTopping();
        String[][] topFill = new String[filling.length + topping.length][filling[0].length];

        for (int i = 0; i < filling.length; i++) {
            for (int j = 0; j < filling[i].length; j++) {
                topFill[i][j] = filling[i][j];
            }
        }

        for (int i = filling.length; i < filling.length + topping.length; i++) {
            for (int j = 0; j < topping[i - filling.length].length; j++) {
                topFill[i][j] = topping[i - filling.length][j];
            }
        }

        for (int i = 0; i < topFill.length; i++) {
            for (int j = i + 1; j < topFill.length; j++) {
                if (topFill[i][0] == null ? topFill[j][0] == null : topFill[i][0].equals(topFill[j][0])) {
                    int combinedValue = Integer.parseInt(topFill[i][1]) + Integer.parseInt(topFill[j][1]);
                    topFill[i][1] = String.valueOf(combinedValue);
                    topFill[j][0] = null;
                    topFill[j][1] = null;
                }
            }
        }
        return topFill;
    }
    
    public double getBeratBahanAdonan(int komposisiBerat, int banyakPcs){
        double hasil = (this.jumlah * komposisiBerat)/banyakPcs;
        return hasil;
    }
    
    public String[][] getKomposisiRotiManis(){
        int[] komposisi = v1RM.getKomposisi();
        int banyakPcs = v1RM.hitungJumlahPcs();
        String[] nama = v1RM.adonan.getAllNamaKemasan();
        String[][] data = new String[v1RM.adonan.getJumlahBahan()][2];
        for (int i = 0; i < komposisi.length; i++) {
            data[i][0] = nama[i];
            data[i][1] = String.valueOf(this.getBeratBahanAdonan(komposisi[i], banyakPcs));
        }
        return data;
    }
    
    public String[][] getKomposisiRotiTawar(){
        int[] komposisi = v1RT.getKomposisi();
        int banyakPcs = v1RT.hitungJumlahPcs();
        String[] nama = v1RT.adonan.getAllNamaKemasan();
        String[][] data = new String[v1RT.adonan.getJumlahBahan()][2];
        for (int i = 0; i < komposisi.length; i++) {
            data[i][0] = nama[i];
            data[i][1] = String.valueOf(this.getBeratBahanAdonan(komposisi[i], banyakPcs));
        }
        return data;
    }
    
    public String[][] getKomposisiPizza(){
        int[] komposisi = v1P.getKomposisi();
        int banyakPcs = v1RT.hitungJumlahPcs();
        String[] nama = v1P.adonan.getAllNamaKemasan();
        String[][] data = new String[v1P.adonan.getJumlahBahan()][2];
        for (int i = 0; i < komposisi.length; i++) {
            data[i][0] = nama[i];
            data[i][1] = String.valueOf(this.getBeratBahanAdonan(komposisi[i], banyakPcs));
        }
        return data;
    }
    
    public void setData() {
        this.dataBahan[0] = this.getDataBahan()[3];
        this.dataBahan[1] = this.bahanTopFill();
        
//        if (dataBahan != null) {
//            for (String[][] a : dataBahan) {
//                if (a == null) {
//                    break;
//                }
//                for (int i = 0; i < this.getDataBahan()[3].length; i++) {
//                    if (a[i][0] == null) {
//                            break;
//                        }
//                    else if (a[i][0] != null && a[i][0].equals(this.getDataBahan()[3][i][0])) {
//                        double dataSebelum = Double.parseDouble(a[i][1]);
//                        double dataSesudah = Double.parseDouble(this.getDataBahan()[3][i][1]);
//                        a[i][1] = Double.toString(dataSebelum + dataSesudah);
//                    }
//                }
//            }
//        }
        
        if (dataBahan != null) {
            for (String[][] a : dataBahan) {
                if (a == null) {
                    continue;
                }
                for (String[] b : a) {
                    if (b == null) {
                        continue;
                    }
                    System.out.println("Nama: " + b[0]);
                    System.out.println("Berat: " + b[1]);
                }
            }
        }
    }

}
