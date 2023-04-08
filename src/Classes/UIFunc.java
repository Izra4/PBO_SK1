package Classes;

import Classes.Pelanggan;
import Classes.Reguler;
//import Classes.cetakLembaran;

//import java.util.InputMismatchException;
import java.util.Scanner;

public class UIFunc {
    /**
     Hanya mencetak garis " ===== "
     */
    public static void line() {
        System.out.println("=====================================================");
    }
    public static Reguler biodata(Scanner in,Pelanggan r1) {
        System.out.println("Silahkan isi biodata dibawah ini");
        System.out.print("Masukkan nama depan anda : ");
        String namaDepan = in.nextLine();
        System.out.print("Masukkan nama belakang anda : ");
        String namaBelakang = in.nextLine();
        return new Reguler(namaDepan,namaBelakang,"","","",false);
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

    public static Reguler registrasiPelanggan(Scanner in, Reguler r1) {
        System.out.print("Masukkan alamat Anda\t\t : ");
        String alamat = in.nextLine();
        System.out.print("Masukkan nomer telpon Anda\t : ");
        String number = in.nextLine();
        System.out.print("Masukkan alamat email Anda\t : ");
        String email = in.nextLine();
        String namaDepan = r1.getNamaDepan();
        String namaBelakang = r1.getNamaBelakang();
        return new Reguler(namaDepan,namaBelakang,alamat, number, email, true);
    }
}