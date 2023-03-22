package pt3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ResepMakanan {
    protected String nama;
    protected ArrayList<String> bahan;
    protected ArrayList<String> langkah;

    public ResepMakanan(String nama, ArrayList<String> bahan, ArrayList<String> langkah) {
        this.nama = nama;
        this.bahan = bahan;
        this.langkah = langkah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<String> getBahan() {
        return bahan;
    }

    public void setBahan(ArrayList<String> bahan) {
        this.bahan = bahan;
    }

    public ArrayList<String> getLangkah() {
        return langkah;
    }

    public void setLangkah(ArrayList<String> langkah) {
        this.langkah = langkah;
    }
}

class ResepMakananPedas extends ResepMakanan{
    private int tingkatPedas;

    public ResepMakananPedas (String nama, ArrayList<String> bahan, ArrayList<String> langkah, int tingkatPedas){
        super(nama, bahan, langkah);
        this.tingkatPedas = tingkatPedas;
    }

    public int getTingkatPedas() {
        return tingkatPedas;
    }

    public void setTingkatPedas(int tingkatPedas) {
        this.tingkatPedas = tingkatPedas;
    }
}

class ResepMakananSehat extends ResepMakanan{
    private int kalori;

    public ResepMakananSehat(String nama, ArrayList<String> bahan, ArrayList<String> langkah, int kalori) {
        super(nama, bahan, langkah);
        this.kalori = kalori;
    }

    public int getKalori() {
        return kalori;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
    }
}

public class posttest3 {
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<ResepMakanan> daftarResep = new ArrayList<ResepMakanan>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jalan = true;
        while (jalan) {
            System.out.println("=========================================");
            System.out.println("1. Tambah Resep");
            System.out.println("2. Lihat Resep");
            System.out.println("3. Ubah Resep");
            System.out.println("4. Hapus Resep");
            System.out.println("5. Keluar");
            System.out.println("=========================================");
            System.out.print("Masukkan pilihan menu: ");
            int pilihanMenu = scanner.nextInt();

            switch (pilihanMenu) {
                case 1:
                    tambah(); kembali(); break;
                case 2:
                    tampilResep(); break;
                case 3:
                    ubah(); break;
                case 4:
                    hapus(); break;
                case 5:
                    jalan = false; break;
            }
        }
    }

    public static void kembali(){
        System.out.println("=========================================");
        System.out.println("Tekan enter untuk kembali...");
        System.out.println("=========================================");
        scanner.nextLine();
    }

    public static int tampil(String aksi) {
        if (daftarResep.size() == 0) {
            System.out.println("=========================================");
            System.out.println("Daftar Resep masih kosong.");
            kembali(); return 0;
        } else {
            System.out.println("=========================================");
            System.out.println("Daftar Resep ");
            System.out.println("=========================================");
            for (int i = 0; i < daftarResep.size(); i++) {
                ResepMakanan resep = daftarResep.get(i);
                String nama = resep.getNama();
                if (resep instanceof ResepMakananPedas){
                    nama = nama + " (Pedas)";
                } else if (resep instanceof ResepMakananSehat){
                    nama = nama + " (Sehat)";
                }
                System.out.println((i + 1) + ". " + nama);
            }
            System.out.println("0. Kembali");
            System.out.println("=========================================");
            System.out.print("Masukkan urutan resep untuk di" + aksi + ": ");
            int urutan = scanner.nextInt();
            System.out.println("=========================================");
            return urutan;
        }
    }

    public static void tampilResep() {
        int urutan = tampil("lihat");
        if (urutan > daftarResep.size()) {
            System.out.println("Resep tidak ditemukan!");
            scanner.nextLine(); kembali();
        } else if (urutan == 0){
            return;
        } else {
            ResepMakanan resep = daftarResep.get(urutan - 1);
            System.out.println("Nama resep: " + resep.getNama());
            System.out.println("Bahan-bahan: " + String.join(", ", resep.getBahan()));
            System.out.println("Langkah-langkah: ");
            for (int i = 0; i < resep.getLangkah().size(); i++) {
                System.out.println((i + 1) + ". " + resep.getLangkah().get(i));
            }
            if (resep instanceof ResepMakananPedas){
                System.out.println("Tingkat Pedas: " + ((ResepMakananPedas) resep).getTingkatPedas());
            } else if (resep instanceof  ResepMakananSehat){
                System.out.println("Kalori: " + ((ResepMakananSehat) resep).getKalori());
            }
            scanner.nextLine(); kembali();
        }
    }

    public static int pilihResep(){
        System.out.println("=========================================");
        System.out.println("Pilih Jenis Resep");
        System.out.println("=========================================");
        System.out.println("1. Resep Makanan Biasa");
        System.out.println("2. Resep Makanan Pedas");
        System.out.println("3. Resep Makanan Sehat");
        System.out.println("4. Kembali");
        System.out.println("=========================================");
        System.out.print("Masukkan pilihan menu: ");
        int pilihanMenu = scanner.nextInt();
        return pilihanMenu;
    }

    public static ResepMakanan inputResep(String aksi, int jenis){
        System.out.println("Masukkan data resep untuk di" + aksi);
        System.out.println("=========================================");
        System.out.print("Nama Resep: ");
        String nama = scanner.nextLine();

        System.out.println("Bahan-bahan (pisahkan dengan koma): ");
        String bahanResep = scanner.nextLine();
        String[] bahanArray = bahanResep.split(",");
        ArrayList<String> bahan = new ArrayList<String>(Arrays.asList(bahanArray));

        ArrayList<String> langkah = new ArrayList<String>();
        System.out.println("Langkah-langkah (ketik '.' untuk berhenti): ");
        String langkahResep = "";

        while (!langkahResep.equals(".")) {
            langkahResep = scanner.nextLine();
            if (!langkahResep.equals(".")) {
                langkah.add(langkahResep);
            }
        }

        switch (jenis){
            case 1:
                break;
            case 2:
                System.out.print("Tingkat Pedas: ");
                int tingkat = scanner.nextInt();
                return new ResepMakananPedas(nama, bahan, langkah, tingkat);
            case 3:
                System.out.print("Kalori: ");
                int kalori = scanner.nextInt();
                return new ResepMakananSehat(nama, bahan, langkah, kalori);
        }
        return new ResepMakanan(nama, bahan, langkah);
    }

    public static void tambah() {
        int jenisResep = pilihResep();
        if (jenisResep == 4){
            scanner.nextLine();
            return;
        } else {
            scanner.nextLine();
            ResepMakanan resepBaru = inputResep("tambah", jenisResep);
            daftarResep.add(resepBaru);
            System.out.println("=========================================");
            System.out.println("Resep Berhasil Ditambahkan!");
        }
    }

    private static void ubah() {
        int urutan = tampil("ubah");
        if (urutan > daftarResep.size()) {
            System.out.println("Resep tidak ditemukan!");
            return;
        } else if (urutan == 0){
            return;
        }

        int jenis = pilihResep(); scanner.nextLine();

        if (jenis == 4){
            ubah(); return;
        } else {
            ResepMakanan resepBaru = inputResep("ubah", jenis);
            daftarResep.set(urutan - 1, resepBaru);
        }
        System.out.println("Resep berhasil diubah!");
    }

    private static void hapus() {
        int urutan = tampil("hapus");
        if (urutan > daftarResep.size()) {
            System.out.println("Resep tidak ditemukan!");
            return;
        } else if (urutan == 0){
            return;
        }
        daftarResep.remove(urutan - 1);
        System.out.println("Resep berhasil dihapus!");
    }
}