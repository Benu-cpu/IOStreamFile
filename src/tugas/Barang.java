package tugas;

public class Barang {
    // Atribut data barang
    private String nama;
    private double harga;
    private int stok;

    // Constructor lengkap
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter untuk masing-masing atribut
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Mengubah objek menjadi sebaris teks dipisah ';' untuk disimpan ke file berkas
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    // Menampilkan informasi detail keterangan barang
    public String info() {
        return nama + " - Harga: Rp" + harga + " | Stok: " + stok;
    }
}
