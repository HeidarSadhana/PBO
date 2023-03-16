package pt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ResepMakanan {
    private String nama;
    private ArrayList<String> bahan;
    private ArrayList<String> langkah;

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

public class posttest1 {
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
                System.out.println((i + 1) + ". " + daftarResep.get(i).getNama());
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
            scanner.nextLine(); kembali();
        }
    }

    public static ResepMakanan inputResep(String aksi){
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
        return new ResepMakanan(nama, bahan, langkah);
    }

    public static void tambah() {
        ResepMakanan resepBaru = inputResep("tambah");
        daftarResep.add(resepBaru);
        System.out.println("=========================================");
        System.out.println("Resep Berhasil Ditambahkan!");
    }

    private static void ubah() {
        int urutan = tampil("ubah");
        if (urutan > daftarResep.size()) {
            System.out.println("Resep tidak ditemukan!");
            return;
        } else if (urutan == 0){
            return;
        }
        scanner.nextLine();
        ResepMakanan resepBaru = inputResep("ubah");
        daftarResep.set(urutan - 1, resepBaru);
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

