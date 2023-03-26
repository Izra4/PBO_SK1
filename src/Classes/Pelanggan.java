package Classes;

public class Pelanggan {
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;
    private boolean member;
//    private static int noAntrian;

    public Pelanggan(String nama, String alamat, String noTelp, String email, boolean member){
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.member = member;
//        noAntrian++;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setMember(boolean member) {
        this.member = member;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMember() {
        return member;
    }


//    public static int getNoAntrian() {
//        return noAntrian;
//    }

    public void registrasi(String nama, String alamat, String noTelp, String email, Boolean member){
        setNama(nama);
        setAlamat(alamat);
        setNoTelp(noTelp);
        setEmail(email);
        setMember(member);
    }

    public double getDiscount(){
        if (isMember()){
            return 0.1;
        }else {
            return 0.0;
        }
    }
}

