package Classes;

public class cetakLembaran extends Cetak {
    private String jenisKertas;
    private Pelanggan pelanggan;


    public cetakLembaran(int jumlahHalaman, String jenisPembayaran, String jenisKertas, Pelanggan pelanggan) {
        super(jumlahHalaman, jenisPembayaran);
        this.jenisKertas = jenisKertas;
        this.pelanggan = pelanggan;
    }

    public String getJenisKertas() {
        return jenisKertas;
    }

    public void setJenisKertas(String jenisKertas) {
        this.jenisKertas = jenisKertas;
    }

    public int hargaCetak() {
        kertas kertas = new kertas(getJenisKertas());
        double diskon = pelanggan.getDiscount(); // call getDiscount() method using pelanggan object
        double hargaSebelumDiskon = getJumlahHalaman() * kertas.getHarga();
        double hargaSetelahDiskon = hargaSebelumDiskon - (hargaSebelumDiskon * diskon);
        return (int)hargaSetelahDiskon;
    }
}
