package pt6;

import java.util.ArrayList;

public abstract class ResepMakanan {
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

    protected abstract void tampilkanResep();
}
