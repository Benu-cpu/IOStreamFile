import java.io.*;

public class LatihanMandiri {
    public static void main(String[] args) {

        System.out.println("=== NO. 1 ===");
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) {
            for (String h : hari) {
                penulis.println(h);
            }
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }
        
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }

        System.out.println("\n=== NO. 2 ===");
        String[] hariTambahan = {"Sabtu", "Minggu"};
        
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt", true))) {
            for (String h : hariTambahan) {
                penulis.println(h);
            }
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }
        
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }

        System.out.println("\n=== NO. 3 ===");
        int jumlah = 0;
        
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            while (pembaca.readLine() != null) {
                jumlah++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
        System.out.println("Jumlah baris: " + jumlah);
    }
}