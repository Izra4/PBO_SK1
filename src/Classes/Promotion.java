package Classes;

import java.time.LocalDate;
import java.util.Random;

public abstract class Promotion implements Applicable {
    private int promoCode;
    private LocalDate mulai;
    private LocalDate berakhir;

    public Promotion() {
        Random random = new Random();
        this.promoCode = random.nextInt(100);
        this.mulai = LocalDate.now();
        this.berakhir = LocalDate.now().plusDays(3);
    }

    public int getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(int promoCode) {
        this.promoCode = promoCode;
    }

    public LocalDate getMulai() {
        return mulai;
    }

    public void setMulai(LocalDate mulai) {
        this.mulai = mulai;
    }

    public LocalDate getBerakhir() {
        return berakhir;
    }

    public void setBerakhir(LocalDate berakhir) {
        this.berakhir = berakhir;
    }

    @Override
    public boolean isCustomerEligible() {

        return false;
    }

    @Override
    public boolean isMinimumPriceEligible(Order order) {
        if (order.getTotalHarga()==)

    }

    @Override
    public boolean isShippingFeeEligible(Order order) {
        if (order.)

    }
}
class PotongHarga extends Promotion {
    public PotongHarga() {
        super();
    }
    public double promoDiskon(Order order) throws Exception {
        if (CashBack()<50000) {
            throw new Exception("Minimal Transaksi harus 50000");
    }
        return (int)order.getTotalHarga() *0.01;
    }
}

class CashBack {
    public CashBack() {
        super();
    }
    public double promoCashBack(Order order) throws Exception{
        int cashBack = 0;
        if (order.getTotalHarga()<50000) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else if (order.getTotalHarga()>=50000 && order.getTotalHarga()<75000) {
            cashBack = 3000;
        } else if (order.getTotalHarga()>=75000 && order.getTotalHarga()<10000) {
            cashBack = 5000;
        } else if (order.getTotalHarga()>=100000) {
            cashBack = 7000;
        }
        return cashBack;
    }

}

class PotongOngkir {
    public PotongOngkir() {
        super();
    }
    public double promoOngkir(Order order) throws Exception {
        int totalHarga = order.getTotalHarga();
        int ongkir = order.getOngkir();
        if (totalHarga<25000) {
            throw new Exception("Minimal Transaksi harus 50000");
        }
        return (int)ongkir*0.01;
    }
}
