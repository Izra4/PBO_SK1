package Classes;

public class Jilid {
    public static final String Spiral = "Spiral";
    public static final String perfectBinding = "Perfect Binding";
    public static final String lakban = "Lakban";
    private final String jenisJilid;
    private final int harga;

    public Jilid(String jenisJilid) {
        this.jenisJilid = jenisJilid;
        switch (jenisJilid) {
            case Spiral -> harga = 10000;
            case perfectBinding -> harga = 15000;
            case lakban -> harga = 5000;
            default -> harga = 0;
        }
    }

    public String getJenisJilid() {
        return jenisJilid;
    }

    public int getHarga() {
        return harga;
    }
}
