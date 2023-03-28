package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int nextNoPesanan = 1;
    private int noPesanan;
    private int biayaCetak;
    private int ongkir;
    private String kecamatan;
    private int diskon;
    private int totalHarga;
    private Status status;
    private boolean checkOut;

    public Order(int biayaCetak,int diskon ,String kecamatan){
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

    public void setBiayaCetak(int biayaCetak) {
        this.biayaCetak = biayaCetak;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
    }

    public int getDiskon() {
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
        this.totalHarga = biayaCetak + ongkir - diskon;
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
    public void checkOut() {

    }
}