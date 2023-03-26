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
    public void printStruk(Pelanggan pelanggan, int totalHarga, String jenisKertas, int hargaKertas) {
        System.out.println("===============================");
        System.out.println("       STRUK PERCETAKAN        ");
        System.out.println("===============================");
        System.out.println("Nama Pelanggan : " + pelanggan.getNama());
        System.out.println("Jenis Pembayaran : " + getJenisPembayaran());
        System.out.println("Tanggal/waktu : " + getJam());
        System.out.println("------------------------------");
        System.out.println("Jumlah Halaman : " + getJumlahHalaman());
        System.out.println("Jenis Kertas : " + jenisKertas);
        System.out.println("Harga Kertas : Rp. " + hargaKertas);
        System.out.println("Total Harga : Rp. " + totalHarga);
        System.out.println("------------------------------");
        System.out.println("Jumlah Bayar : Rp. " + getJumlahPembayaran());
        System.out.println("===============================");
        System.out.println("Kembalian : Rp. "+(getJumlahPembayaran()-totalHarga));
        System.out.println("===============================");
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

