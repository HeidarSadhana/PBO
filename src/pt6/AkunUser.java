package pt6;

import java.util.ArrayList;

public class AkunUser implements ResepFavorit {
    private String username;
    private String password;
    private ArrayList<ResepMakanan> resepFavorit;

    public AkunUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.resepFavorit = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void tambahResepFavorit(ResepMakanan resep) {
        this.resepFavorit.add(resep);
    }

    @Override
    public void tampilkanResepFavorit() {
        System.out.println("=========================================");
        System.out.println("Resep Favorit Akun " + username);
        System.out.println("=========================================");
        if (this.resepFavorit.size() == 0) {
            System.out.println("Tidak ada resep favorit.");
        } else {
            int i = 1;
            for (ResepMakanan resep : this.resepFavorit) {
                String nama = resep.getNama();
                if (resep instanceof ResepMakananPedas) {
                    nama = nama + " (Pedas)";
                } else if (resep instanceof ResepMakananSehat) {
                    nama = nama + " (Sehat)";
                }
                System.out.println(i + ". " + nama);
                i += 1;
            }
        }
        System.out.println("=========================================");
    }
}
