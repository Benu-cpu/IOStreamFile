package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    // Menyimpan koleksi objek bertipe Barang
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambahkan barang baru ke koleksi ArrayList
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Menampilkan seluruh isi koleksi barang di gudang beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Barang di Gudang ==");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang b = daftarBarang.get(i);
            System.out.println((i + 1) + ". " + b.info());
        }
    }

    // Menyimpan seluruh data barang di ArrayList ke file text berkas, satu barang per baris
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
            System.out.println("Data barang berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    // Memuat kembali data dari file berkas ke dalam ArrayList
    public void muatDariBerkas() {
        daftarBarang.clear(); // Bersihkan data lama di memori
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Data barang berhasil dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat dari berkas: " + e.getMessage());
        }
    }

    // Menghitung total nilai dari seluruh barang (harga * stok)
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}
