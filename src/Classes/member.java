package Classes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class member extends Pelanggan {
    private int point;
    private LocalDate bergabung;

    public member(String namaDepan,String namaBelakang ,String alamat, String noTelp, String email, boolean member) {
        super(namaDepan,namaBelakang ,alamat, noTelp, email,member);
        point = 0;
    }
    public void addMember(String alamat, String noTelp, String email, boolean member){
        fullNama(getNamaDepan(),getNamaBelakang());
        setAlamat(alamat);
        setNoTelp(noTelp);
        setEmail(email);
        setMember(member);
        setBergabung();
    }

    public LocalDate getBergabung() {
        return bergabung;
    }
    public int randomInt(){
        Random rand = new Random();
        return rand.nextInt(5)+1;
    }
    public void setBergabung() {
        LocalDate now = LocalDate.now();
        this.bergabung = now.minusDays(randomInt());
    }

    public Duration getLamaMember() {
        LocalDate hariIni = LocalDate.now();
        return Duration.between(bergabung.atStartOfDay(), hariIni.atStartOfDay());
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void earnPoint() {
        if (super.isMember()) {
            int currentPoint = getPoint();
            setPoint(currentPoint + 10);
        }
    }

    public double getDiscount() {
        double discount = super.getDiscount();
        if (isMember() && getPoint() >= 50) {
            discount += 0.02;
        }
        return discount;
    }
}