package Classes;

import java.time.LocalDate;
import java.util.Random;

public abstract class Promotion implements Applicable,Comparable {
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
    public boolean isCustomerEligible(Pelanggan pelanggan) {
        return pelanggan.isMember();
    }

    @Override
    public boolean isMinimumPriceEligible(Order order) {
        return order.getTotalHarga()>=50000;
    }

    @Override
    public boolean isShippingFeeEligible(Order order) {
        return order.getTotalHarga() >= 50000;
    }

    @Override
    public double totalCashBack(Order order) {
        return
    }

    @Override
    public double totalDiskon(Order order) {
        return 0;
    }

    @Override
    public double totalOngkir(Order order) {
        return 0;
    }
}