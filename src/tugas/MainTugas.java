// Nama : M. Ibnu
// NPM  : 2410010254

package tugas;

public class MainTugas {
    public static void main(String[] args) {
        // 1. Menyimpan daftar kategori dalam array String ukuran tetap (Minimal 3) dan menampirkannya
        String[] kategori = {"Elektronik", "Pakaian", "Makanan", "Alat Tulis"};
        
        System.out.println("== Kategori Barang Toko ==");
        for (String kat : kategori) {
            System.out.println("- " + kat);
        }
        System.out.println();

        // 2. Membuat objek Gudang dan menambahkan minimal 5 objek Barang
        Gudang gudangUtama = new Gudang("barang.txt");
        gudangUtama.tambahBarang(new Barang("Laptop Asus", 8500000, 10));
        gudangUtama.tambahBarang(new Barang("Mouse Wireless", 150000, 25));
        gudangUtama.tambahBarang(new Barang("Kemeja Flanel", 175000, 40));
        gudangUtama.tambahBarang(new Barang("Kopi Kemasan", 45000, 100));
        gudangUtama.tambahBarang(new Barang("Buku Catatan A5", 25000, 50));

        // Menampilkan data dan menyimpannya ke berkas teks
        gudangUtama.tampilkanSemua();
        gudangUtama.simpanKeBerkas();
        
        System.out.println("\n--------------------------------------------------\n");

        // 3. Membuat objek Gudang baru untuk membuktikan data tersimpan secara permanen
        System.out.println("Membuka objek Gudang baru (gudangArsip)...");
        Gudang gudangArsip = new Gudang("barang.txt");
        
        // Memuat kembali data dari berkas teks
        gudangArsip.muatDariBerkas();
        
        // Menampilkan data dari objek baru
        gudangArsip.tampilkanSemua();
        
        // Menampilkan total nilai persediaan keseluruhan barang
        System.out.println("Total Nilai Persediaan Barang: Rp" + gudangArsip.totalNilai());
    }
}
