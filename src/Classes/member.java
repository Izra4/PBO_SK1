package Classes;

public class member extends Pelanggan {
    private int point;

    public member(String nama, String alamat, String noTelp, String email, boolean member) {
        super(nama, alamat, noTelp, email, member);
        point = 0;
    }
    public void addMember(String nama, String alamat, String noTelp, String email, boolean member){
        setNama(nama);
        setAlamat(alamat);
        setNoTelp(noTelp);
        setEmail(email);
        setMember(member);
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
