package Classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Pelanggan {
    private String namaDepan;
    private String namaBelakang;
    private String alamat;
    private String noTelp;
    private String email;
    private boolean Member;
    private String[] judul;
    private int[] pages;
    private int[] totalBiaya;
    private String[] writer;
    private String[] jenisPaper;
    private String[] tipeJilid;

    public Pelanggan(String namaDepan, String namaBelakang,String alamat, String noTelp, String email, boolean member){
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.Member = member;
    }

    public int[] getPages() {
        return pages;
    }

    public void setPages(int[] pages) {
        this.pages = pages;
    }

    public int[] getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(int[] totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public String[] getWriter() {
        return writer;
    }

    public void setWriter(String[] writer) {
        this.writer = writer;
    }

    public String[] getJenisPaper() {
        return jenisPaper;
    }

    public void setJenisPaper(String[] jenisPaper) {
        this.jenisPaper = jenisPaper;
    }

    public String[] getTipeJilid() {
        return tipeJilid;
    }

    public void setTipeJilid(String[] tipeJilid) {
        this.tipeJilid = tipeJilid;
    }

    public void setJudul(String[] judul) {
        this.judul = judul;
    }

    public String[] getJudul() {
        return judul;
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
        this.Member = member;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMember() {
        return Member;
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
    public void makeOrder(Scanner in, Pelanggan r1, Member m1) {
        char req;
        String jenisBayar = "";
        int halaman = 0;
        int hargaKertas=0;

        System.out.print("Mau order berapa kali : ");
        int inputOrder = in.nextInt();
        int[] pages = new int[inputOrder];
        int[] totalBiaya = new int[inputOrder];
        String[] judulBuku = new String[inputOrder];
        String[] writer = new String[inputOrder];
        String[] jenisPaper = new String[inputOrder];
        String[] tipeJilid = new String[inputOrder];
        in.nextLine();

        System.out.print("Masukkan jenis pembayaran yang anda suka      : ");
        jenisBayar = in.nextLine();
        System.out.println("Masukkan lokasi pengiriman:\n1. Sukun\n2. Wagir\n3. Lowokwaru\n4. Klojen");
        int kec = in.nextInt();
        String kecamatan = "";
        switch (kec){
            case 1 -> kecamatan = "Sukun";
            case 2 -> kecamatan = "Wagir";
            case 3 -> kecamatan = "Lowokwaru";
            case 4 -> kecamatan = "Klojen";
        }

        Order order = new Order(0, getDiscount(),kecamatan);

        for(int i=0; i<inputOrder; i++) {
            int lembar = 0;
            //Tampil menu
            UIFunc.tampilanCetak();
            int get = in.nextInt();
            in.nextLine();
            UIFunc.line();

            UIFunc.line();
            if (get == 1){
                System.out.print("Masukkan judul buku yang ingin anda cetak: ");
                String judul = in.nextLine();
                judulBuku[i] = judul;
                in.nextLine();
                System.out.print("Masukkan penulis buku yang ingin anda cetak: ");
                String penulis = in.nextLine();
                writer[i] = penulis;
                while (true) {
                    try {
                        System.out.print("Masukkan berapa lembar yang anda ingin cetak: ");
                        lembar = in.nextInt();
                        pages[i] = lembar;
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka");
                        in.nextLine();
                    }
                }
                in.nextLine();
                System.out.println("Masukkan jenis kertas yang dibutuhkan         :\n1.A4\n2.A5\n3.F4 ");
                System.out.print("Pilihan Anda: ");
                int jenisKertas = in.nextInt();
                String kertas = "";
                switch (jenisKertas){
                    case 1 -> kertas = "A4";
                    case 2 -> kertas = "A5";
                    case 3 -> kertas = "F4";
                }
                jenisPaper[i] = kertas;
                System.out.println("Masukkan jenis jilid yang dibutuhkan         :\n1.Spiral\n2.Perfect Binding\n3.Lakban ");
                System.out.print("Pilihan Anda: ");
                int jenisJilid = in.nextInt();
                String jilid = "";
                switch (jenisJilid){
                    case 1 -> jilid = "Spiral";
                    case 2 -> jilid = "Perfect Binding";
                    case 3 -> jilid = "Lakban";
                }
                tipeJilid[i] = jilid;
                UIFunc.line();
                Kertas k1 = new Kertas(kertas);
                Jilid j1 = new Jilid(jilid);
                Cetak c1 = new Cetak(lembar,jenisBayar);
                CetakBuku cb1 = new CetakBuku(c1.getJumlahHalaman(), c1.getJenisPembayaran(),judul,penulis,j1.getJenisJilid(), k1.getJenisKertas(),r1);
//                Order order = new Order(cb1.hargaCetak(), getDiscount(),kecamatan);
                System.out.println("Jumlah Harga yang dibayar: "+(cb1.hargaCetak()+order.getOngkir()));
                totalBiaya[i] = cb1.hargaCetak();
                System.out.print("Masukkan jumlah uang Anda: ");
                c1.setJumlahPembayaran(in.nextInt());
                System.out.println(c1.getJumlahPembayaran());
                if(r1.isMember()){
                    m1.addMember(r1.getAlamat(),r1.getNoTelp(),r1.getEmail(),r1.isMember());
                    m1.earnPoint();
                }
                System.out.println("Point Anda: "+ m1.getPoint());
//                cb1.printStruk(r1,cb1.hargaCetak(),kertas,k1.getHarga(),j1.getHarga(), j1.getJenisJilid(),c1.getJumlahPembayaran());
                System.out.println("Checkout? (y/n): ");
                req = in.next().charAt(0);
                order.printDetails(req,r1, cb1.getJenisPembayaran(), cb1.getJumlahHalaman(), j1.getJenisJilid(), j1.getHarga(),kertas,k1.getHarga(), c1.getJumlahPembayaran());
            } else if (get == 2) {
                while (true) {
                    try {
                        System.out.print("Masukkan berapa lembar yang anda ingin cetak: ");
                        lembar = in.nextInt();
                        pages[i] = lembar;
                        halaman = lembar;
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka");
                        in.nextLine();
                    }
                }
                in.nextLine();;
                System.out.println("Masukkan jenis kertas yang dibutuhkan         :\n1.A4\n2.A5\n3.F4 ");
                System.out.print("Pilihan Anda: ");
                int jenisKertas = in.nextInt();
                String kertas = "";
                switch (jenisKertas){
                    case 1 -> kertas = "A4";
                    case 2 -> kertas = "A5";
                    case 3 -> kertas = "F4";
                }
                jenisPaper[i] = kertas;
                UIFunc.line();
                Kertas k1 = new Kertas(kertas);
                hargaKertas = k1.getHarga();

                Cetak c1 = new Cetak(lembar,jenisBayar);
                CetakLembaran l1 = new CetakLembaran(c1.getJumlahHalaman(),c1.getJenisPembayaran(),kertas,r1);
//                Order order = new Order(l1.hargaCetak(), getDiscount(),kecamatan);
                totalBiaya[i] = l1.hargaCetak();
                order.setBiayaCetak(l1.hargaCetak());
                if(r1.isMember()){
                    m1.addMember(r1.getAlamat(),r1.getNoTelp(),r1.getEmail(),r1.isMember());
                    m1.earnPoint();
                }
                System.out.println("Point Anda: "+m1.getPoint());
//                l1.printStruk(r1,l1.hargaCetak(),kertas,k1.getHarga(),0,"",c1.getJumlahPembayaran());
//                if(i==inputOrder-1){
//                }
            } else if (get == 3) {
                break;
            } else if (get == 4) {
                System.out.println("Selamat Tinggal");
                System.exit(0);
            } else {
                System.out.println("Pilihan tidak tersedia!");
            }
        }

        setJudul(judulBuku);
        setTotalBiaya(totalBiaya);
        setPages(pages);
        setWriter(writer);
        setJenisPaper(jenisPaper);
        setTipeJilid(tipeJilid);

        System.out.println("Checkout? (y/n): ");
        req = in.next().charAt(0);
        System.out.println("Jumlah yang harus dibayarkan: "+totalPrice());
        System.out.print("Uang Anda                   : ");
        order.setJumlahBayar(in.nextInt());

        order.printDetails(req,r1,jenisBayar,pages(),printJenisPaper(),hargaKertas, order.getJumlahBayar());
    }

    public void printJudul(){
        for (String s : judul) {
            if (s == null) {
                break;
            }
            System.out.println(s);
        }
    }
    public void printWriter() {
        for (String s : writer) {
            if (s == null) {
                break;
            }
            System.out.println(s);
        }
    }

    public String printJenisPaper() {
        String paper = "";
        for (String s : jenisPaper) {
            if (s == null) {
                break;
            }
            paper += s+", ";
        }
        return paper;
    }

    public void printJilid() {
        for (String s : tipeJilid) {
            if (s == null) {
                break;
            }
            System.out.println(s);
        }
    }

    public int pages() {
        int total=0;
        for (int page : pages) {
            total += page;
        }
        return total;
    }

    public int totalPrice(){
        int total=0;
        for (int j : totalBiaya) {
            total += j;
        }
        return total;
    }
}