package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cetak {
    private int jumlahHalaman;
    private String jenisPembayaran;
    private int jumlahPembayaran;

    public Cetak(int jumlahHalaman, String jenisPembayaran) {
        this.jumlahHalaman = jumlahHalaman;
        this.jenisPembayaran = jenisPembayaran;
    }
    public int getJumlahPembayaran() {
        return jumlahPembayaran;
    }

    public void setJumlahPembayaran(int jumlahPembayaran) {
        this.jumlahPembayaran = jumlahPembayaran;
    }
    public void printStruk(Pelanggan pelanggan, int totalHarga, String jenisKertas, int hargaKertas, int hargaJilid, String jenisJilid, int uang) {

    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }
    public String getJenisPembayaran() {
        return jenisPembayaran;
    }
    public String getJam(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return time.format(formatter);
    }
}