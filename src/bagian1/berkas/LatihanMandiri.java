package bagian1.berkas;

import java.io.File;

public class LatihanMandiri {
    public static void main(String[] args) {

        System.out.println("--- Latihan Mandiri No. 1 ---");
        File berkas = new File("laporan.txt");
        
        if (berkas.exists()) {
            System.out.println("Berkas ada, ukuran: " + berkas.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }

        System.out.println("\n--- Latihan Mandiri No. 2 ---");
        File folderBaru = new File("arsip");
        
        if (folderBaru.mkdir()) {
            System.out.println("Berhasil: Folder 'arsip' telah dibuat.");
        } else {
            System.out.println("Gagal: Folder 'arsip' gagal dibuat (mungkin folder sudah ada).");
        }


        System.out.println("\n--- Latihan Mandiri No. 3 ---");
        File fileSementara = new File("sementara.txt");

        try {
            if (fileSementara.createNewFile()) {
                System.out.println("Apakah berkas ada (sebelum dihapus)? " + fileSementara.exists());
                
                if (fileSementara.delete()) {
                    System.out.println("Berkas berhasil dihapus.");
                } else {
                    System.out.println("Berkas gagal dihapus.");
                }
                
                System.out.println("Apakah berkas ada (sesudah dihapus)? " + fileSementara.exists());
            } else {
                System.out.println("Gagal membuat berkas sementara karena berkas sudah ada.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
