import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ini rico");
        int input,lembar;
        char req;
        System.out.println("======== Selamat Datang di Percetakan Filkom ========");
        do {
            //Menu Pilihan
            lembar = 0;
            UIFunc.tampilan();
            input = in.nextInt();
            UIFunc.line();
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
                System.out.println("Selamat Tinggal");
                System.exit(0);
            }
            System.out.print("Apakah ada transaksi lain? (y/n): ");
            req = in.next().charAt(0);
            UIFunc.line();
        }while (req != 'n');
        System.out.println("Selamat Tinggal");
        System.exit(0);
    }
}
