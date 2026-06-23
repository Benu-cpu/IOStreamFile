package bagian3.kontak;

public class Kontak {
    // Atribut: data yang dimiliki setiap kontak
    private String nama;
    private String nomor;
    private String email; // TAMBAHAN SOAL NO 2
    
    // Constructor: diperbarui untuk menerima parameter email
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email; // TAMBAHAN SOAL NO 2
    }
    
    // Getter: cara membaca atribut dari luar class
    public String getNama() {
        return nama;
    }
    
    public String getNomor() {
        return nomor;
    }

    public String getEmail() { // TAMBAHAN SOAL NO 2
        return email;
    }
    
    // Mengubah objek menjadi satu baris teks untuk disimpan ke berkas (3 bagian dipisah ';')
    public String keBaris() {
        return nama + ";" + nomor + ";" + email; // MODIFIKASI SOAL NO 2
    }
    
    // Mengembalikan keterangan kontak dalam bentuk teks lengkap
    public String info() {
        return nama + " - " + nomor + " (" + email + ")"; // MODIFIKASI SOAL NO 2
    }
}