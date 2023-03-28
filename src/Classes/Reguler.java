package Classes;

public class Reguler extends Pelanggan {
    public Reguler(String namaDepan,String namaBelakang ,String alamat, String noTelp, String email, boolean member) {
        super(namaDepan,namaBelakang ,alamat, noTelp, email,member);
    }

    @Override
    public String fullNama(String namaDepan, String namaBelakang) {
        return super.fullNama(namaDepan, namaBelakang);
    }
}
