package Classes;

public class CetakLembaran extends Cetak {
    private String jenisKertas;
    private final Pelanggan pelanggan;


    public CetakLembaran(int jumlahHalaman, String jenisPembayaran, String jenisKertas, Pelanggan pelanggan) {
        super(jumlahHalaman, jenisPembayaran);
        this.jenisKertas = jenisKertas;
        this.pelanggan = pelanggan;
    }


    public String getJenisKertas() {
        return jenisKertas;
    }

    public int hargaCetak() {
        Kertas kertas = new Kertas(getJenisKertas());
        double diskon = pelanggan.getDiscount(); // call getDiscount() method using pelanggan object
        double hargaSebelumDiskon = getJumlahHalaman() * kertas.getHarga();
        double hargaSetelahDiskon = hargaSebelumDiskon - (hargaSebelumDiskon * diskon);
        return (int) hargaSetelahDiskon;
    }
    @Override
    public void printStruk(Pelanggan pelanggan, int totalHarga, String jenisKertas, int hargaKertas, int hargaJilid, String jenisJilid, int uang) {
        System.out.println("===============================");
        System.out.println("       STRUK PERCETAKAN        ");
        System.out.println("===============================");
        System.out.println("Nama Pelanggan : " + pelanggan.getFullNama());
        System.out.println("Jenis Pembayaran : " + getJenisPembayaran());
        System.out.println("Tanggal/waktu : " + getJam());
        System.out.println("------------------------------");
        System.out.println("Jumlah Halaman : " + getJumlahHalaman());
        System.out.println("Jenis Kertas : " + jenisKertas);
        System.out.println("Harga Kertas : Rp. " + hargaKertas);
        System.out.println("Total Harga : Rp. " + totalHarga);
        System.out.println("------------------------------");
        System.out.println("Jumlah Bayar : Rp. " + uang);
        System.out.println("===============================");
        System.out.println("Kembalian : Rp. " + (uang - totalHarga));
        System.out.println("===============================");
    }
}