import Classes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pelanggan p1 = new Pelanggan("","","","",false);
        member m1 = new member(p1.getNama(),p1.getAlamat(),p1.getNoTelp(),p1.getEmail(),p1.isMember());
        int input,lembar;
        char req;
        System.out.println("======== Selamat Datang di Percetakan Filkom ========");
        do {
            UIFunc.tampilanUtama();
            input = in.nextInt();
            in.nextLine();
            UIFunc.line();
            if (input == 1){
                p1 = UIFunc.registrasiPelanggan(in, p1);
            } else if (input == 2) {
                do {
                    lembar = 0;
                    //Tampil menu
                    UIFunc.tampilanCetak();
                    int get = in.nextInt();
                    UIFunc.line();
                    if (get == 1){
                        //will do it later
                        System.out.println("SARI ROTI");
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
                        CetakLembaran l1 = new CetakLembaran(c1.getJumlahHalaman(),c1.getJenisPembayaran(),kertas,p1);
                        System.out.println("Jumlah Harga yang dibayar: "+l1.hargaCetak());
                        System.out.print("Masukkan jumlah uang Anda: ");
                        c1.setJumlahPembayaran(in.nextInt());
                        if(p1.isMember()){
                            m1.addMember(p1.getNama(),p1.getAlamat(),p1.getNoTelp(),p1.getEmail(),p1.isMember());
                            m1.earnPoint();
                        }
                        System.out.println("Point Anda: "+m1.getPoint());
                        c1.printStruk(p1,l1.hargaCetak(),kertas,k1.getHarga());
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
        }while (input != 3);
    }
}
