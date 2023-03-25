import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cetak {
    private int jumlahHalaman;
    private String jenisPembayaran;

    public Cetak(int jumlahHalaman, String jenisPembayaran) {
        this.jumlahHalaman = jumlahHalaman;
        this.jenisPembayaran = jenisPembayaran;
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

class cetakLembaran extends Cetak{
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

    public int hargaCetak(){
        kertas kertas = new kertas(getJenisKertas());
        return getJumlahHalaman() * kertas.getHarga();
    }


}
class kertas {
    public static final String A4 = "A4";
    public static final String A5 = "A5";
    public static final String F4 = "F4";

    private final String jenisKertas;
    private final int harga;

    public kertas(String jenisKertas) {
        this.jenisKertas = jenisKertas;
        switch (jenisKertas) {
            case A4 -> harga = 500;
            case A5 -> harga = 250;
            case F4 -> harga = 750;
            default -> harga = 0;
        }
    }

    public String getJenisKertas() {
        return jenisKertas;
    }

    public int getHarga() {
        return harga;
    }
}
