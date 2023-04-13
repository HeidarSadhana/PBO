package pt6;

import java.util.ArrayList;

public class ResepMakananPedas extends ResepMakanan{
    public final String jenis = "Makanan Pedas";
    private double tingkatPedas;

    public ResepMakananPedas (String nama, ArrayList<String> bahan, ArrayList<String> langkah, double tingkatPedas){
        super(nama, bahan, langkah);
        this.tingkatPedas = tingkatPedas;
    }

    public String getJenis(){
        return jenis;
    }

    public double getTingkatPedas() {
        return tingkatPedas;
    }

    public void setTingkatPedas(int tingkatPedas) {
        this.tingkatPedas = tingkatPedas;
    }

    public void setTingkatPedas(double tingkatPedas) {
        this.tingkatPedas = tingkatPedas;
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
        System.out.println("Tingkat Pedas: " + getTingkatPedas());
    }
}
