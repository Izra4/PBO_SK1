import Classes.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Reguler r1 = new Reguler("","","","","",false);
        member m1 = new member(r1.getNamaDepan(), r1.getNamaBelakang(), r1.getAlamat(),r1.getNoTelp(),r1.getEmail(),r1.isMember());
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
                r1.makeOrder(in,r1,m1);
                r1.printJudul();
                r1.printWriter();
                r1.printJenisPaper();
                r1.printJilid();
                System.out.println(r1.pages());
                System.out.println(r1.totalPrice());
            }
        }while (input != 3);
    }
}