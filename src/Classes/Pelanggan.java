package Classes;

public abstract class Pelanggan {
    private String namaDepan;
    private String namaBelakang;
    private String alamat;
    private String noTelp;
    private String email;
    private boolean member;

    public Pelanggan(String namaDepan, String namaBelakang,String alamat, String noTelp, String email, boolean member){
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.member = member;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
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

    public String fullNama(String namaDepan,String namaBelakang) {
        return namaDepan + " " + namaBelakang;
    }
    public String getFullNama() {
        return fullNama(getNamaDepan(),getNamaBelakang());
    }

    public void registrasi(String namaDepan,String namaBelakang ,String alamat, String noTelp, String email, Boolean member){
        fullNama(namaDepan,namaBelakang);
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
