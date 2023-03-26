package Classes;

public class Kertas {
    public static final String A4 = "A4";
    public static final String A5 = "A5";
    public static final String F4 = "F4";

    private final String jenisKertas;
    private final int harga;

    public Kertas(String jenisKertas) {
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
