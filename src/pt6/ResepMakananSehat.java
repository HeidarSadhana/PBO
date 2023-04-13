package pt6;

import java.util.ArrayList;

public class ResepMakananSehat extends ResepMakanan{
    public final String jenis = "Makanan Sehat";
    private double kalori;

    public ResepMakananSehat(String nama, ArrayList<String> bahan, ArrayList<String> langkah, double kalori) {
        super(nama, bahan, langkah);
        this.kalori = kalori;
    }

    public String getJenis(){
        return jenis;
    }

    public double getKalori() {
        return kalori;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
    }

    public void setKalori(double kalori) {
        this.kalori = kalori;
    }

    @Override
    public void tampilkanResep() {
        System.out.println("Jenis resep: Resep" + getJenis());
        System.out.println("Nama resep: " + getNama());
        System.out.println("Bahan-bahan: " + String.join(", ", getBahan()));
        System.out.println("Langkah-langkah: ");
        for (int i = 0; i < getLangkah().size(); i++) {
            System.out.println((i + 1) + ". " + getLangkah().get(i));
        }
        System.out.println("Kalori: " + getKalori());
    }
}
