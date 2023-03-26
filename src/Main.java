import Handler.UIFunc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input;
        char req;
        System.out.println("======== Selamat Datang di Percetakan Filkom ========");
        do {
            UIFunc.tampilanUtama();
            input = in.nextInt();
            UIFunc.line();
            if (input == 1){
                UIFunc.registMember();
            } else if (input == 2) {
                UIFunc.cetak();
            }
        }while (input != 3);

        System.out.println("Selamat Tinggal");
        System.exit(0);
    }
}
