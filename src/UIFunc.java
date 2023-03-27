import Classes.Pelanggan;

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
        System.out.println("3. Keluar");
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
        System.out.println("3. Kembali ke Menu Utama");
        System.out.println("4. Keluar");
        System.out.print("Pilihan Anda: ");
    }

    public static Pelanggan registrasiPelanggan(Scanner in, Pelanggan p1) {
        System.out.print("Masukkan nama Anda\t\t: ");
        String nama = in.nextLine();
        System.out.print("Masukkan alamat Anda\t\t: ");
        String alamat = in.nextLine();
        System.out.print("Masukkan nomer telpon Anda\t:");
        String number = in.nextLine();
        System.out.print("Masukkan alamat email Anda\t:");
        String email = in.nextLine();
        return new Pelanggan(nama, alamat, number, email, true);
    }
}