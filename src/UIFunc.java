
public class UIFunc {
    /**
     Hanya mencetak garis " ===== "
     */
    static void line() {
        System.out.println("=====================================================");
    }
    /**
     Menampilkan tampilan awal pada program Percetakan Filkom
     1-Buku;
     2-per Lembar;
     3-Keluar
     */
    static void tampilan(){
        System.out.println("Mau cetak apa hari ini?");
        System.out.println("1. Buku");
        System.out.println("2. per Lembar");
        System.out.println("3. Keluar");
        System.out.print("Pilihan Anda: ");
    }
}