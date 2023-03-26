package Classes;

public class cetakLembaran extends Cetak {
    private String jenisKertas;


    public cetakLembaran(int jumlahHalaman, String jenisPembayaran, String jenisKertas) {
        super(jumlahHalaman, jenisPembayaran);
        this.jenisKertas = jenisKertas;
    }

    public String getJenisKertas() {
        return jenisKertas;
    }

    public void setJenisKertas(String jenisKertas) {
        this.jenisKertas = jenisKertas;
    }

    public int hargaCetak() {
        kertas kertas = new kertas(getJenisKertas());
        return getJumlahHalaman() * kertas.getHarga();
    }
}
