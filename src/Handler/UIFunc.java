package Handler;

import Classes.Cetak;
import Classes.Pelanggan;
import Classes.cetakLembaran;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UIFunc {
    /**
     Hanya mencetak garis " ===== "
     */
    public static void line() {
        System.out.println("=====================================================");
    }

    /**
     Menampilkan menu utama. <p>1-Regist;</p><p>2-Cetak</p>
     */
    public static void tampilanUtama(){
        System.out.println("Apa yang ingin anda Lakukan?");
        System.out.println("1. Registrasi Member");
        System.out.println("2. Cetak buku / lembaran");
        System.out.print("Pilihan Anda: ");
    }
    /**
     Menampilkan tampilan awal pada program Percetakan Filkom
     <p>1-Buku;</p>
     2-per Lembar;
     <p>3-Keluar</p>
     */
    public static void tampilanCetak(){
        System.out.println("Mau cetak apa hari ini?");
        System.out.println("1. Buku");
        System.out.println("2. per Lembar");
        System.out.println("3. Kembalik ke Menu Utama");
        System.out.println("4. Keluar");
        System.out.print("Pilihan Anda: ");
    }
    public static void registMember(){
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan nama Anda\t\t: ");
        String nama = in.nextLine();
        //alamat,notelp,email
        System.out.print("Masukkan alamat Anda\t\t: ");
        String alamat = in.nextLine();
        System.out.print("Masukkan nomer telpon Anda\t:");
        String number = in.nextLine();
        System.out.print("Masukkan alamat email Anda\t:");
        String email = in.nextLine();

        Pelanggan p1 = new Pelanggan(nama,alamat,number,email,true);
    }
    public static void cetak(){
        Scanner in = new Scanner(System.in);
        char req;
        int input;
        int lembar;
        do {
            lembar = 0;
            //Tampil menu
            tampilanCetak();
            input = in.nextInt();
            line();
            if (input == 1){
                //will do it later
                System.out.println("SARI ROTI");
            } else if (input == 2) {
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
                Cetak c1 = new Cetak(lembar,jenisBayar);
                cetakLembaran l1 = new cetakLembaran(c1.getJumlahHalaman(),c1.getJenisPembayaran(),kertas);
                System.out.println("Jumlah Harga yang dibayar: "+l1.hargaCetak());
            } else if (input == 3) {
                break;
            } else if (input == 4) {
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