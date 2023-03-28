package Classes;

public class CetakBuku extends Cetak {
    private String judulBuku;
    private String penulis;
    private String jenisJilid;
    private String jenisKertas;
    private final Pelanggan pelanggan;

    public CetakBuku(int jumlahHalaman, String jenisPembayaran, String judulBuku, String penulis, String jenisJilid, String jenisKertas, Pelanggan pelanggan) {
        super(jumlahHalaman, jenisPembayaran);
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.jenisJilid = jenisJilid;
        this.jenisKertas = jenisKertas;
        this.pelanggan = pelanggan;
    }

    public void setJenisKertas(String jenisKertas) {
        this.jenisKertas = jenisKertas;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getJenisJilid() {
        return jenisJilid;
    }

    public void setJenisJilid(String jenisJilid) {
        this.jenisJilid = jenisJilid;
    }

    public String getJenisKertas() {
        return jenisKertas;
    }

    public int hargaCetak() {
        Kertas kertas = new Kertas(getJenisKertas());
        Jilid jilid = new Jilid(getJenisJilid());
        double diskon = pelanggan.getDiscount();
        double hargaSebelumDiskon = (getJumlahHalaman() * kertas.getHarga()) + jilid.getHarga();
        double hargaSetelahDiskon = hargaSebelumDiskon - (hargaSebelumDiskon * diskon);
        return (int) hargaSetelahDiskon;
    }
    @Override
    public void printStruk(Pelanggan pelanggan, int totalHarga, String jenisKertas, int hargaKertas, int hargaJilid, String jenisJilid,int uang) {
        System.out.println("===============================");
        System.out.println("       STRUK PERCETAKAN        ");
        System.out.println("===============================");
        System.out.println("Nama Pelanggan : " + pelanggan.getFullNama());
        System.out.println("Jenis Pembayaran : " + getJenisPembayaran());
        System.out.println("Tanggal/waktu : " + getJam());
        System.out.println("------------------------------");
        System.out.println("Jumlah Halaman : " + getJumlahHalaman());
        System.out.println("Jenis Kertas : " + jenisKertas);
        System.out.println("Jenis Jilid : " + jenisJilid);
        System.out.println("Harga Kertas : Rp. " + hargaKertas);
        System.out.println("Harga Jilid : Rp. " + hargaJilid);
        System.out.println("Total Harga : Rp. " + totalHarga);
        System.out.println("------------------------------");
        System.out.println("Jumlah Bayar : Rp. " + uang);
        System.out.println("===============================");
        System.out.println("Kembalian : Rp. " + (uang - totalHarga));
        System.out.println("===============================");
    }
}
