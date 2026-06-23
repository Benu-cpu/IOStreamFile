package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    // ArrayList yang menampung objek bertipe Kontak
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;
    
    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah satu kontak ke koleksi
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    // Menampilkan seluruh koleksi beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    // 1. Method cariKontak (SOAL NO 1)
    public void cariKontak(String nama) {
        boolean ditemukan = false;
        for (Kontak k : daftar) {
            // Menggunakan equalsIgnoreCase agar pencarian tidak sensitif huruf besar/kecil
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak Ditemukan: " + k.info());
                ditemukan = true;
                break; // Hentikan loop jika sudah ketemu
            }
        }
        if (!ditemukan) {
            System.out.println("Kontak dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // 3. Method hapusKontak (SOAL NO 3)
    public void hapusKontak(String nama) {
        boolean berhasilHapus = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                berhasilHapus = true;
                System.out.println("Berhasil menghapus kontak: " + nama);
                break;
            }
        }
        
        if (berhasilHapus) {
            simpanKeBerkas(); // Panggil simpan berkas agar perubahan ikut tersimpan permanen
        } else {
            System.out.println("Gagal menghapus: Kontak '" + nama + "' tidak ditemukan.");
        }
    }

    // Menyimpan seluruh kontak ke berkas, satu kontak per baris
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // Membaca kembali kontak dari berkas ke dalam ArrayList (Disesuaikan untuk 3 bagian)
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                // MODIFIKASI SOAL NO 2: Memecah menjadi tiga bagian (nama, nomor, email)
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }
    
    public int jumlahKontak() {
        return daftar.size();
    }
}