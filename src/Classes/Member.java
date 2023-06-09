package Classes;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

public class Member extends Pelanggan {
    private LocalDate bergabung;

    public Member(String namaDepan, String namaBelakang, String alamat, String noTelp, String email, boolean member) {
        super(namaDepan, namaBelakang, alamat, noTelp, email, member);
    }

    public void addMember(String alamat, String noTelp, String email, boolean member) {
        fullNama(getNamaDepan(), getNamaBelakang());
        setAlamat(alamat);
        setNoTelp(noTelp);
        setEmail(email);
        setMember(member);
        setBergabung();
    }

    public LocalDate getBergabung() {
        return bergabung;
    }

    public int randomInt() {
        Random rand = new Random();
        return rand.nextInt(5) + 1;
    }

    public void setBergabung() {
        LocalDate now = LocalDate.now();
        this.bergabung = now.minusDays(randomInt());
    }

    public Duration getLamaMember() {
        LocalDate hariIni = LocalDate.now();
        return Duration.between(bergabung.atStartOfDay(), hariIni.atStartOfDay());
    }
}