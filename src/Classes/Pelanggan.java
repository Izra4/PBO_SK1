package Classes;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    public double getDiscount(){
        if (isMember()){
            return 0.1;
        }else {
            return 0.0;
        }
    }
    public void makeOrder(Scanner in, Pelanggan r1, member m1) {
        char req;
        do {
            int lembar = 0;
            //Tampil menu
            UIFunc.tampilanCetak();
            int get = in.nextInt();
            UIFunc.line();
            if (get == 1){
                System.out.print("Masukkan judul buku yang ingin anda cetak: ");
                String judulBuku = in.nextLine();
                in.nextLine();
                System.out.print("Masukkan penulis buku yang ingin anda cetak: ");
                String penulis = in.nextLine();
                while (true) {
                    try {
                        System.out.print("Masukkan berapa lembar yang anda ingin cetak: ");
                        lembar = in.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka");
                        in.nextLine();
                    }
                }
                in.nextLine();
                System.out.print("Masukkan jenis pembayaran yang anda suka      : ");
                String jenisBayar = in.nextLine();
                System.out.println("Masukkan jenis kertas yang dibutuhkan         :\n1.A4\n2.A5\n3.F4 ");
                System.out.print("Pilihan Anda: ");
                int jenisKertas = in.nextInt();
                String kertas = "";
                switch (jenisKertas){
                    case 1 -> kertas = "A4";
                    case 2 -> kertas = "A5";
                    case 3 -> kertas = "F4";
                }

                System.out.println("Masukkan jenis jilid yang dibutuhkan         :\n1.Spiral\n2.Perfect Binding\n3.Lakban ");
                System.out.print("Pilihan Anda: ");
                int jenisJilid = in.nextInt();
                String jilid = "";
                switch (jenisJilid){
                    case 1 -> jilid = "Spiral";
                    case 2 -> jilid = "Perfect Binding";
                    case 3 -> jilid = "Lakban";
                }

                UIFunc.line();
                Kertas k1 = new Kertas(kertas);
                Jilid j1 = new Jilid(jilid);
                Cetak c1 = new Cetak(lembar,jenisBayar);
                CetakBuku cb1 = new CetakBuku(c1.getJumlahHalaman(), c1.getJenisPembayaran(),judulBuku,penulis,j1.getJenisJilid(), k1.getJenisKertas(),r1);
                System.out.println("Jumlah Harga yang dibayar: "+cb1.hargaCetak());
                System.out.print("Masukkan jumlah uang Anda: ");
                c1.setJumlahPembayaran(in.nextInt());
                System.out.println(c1.getJumlahPembayaran());
                if(r1.isMember()){
                    m1.addMember(r1.getAlamat(),r1.getNoTelp(),r1.getEmail(),r1.isMember());
                    m1.earnPoint();
                }
                System.out.println("Point Anda: "+m1.getPoint());
                cb1.printStruk(r1,cb1.hargaCetak(),kertas,k1.getHarga(),j1.getHarga(), j1.getJenisJilid(),c1.getJumlahPembayaran());


            } else if (get == 2) {
                while (true) {
                    try {
                        System.out.print("Masukkan berapa lembar yang anda ingin cetak: ");
                        lembar = in.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka");
                        in.nextLine();
                    }
                }
                in.nextLine();
                System.out.print("Masukkan jenis pembayaran yang anda suka      : ");
                String jenisBayar = in.nextLine();
                System.out.println("Masukkan jenis kertas yang dibutuhkan         :\n1.A4\n2.A5\n3.F4 ");
                System.out.print("Pilihan Anda: ");
                int jenisKertas = in.nextInt();
                String kertas = "";
                switch (jenisKertas){
                    case 1 -> kertas = "A4";
                    case 2 -> kertas = "A5";
                    case 3 -> kertas = "F4";
                }

                UIFunc.line();
                Kertas k1 = new Kertas(kertas);
                Cetak c1 = new Cetak(lembar,jenisBayar);
                CetakLembaran l1 = new CetakLembaran(c1.getJumlahHalaman(),c1.getJenisPembayaran(),kertas,r1);
                System.out.println("Jumlah Harga yang dibayar: "+l1.hargaCetak());
                System.out.print("Masukkan jumlah uang Anda: ");
                c1.setJumlahPembayaran(in.nextInt());
                if(r1.isMember()){
                    m1.addMember(r1.getAlamat(),r1.getNoTelp(),r1.getEmail(),r1.isMember());
                    m1.earnPoint();
                }
                System.out.println("Point Anda: "+m1.getPoint());
                l1.printStruk(r1,l1.hargaCetak(),kertas,k1.getHarga(),0,"",c1.getJumlahPembayaran());
            } else if (get == 3) {
                break;
            } else if (get == 4) {
                System.out.println("Selamat Tinggal");
                System.exit(0);
            } else {
                System.out.println("Pilihan tidak tersedia!");
            }
            System.out.print("Apakah ada transaksi lain? (y/n): ");
            req = in.next().charAt(0);
            UIFunc.line();
        }while (req != 'n');
    }
}
