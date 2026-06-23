package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // Membuat objek pengelola dan mengisinya dengan email (SOAL NO 2)
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        
        System.out.println("\n=== PENGUJIAN SOAL 1 (Cari Kontak) ===");
        buku.cariKontak("Budi"); // Uji jika ada
        buku.cariKontak("Dedi"); // Uji jika tidak ada
        
        System.out.println("\n=== PENGUJIAN SOAL 3 (Hapus Kontak) ===");
        buku.hapusKontak("Andi"); // Menghapus Andi dan otomatis simpan ke berkas
        
        System.out.println("\n=== PEMBUKTIAN DARI FILE BERKAS ===");
        // Objek baru yang kosong, lalu memuat kembali dari berkas pasca penghapusan
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak akhir: " + bukuLain.jumlahKontak());
    }
}