import Classes.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Reguler r1 = new Reguler("","","","","",false);
        Member m1 = new Member(r1.getNamaDepan(), r1.getNamaBelakang(), r1.getAlamat(),r1.getNoTelp(),r1.getEmail(),r1.isMember());
        PotongHarga ph1 = new PotongHarga();
        PotongOngkir po1 = new PotongOngkir();
        CashBack b1 = new CashBack();

        int input,lembar;
        char req;
        boolean isEmpty = true;
        System.out.println("======== Selamat Datang di Cetak Filkom ========");
        do {
            if (isEmpty) {
                System.out.println("Isi biodata dibawah ini");
                System.out.print("Masukkan nama depan anda : ");
                r1.setNamaDepan(in.nextLine());
                System.out.print("Masukkan nama belakang anda : ");
                r1.setNamaBelakang(in.nextLine());
                isEmpty = false;
                UIFunc.line();
            }
            UIFunc.tampilanUtama();
            input = in.nextInt();
            in.nextLine();
            UIFunc.line();
            if (input == 1){
                r1 = UIFunc.registrasiPelanggan(in, r1);
            } else if (input == 2) {
                r1.makeOrder(in,r1,m1,ph1,po1,b1);
            }
        }while (input != 3);
    }
}