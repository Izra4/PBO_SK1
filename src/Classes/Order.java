package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int nextNoPesanan = 1;
    private int noPesanan;
    private int biayaCetak;
    private int ongkir;
    private String kecamatan;
    private double diskon;
    private int totalHarga;
    private Status status;
    private boolean checkOut;

    public Order(int biayaCetak,double diskon ,String kecamatan){
        this.biayaCetak = biayaCetak;
        this.kecamatan = kecamatan;
        this.diskon = diskon;
        setOngkir();
        this.noPesanan = nextNoPesanan;
        this.status = Status.BelumBayar;
        nextNoPesanan++;
    }

    public int getNoPesanan() {
        return noPesanan;
    }

    public double getDiskon() {
        return diskon;
    }

    public int getBiayaCetak() {
        return biayaCetak;
    }

    public void setOngkir() {
        switch (kecamatan){
            case "Sukun" -> this.ongkir = 5000;
            case "Wagir" -> this.ongkir = 7000;
            case "Lowokwaru" -> this.ongkir = 8000;
            case "Klojen" -> this.ongkir = 6000;
        }
        setTotalHarga();
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public int getOngkir() {
        return ongkir;
    }
    private void setTotalHarga(){
        this.totalHarga = (int) (biayaCetak + ongkir - diskon);
    }
    public int getTotalHarga() {
        return totalHarga;
    }

    public String getJam(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return time.format(formatter);
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    private enum Status{
        Lunas,
        BelumBayar,
        Dibatalkan;
    }
    public String getStatusString() {
        return switch (status) {
            case Lunas -> "Lunas";
            case BelumBayar -> "Belum dibayar";
            case Dibatalkan -> "Dibatalkan";
            default -> "";
        };
    }

    public boolean checkOut(char pilih) {
        if(pilih == 'y' || pilih == 'Y') {
            return true;
        }else{
            return false;
        }
    }
    public void printDetails(char pilih, Pelanggan pelanggan, String jenisBayar, int halaman, String kertas,int hargaKertas,int uang) {
        if (checkOut(pilih)){
            System.out.println("===============================");
            System.out.println("       STRUK PERCETAKAN        ");
            System.out.println("===============================");
            System.out.println("Nomor Pesanan    : "+getNoPesanan());
            System.out.println("Nama Pelanggan   : " + pelanggan.getFullNama());
            System.out.println("Jenis Pembayaran : " + jenisBayar);
            System.out.println("Tanggal/waktu    : " + getJam());
            System.out.println("------------------------------");
            System.out.println("Jumlah Halaman   : " + halaman);
            System.out.println("Jenis Kertas     : " + kertas);
            System.out.println("Harga Kertas     : Rp. " + hargaKertas);
            System.out.println("Ongkos Kirim     : Rp. "+getOngkir());
            System.out.println("Total Harga      : Rp. " + getTotalHarga());
            System.out.println("------------------------------");
            System.out.println("Jumlah Bayar     : Rp. " + uang);
            System.out.println("===============================");
            System.out.println("Kembalian        : Rp. " + (uang - getTotalHarga()));
            setStatus(Status.Lunas);
            System.out.println("Status Pesanan   : "+getStatusString());
            System.out.println("===============================");
        }else {
            System.out.println("Anda belum checkout!");
        }
    }
    public void printDetails(char pilih, Pelanggan pelanggan, String jenisBayar, int halaman,String jenisJilid,int hargaJilid ,String kertas,int hargaKertas,int uang) {
        if (checkOut(pilih)){
            System.out.println("===============================");
            System.out.println("       STRUK PERCETAKAN        ");
            System.out.println("===============================");
            System.out.println("Nomor Pesanan    : "+getNoPesanan());
            System.out.println("Nama Pelanggan   : " + pelanggan.getFullNama());
            System.out.println("Jenis Pembayaran : " + jenisBayar);
            System.out.println("Tanggal/waktu    : " + getJam());
            System.out.println("------------------------------");
            System.out.println("Jumlah Halaman   : " + halaman);
            System.out.println("Jenis Kertas     : " + kertas);
            System.out.println("Harga Kertas     : Rp. " + hargaKertas);
            System.out.println("Jenis Jilid      : Rp. " + jenisJilid);
            System.out.println("Harga Jilid      : Rp. " + hargaJilid);
            System.out.println("Ongkos Kirim     : Rp. "+getOngkir());
            System.out.println("Total Harga      : Rp. " + getTotalHarga());
            System.out.println("------------------------------");
            System.out.println("Jumlah Bayar     : Rp. " + uang);
            System.out.println("===============================");
            System.out.println("Kembalian        : Rp. " + (uang - getTotalHarga()));
            setStatus(Status.Lunas);
            System.out.println("Status Pesanan   : "+getStatusString());
            System.out.println("===============================");
        }else {
            System.out.println("Anda belum checkout!");
        }
    }
}